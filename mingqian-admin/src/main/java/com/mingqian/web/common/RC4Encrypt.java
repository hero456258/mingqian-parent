package com.mingqian.web.common;


import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * Created by wanggang on 2018/10/17.
 *加密、解密工具类
 */
public class RC4Encrypt {
    public static String Encrypt(String data, String password) throws UnsupportedEncodingException {
        if (data == null || password == null)
            return null;
        byte[] baseData = Base64.encodeBase64(doOption(data.getBytes("utf-8"),password));
        return new String(baseData);
    }

    public static String Decrypt(String data, String pass)
            throws UnsupportedEncodingException {
        if (data == null || pass == null)
            return null;
        byte[] result = doOption(Base64.decodeBase64(data.getBytes("utf-8")), pass);
        return result != null ? new String(result, "utf-8") : null;
    }

    public static byte[] doOption(byte[] data, String password) {
        if (data == null || password == null)
            return null;
        byte[] output = new byte[data.length];
        int i = 0;
        int j = 0;
        byte[] mBox = GetKey(password.getBytes(), 256);
        // 加密
        for (int offset = 0; offset < data.length; offset++) {
            i = (i + 1) % mBox.length;
            j = (j + tranceByte(mBox[i])) % mBox.length;
            Byte temp = mBox[i];
            mBox[i] = mBox[j];
            mBox[j] = temp;
            byte a = data[offset];
            // Byte b = mBox[(mBox[i] + mBox[j] % mBox.Length) % mBox.Length];
            // mBox[j] 一定比 mBox.Length 小，不需要在取模
            byte b = mBox[(tranceByte(mBox[i]) + tranceByte(mBox[j]))
                    % mBox.length];
            output[offset] = (byte) ((int) tranceByte(a) ^ (int) tranceByte(b));
        }
        return output;
    }

    /**
     *
     * @Title:GetKey
     * @Description:打乱密码
     * @param:@param 密码
     * @param:@param 密码长度
     * @param:@return
     * @return:byte[]
     * @throws
     */
    private static byte[] GetKey(byte[] pass, int kLen) {
        byte[] mBox = new byte[kLen];
        for (int i = 0; i < kLen; i++) {
            mBox[i] = (byte) i;
        }
        int j = 0;
        for (int i = 0; i < kLen; i++) {
            j = (j + tranceByte(mBox[i]) + pass[i % pass.length]) % kLen;
            byte temp = mBox[i];
            mBox[i] = mBox[j];
            mBox[j] = temp;
        }
        return mBox;
    }

    /**
     * 字节转换
     *
     * @return
     */
    private static int tranceByte(byte b) {
        int r = b < 0 ? b + 256 : b;
        return r;
    }
}
