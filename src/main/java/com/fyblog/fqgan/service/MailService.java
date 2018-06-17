package com.fyblog.fqgan.service;


public interface MailService {
	void sendMail(String msg);
	
	void login(String userName, String password);

}
