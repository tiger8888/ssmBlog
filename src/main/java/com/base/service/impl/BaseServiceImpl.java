package com.base.service.impl;

import com.base.dao.BaseMapper;
import com.base.service.BaseService;
import com.blog.model.UserKey;

public abstract class BaseServiceImpl<T> implements BaseService<T>{
	public abstract BaseMapper<T> getBaseMapper();
	
	/**
	 * 根据 userId 和 userName 删除数据
	 */
	@Override
	public int deleteByPrimaryKey(UserKey key){
		return this.getBaseMapper().deleteByPrimaryKey(key);
	}
	
	/**
	 * 根据 userId  删除数据
	 */
	@Override
	public int deleteByUserId(UserKey key){
		return this.getBaseMapper().deleteByUserId(key);
	}
	
	/**
	 * userName 删除数据
	 */
	@Override
	public int deleteByUserName(UserKey key){
		return this.getBaseMapper().deleteByUserName(key);
	}
	
	/**
	 * 插入数据
	 */
	@Override
    public int insert(T record){
		return this.getBaseMapper().insert(record);
	}

	@Override
    public int insertSelective(T record){
		return this.getBaseMapper().insertSelective(record);
	}
	
	/**
	 * 根据 userId 和 userName 查找数据
	 */
	@Override
    public T selectByPrimaryKey(UserKey key){
		return this.getBaseMapper().selectByPrimaryKey(key);
	}
	
	/**
	 * 根据 userId 查找数据
	 */
	@Override
	public T selectByUserId(UserKey key){
		return this.getBaseMapper().selectByUserId(key);
	}
    
	/**
	 * userName 查找数据
	 */
	@Override
	public T selectByUserName(UserKey key){
    	return this.getBaseMapper().selectByUserName(key);
    }
	
	/**
	 * 更新数据
	 */
	@Override
	public int updateByPrimaryKeySelective(T record){
		return this.getBaseMapper().updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(T record){
		return this.getBaseMapper().updateByPrimaryKey(record);
	}
}
