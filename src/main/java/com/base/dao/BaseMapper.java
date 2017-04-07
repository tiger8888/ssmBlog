package com.base.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

public interface BaseMapper<T> {
	int deleteByPrimaryKey(String username);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
    
    List<T> getAllPage(RowBounds rowBounds);
}
