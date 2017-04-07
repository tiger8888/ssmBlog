package com.blogTest.User;

import global.BaseTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.blog.model.User;
import com.blog.service.UserService;

public class LoginModularTest extends BaseTest{
	@Autowired
	private UserService userService = null;
	
	/*@Test
	public void testLogin(){
		User user = new User("wwq", "wq");
		User selectResult = this.userService.getUserInfo(user.getUsername());
		
		if (selectResult == null) {
			System.out.println("用户不存在");
		}else if (selectResult.getPassword().equals(user.getPassword())) {
			System.out.println("登录成功");
		}else {
			System.out.println("密码错误");
		}
		
	}*/
	/*
	@Test
	public void testRegister(){
		User user = new User("wqq", "wqq");
		User selectResult = this.userService.getUserInfo(user.getUsername());
		if (selectResult == null) {
			int result = this.userService.insertUserInfo(user);
			if (result > 0) {
				System.out.println("注册成功");
			}else {
				System.out.println("注册失败");
			}
		}else {
			System.out.println("用户已存在");
		}
	}
	
	/**
	 * 
	 */
	@Test
	public void testChangePassword(){
		User user = new User("wq", "wq");
		String newPassword = "qq";
		User selectResult = this.userService.selectByPrimaryKey(user.getUsername());
		if (selectResult == null) {
			System.out.println("用户不存在");
		}else if (selectResult.getPassword().equals(user.getPassword())) {
			user.setPassword(newPassword);
			int result = this.userService.updateByPrimaryKey(user);
			if (result > 0) {
				System.out.println("修改密码成功");
			}else {
				System.out.println("修改密码失败");
			}
			
		}else {
			System.out.println("原密码错误");
		}
	}
	
	@Test
	public void testForgotPassword(){
		
	}
}
