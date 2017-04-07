package com.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.UserMapper;
import com.blog.model.User;
import com.blog.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper = null;

	@Override
	public int insertUserInfo(User user) {
		// TODO Auto-generated method stub
		return this.userMapper.insert(user);
	}

	@Override
	public User getUserInfo(String userName) {
		// TODO Auto-generated method stub
		return this.userMapper.selectByPrimaryKey(userName);
	}

	@Override
	public int updateUserInfo(User user) {
		// TODO Auto-generated method stub
		return this.userMapper.updateByPrimaryKey(user);
	}
	

}
