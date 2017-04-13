package com.core.enums;

public enum ResultCode {
	 /**
     * 成功. ErrorCode : 0
     */
    SUCCESS("0","成功"),
    /**
     * 未知异常. ErrorCode : 01
     */
    UnknownException("01","未知异常"),
    /**
     * 系统异常. ErrorCode : 02
     */
    SystemException("02","系统异常"),
    /**
     * 业务错误. ErrorCode : 03
     */
    MyException("03","业务错误"),
    /**
     * 提示级错误. ErrorCode : 04
     */
    InfoException("04", "提示级错误"),
    /**
     * 数据库操作异常. ErrorCode : 020001
     */
    DBException("020001","数据库操作异常"),
    /**
     * 参数验证错误. ErrorCode : 040001
     */
    ParamException("040001","参数验证错误");
	private String message;
	private String code;

	public String getMessage() {
		return message;
	}

	public String getCode() {
		return code;
	}

	private ResultCode( String code,String message) {
		this.message = message;
		this.code = code;
	}
	
	public static ResultCode getCodeMessage(String code){
		for (ResultCode resultCode : ResultCode.values()) {
			if (resultCode.getCode().equals(code)) {
				return resultCode;
			}
		}
		return null;
	}
}
