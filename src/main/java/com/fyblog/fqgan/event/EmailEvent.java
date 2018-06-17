package com.fyblog.fqgan.event;

import org.springframework.context.ApplicationEvent;

/**
 * 邮件发送事件
 * @author Administrator
 *
 */
public class EmailEvent extends ApplicationEvent{
	
	private String msg;

	public EmailEvent(Object source, String msg) {
		super(source);
		this.msg = msg;
		
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
