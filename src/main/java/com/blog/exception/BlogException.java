package com.blog.exception;


@SuppressWarnings("serial")
public class BlogException extends RuntimeException{
	
	public BlogException(String message){
		super(message);
	}
	
	public BlogException(Throwable throwable){
		super(throwable);
	}
	
	public BlogException(String message,Throwable throwable){
		super(message, throwable);
	}
}
