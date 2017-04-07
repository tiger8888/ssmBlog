package com.base.service.impl;

import com.base.dao.BaseMapper;
import com.base.service.BaseService;

public abstract class BaseServiceImpl<T> implements BaseService<T>{
	public abstract BaseMapper<T> getBaseMapper();
	
	@Override
	public int deleteByPrimaryKey(String username){
		return this.getBaseMapper().deleteByPrimaryKey(username);
	}
	@Override
    public int insert(T record){
		return this.getBaseMapper().insert(record);
	}
	
	@Override
    public int insertSelective(T record){
		return this.getBaseMapper().insertSelective(record);
	}
	
	@Override
    public T selectByPrimaryKey(String username){
		return this.getBaseMapper().selectByPrimaryKey(username);
	}
	
	@Override
	public int updateByPrimaryKeySelective(T record){
		return this.getBaseMapper().updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(T record){
		return this.getBaseMapper().updateByPrimaryKey(record);
	}
}
