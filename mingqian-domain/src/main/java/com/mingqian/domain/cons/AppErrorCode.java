package com.mingqian.domain.cons;

/**
 * Created by wanggang on 2018/12/21.
 */
public enum AppErrorCode {

    SC_OK(0,"成功"),

    SYS_ERROR(-1,"系统错误！"),

    ERROR_INPUT(-2,"参数校验失败！"),

    ERROR_NEED_LOGIN(-3,"用户未登录！"),

    ORDER_FINISHED(-4,"订单已处理！"),

    ORDER_IS_EMPTY(-5,"订单不存在"),

    ORDER_CANCEL_LIMIT(-6,"订单已支付，取消订单请联系客服"),

    ORDER_PAYING(-7,"订单支付中，请稍后"),

    APP_NEW_VERSION(-12,"新版本升级"),

    NOT_FOUND(-404,"NOT FOUND！"),

    SMS_LIMIT_501(-101,"当日短信发送次数达到限额"),

    SMS_SYS_ERROR(-102,"短信发送失败"),

    SMS_CACHE_EXPIRED(-103,"验证码已过期"),

    SAFECODE_NOT_MATCH(-104,"验证码不匹配"),

    LOGIN_ERROR(-201,"用户名或密码错误"),

    NORMAL_USER_EMPTY(-202,"用户不存在或已被冻结"),

    PAY_CODE_EMPTY(-203,"未设置支付密码"),

    PAY_CODE_NOT_MATCH(-204,"支付密码不匹配"),

    USER_IS_EMPTY(-205,"该用户未注册"),

    EMPTY_BINDER(-206,"三方账户未绑定"),

    CASH_EMPTY_MOVE(-207,"当前账户可用资产不足，不支持转移"),

    OLD_REALNAME_NOT_AUTH(-208,"请在当前版本完成实名认证操作"),

    NEW_REALNAME_NOT_AUTH(-209,"请下载新版App并绑定本人银行卡"),

    MOVE_USER_ACCOUNT_MATCH_ERROR(-210,"账户实名认证信息不匹配"),

    REAL_NAME_NOT_AUTH(-211,"当前用户未通过实名认证"),

    OLD_RNORMAL_USER_EMPTY(-212,"老版本用户不存在"),

    REAL_NAME_AUTH_ERROR(-301,"证件号与真实姓名不匹配！"),

    BANK_NOT_MATCH(-302,"银行卡信息不匹配"),

    BIND_CARD_NAME_NOT_MATCH(-303,"不能绑定他人银行卡"),

    BANK_CARD_NOT_FOUND(-304,"银行卡信息不存在"),

    DRAW_MONEY_LIMIT(-305,"提现额度受限"),

    SALE_OIL_OVER_LIMIT(-306,"售油额度超出当日限额"),

    OIL_NOT_ENOUGH(-307,"油量账户不足"),

    PRODUCT_ALREADY_PAYBACK(-308,"产品已兑付"),

    PRODUCT_NOT_END(-309,"产品未到期"),

    BANK_CARD_NO_BINDED(-310,"银行卡已被绑定"),

    CERT_NO_MULTI_ERROR(-311,"证件号已被占用！"),

    USER_ACCOUNT_STATUS_ERROR(-312,"账户状态异常！"),

    METHOD_NOT_ALLOW(-405,"请求方法不支持！"),

    MOBILE_IS_REGISTED(-1001,"手机号已被注册"),

    MOBILE_NOT_FOUND(-1002,"手机号不存在"),

    ACCOUNT_MONEY_NOT_ENOUGH(-1101,"账户余额不足"),

    GOODS_IS_EMPTY(-1200,"商品不存在或已下架"),

    OIL_RECHAGE_VAILD(-1301,"中石油系统维护，暂停服务"),

    OIL_DATEBIG_VAlUE(-1302,"超出锁价时间"),

    USER_COIN_CARD(-1401,"易付卡已存在"),

    USER_COIN_CARDS(-1401,"易付卡卡号不存在"),

    POS_UPDATE_LOGIN_FAIL(-1305,"修改失败，请重试"),

    OIL_RECHARGE_LIMITED(-1303,"即时充值30天内每人限充1000元"),

    EMP_EMPTY_ERROR(-1400,"员工信息不存在！"),

    MERCHANT_EMPTY_ERROR(-1401,"商户信息不存在！"),

    OIL_CARD_EMPTY_ERROR(-1402,"加油卡号不存在！"),

    OIL_CARD_LOST_ERROR(-1403,"加油卡已挂失，不可用"),

    OIL_CARD_NO_BINDER_ERROR(-1404,"加油卡未绑定易油卡账户"),

    OIL_CARD_BINDER_DISABLED_ERROR(-1405,"加油卡绑定账户已禁用"),

    /**
     * 商户备付金金额不足
     */
    MERCHANT_MONEY_NOT_ENOUGH(-1406,"商户异常，交易失败！"),

    ORDER_TRADE_LIMIT(-1407,"订单处理中，请勿重复交易");

    private Integer code;
    private String msg;

    AppErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
