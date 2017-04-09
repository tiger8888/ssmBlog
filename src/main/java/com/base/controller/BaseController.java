package com.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.core.exception.BlogException;
import com.core.util.catgetory.StringUtil;

public class BaseController {
	private static Logger logger = Logger.getLogger(BaseController.class);
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	protected Integer getUserId(HttpServletRequest request){
		String userIdString = request.getHeader("userId");
		if (!StringUtil.isEmpty(userIdString)) {
			try {
				Integer userId = StringUtil.toInt(userIdString);
				return userId;
			} catch (NumberFormatException e) {
				// TODO: handle exception
				logger.warn("请求头userId参数格式错误");
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws BlogException
	 */
	protected Integer getNotNullUserId(HttpServletRequest request) throws BlogException{
		Integer userId = getUserId(request);
		if (userId == null) {
			throw new BlogException("用户名不能为空");
		}
		return userId;
	}
}
