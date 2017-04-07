package com.blog.service;

import com.blog.model.User;

public interface UserService {
	
	/**
	 *  添加一条用户信息
	 * 
	 * @param user 用户信息
	 * @return 1为成功，0为失败
	 */
	int insertUserInfo(User user);
	
	/**
	 * 	获取一条用户信息
	 * @param userName
	 * @return
	 */
	User getUserInfo(String userName);
	
	/**
	 * 更新用户信息
	 * 
	 * @param user
	 * @return 1为成功 0为失败
	 */
	int updateUserInfo(User user);
}
