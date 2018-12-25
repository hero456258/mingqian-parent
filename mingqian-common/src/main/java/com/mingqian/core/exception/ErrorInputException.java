package com.mingqian.core.exception;

/**
 * 
 * @ClassName:	ErrorInputException 
 * @Description:验证异常
 *
 */
public class ErrorInputException extends BaseException {
    private static final long serialVersionUID = -1846968432286788402L;

    /**
     * 构造函数。
     */
    public ErrorInputException() {
        super();
    }

    /**
     * 构造函数。
     * @param message 异常消息
     */
    public ErrorInputException(String message) {
        super(message);
    }

    /**
     * 构造函数。
     * @param message 异常消息
     * @param cause 异常致因
     */
    public ErrorInputException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 构造函数。
     * @param cause 异常致因
     */
    public ErrorInputException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数。
     * @param messageCode 异常编码
     * @param message 异常消息
     */
    public ErrorInputException(String messageCode, String message) {
        super(messageCode, message);

    }

    /**
     * 构造函数。
     * @param messageCode 异常编码
     * @param message 异常消息
     * @param cause 异常致因
     */
    public ErrorInputException(String messageCode, String message, Throwable cause) {
        super(messageCode, message, cause);
    }
}
