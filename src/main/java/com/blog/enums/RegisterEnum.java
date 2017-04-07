package com.blog.enums;

public enum RegisterEnum {
	SUCCESS(0,"注册成功"),REPEAT_USER(1,"，用户已存在"),SYSTEM_ERROR(-2,"系统异常");
	
	private RegisterEnum(int state, String stateInfo) {
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
	
	public static RegisterEnum stateOf(int index){
		for (RegisterEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}
}
