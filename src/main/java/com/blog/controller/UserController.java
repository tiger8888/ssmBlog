package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.controller.BaseController;
import com.blog.service.UserService;

@Controller("userController")
@RequestMapping("/user")
public class UserController extends BaseController{
	@Autowired
	private UserService userService = null;
}
