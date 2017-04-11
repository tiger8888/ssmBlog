package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;








import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.base.controller.BaseController;
import com.blog.model.User;
import com.blog.model.UserKey;
import com.blog.service.UserService;
import com.core.enums.AjaxResult;
import com.core.enums.ResultCode;
import com.core.exception.BlogException;

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
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public ModelAndView userLogin(String userName,String password) throws BlogException{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		if (userName == null || userName.equals("")) {
			AjaxResult.getError(ResultCode.InfoException, "用户名为空");
		}else if (password == null || password.equals("")) {
			AjaxResult.getError(ResultCode.InfoException, "密码为空");
		}
		User user = this.userService.selectByPrimaryKey(new UserKey(userName));
		if (user == null) {
			//return AjaxResult.getError(ResultCode.InfoException, "用户名不存在");
		}else if (!password.equals(user.getPassword())) {
			//return AjaxResult.getError(ResultCode.InfoException, "密码不正确");
		}
		
		modelAndView.addObject("ajaxw", JSON.toJSONString(AjaxResult.getOK(user)));
		
		return modelAndView;
		//return AjaxResult.getOK(user);
	}
	/*
	public AjaxResult userLogin(String userName,String password) throws BlogException{
		User user = this.userService.selectByPrimaryKey(new UserKey(userName));
		if (user == null) {
			return AjaxResult.getError(ResultCode.InfoException, "用户名不存在", null);
		}else if (!password.equals(user.getPassword())) {
			return AjaxResult.getError(ResultCode.InfoException, "密码不正确", null);
		}
		return AjaxResult.getOK(user);
	}*/
	
	/**
	 * 注册
	 * @param userName
	 * @param password
	 * @param nickName
	 * @return
	 */
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public AjaxResult userRegister(String userName,String password,String nickName)throws BlogException{
		User user = this.userService.selectByPrimaryKey(new UserKey(userName));
		if (user != null) {
			return AjaxResult.getError(ResultCode.InfoException, "用户名已存在", null);
		}
		User registerUser = new User(password, nickName);
		registerUser.setUsername(userName);
		int result = this.userService.insertSelective(registerUser);
		if (result <= 0) {
			return AjaxResult.getError(ResultCode.DBException, "注册失败", null);
		}
		return AjaxResult.getOK(user);
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
	public AjaxResult userChangePassword(Integer userId,String userName,String oldPassword,String newPassword)throws BlogException{
		UserKey userKey = new UserKey();
		userKey.setUserid(userId); 
		User user = this.userService.selectByPrimaryKey(userKey);
		if (user == null) {
			return AjaxResult.getError(ResultCode.InfoException, "用户名不存在", null);
		}
		if (!user.getPassword().equals(oldPassword)) {
			return AjaxResult.getError(ResultCode.InfoException, "原密码错误", null);
		}
		user.setPassword(newPassword);
		int result = this.userService.updateByPrimaryKeySelective(user);
		if (result <= 0) {
			return AjaxResult.getError(ResultCode.DBException, "更新失败", null);
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
	public AjaxResult userForgotPassword(Integer userId,String userName,Integer verification,String newPassword)throws BlogException{
		UserKey userKey = new UserKey();
		
		User user = this.userService.selectByPrimaryKey(userKey);
		if (user == null) {
			return AjaxResult.getError(ResultCode.InfoException, "用户名不存在", null);
		}
		/**
		 * 验证码验证没做
		 */
		user.setPassword(newPassword);
		int result = this.userService.updateByPrimaryKeySelective(user);
		if (result <= 0) {
			return AjaxResult.getError(ResultCode.DBException, "更新失败", null);
		}
		return AjaxResult.getOK(user);
	}
}
