package com.fyblog.fqgan.event;

import org.springframework.context.ApplicationEvent;

import com.fyblog.fqgan.entity.UserEntity;

/**
 * 登陆事件类
 * @author Administrator
 *
 */
public class LoginEvent extends ApplicationEvent{
	
	UserEntity userEntity;

	public LoginEvent(Object source, UserEntity userEntity) {
		super(source);
		this.userEntity = userEntity;
		
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	
	

}
