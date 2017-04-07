package com.blog.dto;

public class Result<T> {
	/**
	 * 传输数据状态
	 */
	private boolean state;
	
	/**
	 * 传输数据
	 */
	private T data;
	
	/**
	 * 详细信息
	 */
	private String message;

	public boolean isState() {
		return state;
	}

	public Result() {
		super();
	}

	public Result(boolean state, T data, String message) {
		super();
		this.state = state;
		this.data = data;
		this.message = message;
	}

	@Override
	public String toString() {
		return "Result [state=" + state + ", data=" + data + ", message="
				+ message + "]";
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
