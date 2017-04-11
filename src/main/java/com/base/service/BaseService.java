package com.base.service;

import com.blog.model.UserKey;

public interface BaseService<T> {
	int deleteByPrimaryKey(UserKey key);
	
    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(UserKey key);
    
    int updateByPrimaryKeySelective(T record);
}
