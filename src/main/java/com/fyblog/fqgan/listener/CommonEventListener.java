package com.fyblog.fqgan.listener;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.fyblog.fqgan.event.EmailEvent;
import com.fyblog.fqgan.event.LoginEvent;

/**
 * 鐩稿叧浜嬩欢鐩戝惉绫�
 * @author Administrator
 *
 */
@Component
public class CommonEventListener {
	
	@EventListener
	public void sendMail(EmailEvent emailEvent) {
		System.out.println("鍙戦�侀偖浠�: " + emailEvent.getMsg());
		System.out.println("鍙戦�侀偖浠�: " + emailEvent.getMsg());
	}
	
	@EventListener
	@Async
	public void login(LoginEvent loginEvent) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("鐢ㄦ埛鐧婚檰: 鐢ㄦ埛鍚�=" + loginEvent.getUserEntity().getUserName() + "瀵嗙爜=" + loginEvent.getUserEntity().getPassword());
	}
	
	

}
