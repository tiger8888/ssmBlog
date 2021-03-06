package com.core.enums;

public class AjaxResult {
	
	/**
	 * 结果码,默认为成功值0
	 */
	private String code = ResultCode.SUCCESS.getCode();
	
	/**
	 * 请求返回信息,默认为执行成功
	 */
	private String message = ResultCode.SUCCESS.getMessage();
	
	/**
	 * 请求结果数据
	 */
	private Object data = null;

	/**
	 * 获取正确结果
	 * @return
	 */
	public static AjaxResult getOK(String message,Object data){
		AjaxResult ajaxResult = new AjaxResult(message, data);
		return ajaxResult;
	}
	
	public static AjaxResult getOK(Object data){
		AjaxResult ajaxResult = new AjaxResult(data);
		return ajaxResult;
	}
	
	public static AjaxResult getOK(){
		return getOK(null);
	}
	/**
	 * 
	 * @param resultCode
	 * @param message
	 * @param data
	 * @return
	 */
	public static AjaxResult getError(ResultCode resultCode,String message,Object data){
		return new AjaxResult(resultCode.getCode(),message,data);
	}
	
	/**
	 * 
	 * @param resultCode
	 * @return
	 */
	public static AjaxResult getError(ResultCode resultCode) {
		return getError(resultCode,resultCode.getMessage(),null);
	}
	
	/**
	 * 
	 * @param resultCode
	 * @param data
	 * @return
	 */
	public static AjaxResult getError(ResultCode resultCode,String message){
		return getError(resultCode,message,null);
	}
	/**
	 * getter、setter、toString 构造方法
	 */
	
	@Override
	public String toString() {
		return "AjaxResult [code=" + code + ", message=" + message + ", data="
				+ data + "]";
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public AjaxResult() {
		super();
	}
	
	/**
	 * 
	 * @param data
	 */
	public AjaxResult(Object data) {
		super();
		this.data = data;
	}
	
	public AjaxResult(String message,Object data){
		super();
		this.message = message;
		this.data = data;
	}
	/**
	 * 
	 * 
	 * @param code
	 * @param message
	 * @param data
	 */
	public AjaxResult(String code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}
}
