package com.base.service;

public interface BaseService<T> {
	int deleteByPrimaryKey(String username);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
