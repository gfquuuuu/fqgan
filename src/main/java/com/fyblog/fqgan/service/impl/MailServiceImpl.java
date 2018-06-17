package com.fyblog.fqgan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.fyblog.fqgan.entity.UserEntity;
import com.fyblog.fqgan.event.EmailEvent;
import com.fyblog.fqgan.event.LoginEvent;
import com.fyblog.fqgan.service.MailService;

@Service
public class MailServiceImpl implements MailService{
	
	@Autowired
	ApplicationContext applicationContext;

	@Override
	public void sendMail(String msg) {
		
		applicationContext.publishEvent(new EmailEvent(this, msg));
	}

	@Override
	public void login(String userName, String password) {
		
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName(userName);
		userEntity.setPassword(password);
		
		applicationContext.publishEvent(new LoginEvent(this, userEntity));
		
	}

}
