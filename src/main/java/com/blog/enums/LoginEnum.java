package com.blog.enums;

public enum LoginEnum {
	SUCCESS(0,"登录成功"),USERPASSWORD_FAILD(1,"登录失败，用户名或密码错误"),SYSTEM_ERROR(-2,"系统异常");
	
	private LoginEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getStateInfo() {
		return stateInfo;
	}
	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}
	private int state;
	private String stateInfo;
	
	public static LoginEnum stateOf(int index){
		for (LoginEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}
}
