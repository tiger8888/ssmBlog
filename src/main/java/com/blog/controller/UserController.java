package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.controller.BaseController;
import com.blog.model.User;
import com.blog.model.UserKey;
import com.blog.service.UserService;
import com.core.enums.AjaxResult;
import com.core.enums.ResultCode;
import com.core.exception.BlogException;
import com.core.util.base.RegexUtils;
import com.core.util.base.StringUtils;

@Controller("loginController")
@RequestMapping("/user")
public class UserController extends BaseController{
	@Autowired
	private UserService userService = null;
	
	/**
	 * 登录
	 * @param userName
	 * @param password
	 * @return
	 * @throws BlogException
	 */
	@RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public AjaxResult userLogin(@RequestBody User user) throws BlogException{
		if (StringUtils.isEmpty(user.getUsername())) {
			return AjaxResult.getError(ResultCode.InfoException, "用户名为空");
		}else if (StringUtils.isEmpty(user.getPassword())) {
			return AjaxResult.getError(ResultCode.InfoException, "密码为空");
		}
		User newUser = this.userService.selectByPrimaryKey(new UserKey(user.getUsername()));
		if (newUser == null) {
			return AjaxResult.getError(ResultCode.InfoException, "用户名不存在");
		}else if (!user.getPassword().equals(newUser.getPassword())) {
			return AjaxResult.getError(ResultCode.InfoException, "密码不正确");
		}
		return AjaxResult.getOK(newUser);
	}
	
	/**
	 * 注册
	 * @param userName
	 * @param password
	 * @param nickName
	 * @return
	 */
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult userRegister(String userName,String password,String nickName)throws BlogException{
		if (StringUtils.isEmpty(userName)) {
			return AjaxResult.getError(ResultCode.InfoException, "用户名为空");
		}else if (StringUtils.isEmpty(password)) {
			return AjaxResult.getError(ResultCode.InfoException, "密码为空");
		}
		User user = this.userService.selectByPrimaryKey(new UserKey(userName));
		
		if (user != null) {
			return AjaxResult.getError(ResultCode.InfoException, "用户名已存在");
		}
		User registerUser = new User(password, nickName);
		registerUser.setUsername(userName);
		int result = this.userService.insertSelective(registerUser);
		if (result <= 0) {
			return AjaxResult.getError(ResultCode.DBException, "注册失败");
		}
		return AjaxResult.getOK(this.userService.selectByPrimaryKey(new UserKey(userName)));
	}
	
	/**
	 * 修改密码
	 * @param userId
	 * @param userName
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	@RequestMapping(value = "/changePassword",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult userChangePassword(String userId,String userName,String oldPassword,String newPassword)throws BlogException{
		if (StringUtils.isEmpty(userName) && StringUtils.isEmpty(userId)) {
			return AjaxResult.getError(ResultCode.InfoException, "用户名为空");
		}else if (!StringUtils.isEmpty(userId)) {
			if (!RegexUtils.isInteger(userId)) {
				return AjaxResult.getError(ResultCode.InfoException, "用户ID格式错误");
			}
		}else if (StringUtils.isEmpty(oldPassword) || StringUtils.isEmpty(newPassword)) {
			return AjaxResult.getError(ResultCode.InfoException, "密码为空");
		}
		UserKey userKey = new UserKey();
		userKey.setUserid(StringUtils.isEmpty(userId) ? null : Integer.parseInt(userId)); 
		userKey.setUsername(StringUtils.isEmpty(userName) ? null :userName);
		User user = this.userService.selectByPrimaryKey(userKey);
		if (user == null) {
			return AjaxResult.getError(ResultCode.InfoException, "用户名不存在");
		}
		if (!user.getPassword().equals(oldPassword)) {
			return AjaxResult.getError(ResultCode.InfoException, "原密码错误");
		}
		user.setPassword(newPassword);
		int result = this.userService.updateByPrimaryKeySelective(user);
		if (result <= 0) {
			return AjaxResult.getError(ResultCode.DBException, "更新失败");
		}
		return AjaxResult.getOK(user);
	}
	
	/**
	 * 根据验证码找回密码或修改密码
	 * @param userId
	 * @param userName
	 * @param verification
	 * @param newPassword
	 * @return
	 */
	@RequestMapping(value = "/forgotPassword",method = RequestMethod.POST)
	public AjaxResult userForgotPassword(String userId,String userName,String verification,String newPassword)throws BlogException{
		if (StringUtils.isEmpty(userName) && StringUtils.isEmpty(userId)) {
			return AjaxResult.getError(ResultCode.InfoException, "用户名为空");
		}else if (!StringUtils.isEmpty(userId)) {
			if (!RegexUtils.isInteger(userId)) {
				return AjaxResult.getError(ResultCode.InfoException, "用户ID格式错误");
			}	
		}
		else if (StringUtils.isEmpty(verification)) {
			return AjaxResult.getError(ResultCode.InfoException, "验证码为空");
		}else if (StringUtils.isEmpty(newPassword)) {
			return AjaxResult.getError(ResultCode.InfoException, "密码为空");
		}
		UserKey userKey = new UserKey();
		
		userKey.setUserid(StringUtils.isEmpty(userId) ? null : Integer.parseInt(userId)); 
		userKey.setUsername(StringUtils.isEmpty(userName) ? null :userName);
		
		User user = this.userService.selectByPrimaryKey(userKey);
		if (user == null) {
			return AjaxResult.getError(ResultCode.InfoException, "用户名不存在");
		}
		/**
		 * 验证码验证没做
		 */
		user.setPassword(newPassword);
		int result = this.userService.updateByPrimaryKeySelective(user);
		if (result <= 0) {
			return AjaxResult.getError(ResultCode.DBException, "更新失败");
		}
		return AjaxResult.getOK(user);
	}
}
