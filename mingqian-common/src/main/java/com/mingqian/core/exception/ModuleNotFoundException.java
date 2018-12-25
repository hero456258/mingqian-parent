package com.mingqian.core.exception;

/**
 * 
 * @ClassName:	ModuleNotFoundException 
 * @Description:模块未找到异常
 */
public class ModuleNotFoundException extends BaseException {
    private static final long serialVersionUID = -1846968432286788402L;

    /**
     * 构造函数。
     */
    public ModuleNotFoundException() {
        super();
    }

    /**
     * 构造函数。
     * @param message 异常消息
     */
    public ModuleNotFoundException(String message) {
        super(message);
    }

    /**
     * 构造函数。
     * @param message 异常消息
     * @param cause 异常致因
     */
    public ModuleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 构造函数。
     * @param cause 异常致因
     */
    public ModuleNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数。
     * @param messageCode 异常编码
     * @param message 异常消息
     */
    public ModuleNotFoundException(String messageCode, String message) {
        super(messageCode, message);

    }

    /**
     * 构造函数。
     * @param messageCode 异常编码
     * @param message 异常消息
     * @param cause 异常致因
     */
    public ModuleNotFoundException(String messageCode, String message, Throwable cause) {
        super(messageCode, message, cause);
    }
}
