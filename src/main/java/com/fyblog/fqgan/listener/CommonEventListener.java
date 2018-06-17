package com.fyblog.fqgan.listener;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.fyblog.fqgan.event.EmailEvent;
import com.fyblog.fqgan.event.LoginEvent;

/**
 * 相关事件监听类
 * @author Administrator
 *
 */
@Component
public class CommonEventListener {
	
	@EventListener
	public void sendMail(EmailEvent emailEvent) {
		System.out.println("发送邮件: " + emailEvent.getMsg());
	}
	
	@EventListener
	@Async
	public void login(LoginEvent loginEvent) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("用户登陆: 用户名=" + loginEvent.getUserEntity().getUserName() + "密码=" + loginEvent.getUserEntity().getPassword());
	}
	
	

}
