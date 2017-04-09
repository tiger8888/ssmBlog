package com.base.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.blog.model.UserKey;

public interface BaseMapper<T> {
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
    
    List<T> getAllPage(RowBounds rowBounds);
}
