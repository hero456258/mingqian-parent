function removeCookie(name) {

    var cval = getCookie(name);
    if (cval != null) {
        $.cookie(name, '', {expires: -1, domain: web.cookieDomain, path: '/'});
    }

    window.location.href = web.basePath + "/login/toLogin";

}

function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
    if (arr = document.cookie.match(reg))
        return unescape(arr[2]);
    else
        return null;
}