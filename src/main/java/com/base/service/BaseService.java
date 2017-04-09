package com.base.service;

import com.blog.model.UserKey;

public interface BaseService<T> {
	int deleteByPrimaryKey(UserKey key);

	int deleteByUserId(UserKey key);
	
	int deleteByUserName(UserKey key);
	
    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(UserKey key);

    T selectByUserId(UserKey key);
    
    T selectByUserName(UserKey key);
    
    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
