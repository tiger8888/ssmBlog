package com.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.dao.BaseMapper;
import com.base.service.impl.BaseServiceImpl;
import com.blog.dao.UserMapper;
import com.blog.model.User;
import com.blog.service.UserService;

@Service("user")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
	@Autowired
	private UserMapper userMapper = null;

	@Override
	public BaseMapper<User> getBaseMapper() {
		// TODO Auto-generated method stub
		return userMapper;
	}

}
