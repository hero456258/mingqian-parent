package com.mingqian.tools;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Map.Entry;

/**
 * HttpClient工具类
 * @ClassName:	HttpClientUtils 
 * @Description:HttpClient工具类
 *
 */
public class HttpClientUtils {

    private static final String CONTENT_JSON = "application/json";
    private static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    private HttpClient client = null;

    private MultiThreadedHttpConnectionManager connectionManager;

    public HttpClientUtils() {
        this(150, 30000, 30000, null, 0, null, null);
    }

    public HttpClientUtils(int maxConPerHost, int conTimeOutMs, int soTimeOutMs, String proxyHost, int proxyPort,
            String proxyAuthUser, String proxyAuthPassword) {
        connectionManager = new MultiThreadedHttpConnectionManager();
        HttpConnectionManagerParams params = connectionManager.getParams();
        params.setDefaultMaxConnectionsPerHost(maxConPerHost);
        params.setConnectionTimeout(conTimeOutMs);
        params.setSoTimeout(soTimeOutMs);

        HttpClientParams clientParams = new HttpClientParams();
        // 忽略cookie 避免 Cookie rejected 警告
        clientParams.setCookiePolicy(CookiePolicy.IGNORE_COOKIES);
        client = new HttpClient(clientParams, connectionManager);
        Protocol myhttps = new Protocol("https", new MySSLSocketFactory(), 443);
        Protocol.registerProtocol("https", myhttps);
        // 支持proxy
        if (StringUtils.isNotBlank(proxyHost)) {
            client.getHostConfiguration().setProxy(proxyHost, proxyPort);
            client.getParams().setAuthenticationPreemptive(true);
            if (StringUtils.isNotBlank(proxyAuthUser)) {
                client.getState().setProxyCredentials(AuthScope.ANY,
                        new UsernamePasswordCredentials(proxyAuthUser, proxyAuthPassword));
            }
        }
    }

    /**
     * 处理http getmethod请求
     */
    public String get(String url) throws IOException {
        return get(url, null, null);
    }

    public String get(String url, Map<String, String> params, Map<String, String> header) throws IOException {
        if (null != params && params.size() > 0) {
            String encodedParams = HttpClientUtils.encodeParameters(params);
            if (-1 == url.indexOf("?")) {
                url += "?" + encodedParams;
            } else {
                url += "&" + encodedParams;
            }
        }
        GetMethod getmethod = new GetMethod(url);
        setHeaders(getmethod, header);
        return httpRequest(getmethod);
    }

    /**
     * 处理http post请求
     */
    public String post(String url) throws IOException {
        return post(url, null,null);
    }

    public String post(String url,Map<String, String> params) throws IOException {
        return post(url, params,null);
    }

    public String postJson(String url,String jsonString,Map<String, String> header) throws IOException {
        PostMethod postMethod = new PostMethod(url);
        postMethod.setRequestEntity(new StringRequestEntity(jsonString,CONTENT_JSON,"UTF-8"));
        if(!Collections.isEmpty(header)){
            for (Entry<String, String> tmp : header.entrySet()) {
                postMethod.addRequestHeader(tmp.getKey(), tmp.getValue() == null ? "" : tmp.getValue());
            }
        }
        HttpMethodParams param = postMethod.getParams();
        param.setContentCharset("UTF-8");
        return httpRequest(postMethod);
    }

    public String post(String url, Map<String, String> params,Map<String, String> header) throws IOException {
        PostMethod postMethod = new PostMethod(url);
        if (!Collections.isEmpty(params)) {
            for (Entry<String, String> tmp : params.entrySet()) {
                postMethod.addParameter(tmp.getKey(), tmp.getValue() == null ? "" : tmp.getValue());
            }
        }
        if(!Collections.isEmpty(header)){
            for (Entry<String, String> tmp : header.entrySet()) {
                postMethod.addRequestHeader(tmp.getKey(), tmp.getValue() == null ? "" : tmp.getValue());
            }
        }
        HttpMethodParams param = postMethod.getParams();
        param.setContentCharset("UTF-8");
        return httpRequest(postMethod);
    }

    public String httpRequest(HttpMethod method) {
        try {
            method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));
            client.executeMethod(method);
            if (method.getStatusCode() == HttpStatus.SC_OK) {
                return method.getResponseBodyAsString();
            }
        } catch (IOException e) {
            logger.error("Get error!",e);
            return null;
        } finally {
            method.releaseConnection();
        }
        return null;
    }

    /*
     * 对parameters进行encode处理
     */
    public static String encodeParameters(Map<String, String> params) {
        if (params == null || params.size() == 0) {
            return "";
        }
        StringBuffer buf = new StringBuffer();
        for (Entry<String, String> tmp : params.entrySet()) {
            try {
                buf.append("&").append(URLEncoder.encode(tmp.getKey(), "UTF-8")).append("=")
                        .append(URLEncoder.encode(tmp.getValue() == null ? "" : tmp.getValue(), "UTF-8"));
            } catch (java.io.UnsupportedEncodingException neverHappen) {
            }
        }
        String result = buf.toString();
        return result.length() > 0 ? result.substring(1) : result;
    }

    private static GetMethod setHeaders(GetMethod method, Map<String, String> headers) {
        if (Collections.isEmpty(headers)) {
            return method;
        }
        for (Entry<String, String> tmp : headers.entrySet()) {
            method.addRequestHeader(tmp.getKey(), tmp.getValue() == null ? "" : tmp.getValue());
        }
        return method;
    }

}

class MySSLSocketFactory implements ProtocolSocketFactory {
    private SSLContext sslcontext = null;

    private SSLContext createSSLContext() {
        SSLContext sslcontext = null;
        try {
            sslcontext = SSLContext.getInstance("SSL");
            sslcontext.init(null, new TrustManager[] { new TrustAnyTrustManager() }, new java.security.SecureRandom());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return sslcontext;
    }

    private SSLContext getSSLContext() {
        if (this.sslcontext == null) {
            this.sslcontext = createSSLContext();
        }
        return this.sslcontext;
    }

    public Socket createSocket(Socket socket, String host, int port, boolean autoClose) throws IOException {
        return getSSLContext().getSocketFactory().createSocket(socket, host, port, autoClose);
    }

    public Socket createSocket(String host, int port) throws IOException {
        return getSSLContext().getSocketFactory().createSocket(host, port);
    }

    public Socket createSocket(String host, int port, InetAddress clientHost, int clientPort) throws IOException {
        return getSSLContext().getSocketFactory().createSocket(host, port, clientHost, clientPort);
    }

    public Socket createSocket(String host, int port, InetAddress localAddress, int localPort,
            HttpConnectionParams params) throws IOException {
        if (params == null) {
            throw new IllegalArgumentException("Parameters may not be null");
        }
        int timeout = params.getConnectionTimeout();
        SocketFactory socketfactory = getSSLContext().getSocketFactory();
        if (timeout == 0) {
            return socketfactory.createSocket(host, port, localAddress, localPort);
        } else {
            Socket socket = socketfactory.createSocket();
            SocketAddress localAddr = new InetSocketAddress(localAddress, localPort);
            SocketAddress remoteAddr = new InetSocketAddress(host, port);
            socket.bind(localAddr);
            socket.connect(remoteAddr, timeout);
            return socket;
        }
    }

    private static class TrustAnyTrustManager implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[] {};
        }
    }
}