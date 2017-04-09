package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import com.base.controller.BaseController;
import com.blog.model.User;
import com.blog.service.UserService;

@Controller
@RequestMapping("/login")
public class UserController extends BaseController{
	@Autowired
	private UserService userService = null;
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public String getUserInfo(Model model){
		User usernameString = this.userService.selectByPrimaryKey("wq");
		
		model.addAttribute("user", usernameString);
		return "user";
	}
}
