package com.fyblog.fqgan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fyblog.fqgan.annotation.TimeOut;
import com.fyblog.fqgan.service.MailService;

@SpringBootApplication
@EnableScheduling
@RestController
public class FqganApplication {
	@Autowired
	MailService mailService;

	public static void main(String[] args) {
		SpringApplication.run(FqganApplication.class, args);
	}
	
	@RequestMapping("/{str}")
	@TimeOut
	public String hello(@PathVariable("str") String str) {
		System.out.println("hello world");
		return str;
	}
	
	@Scheduled(fixedRate = 100000)
	public void tests() {
		System.out.println("定时任务");
		
	}
	
	@RequestMapping("/email/{str}")
	public String sendMail(@PathVariable("str") String msg) {
		System.out.println("========开发发送邮件============");
		mailService.sendMail(msg);
		System.out.println("========邮件发送完毕============");
		return msg;
	}
	
	@RequestMapping("/login/{name}/{password}")
	public String logins(@PathVariable("name") String userName, @PathVariable("password") String password) {
		System.out.println("login");
		mailService.login(userName, password);
		return userName + " " + password;
	}
}
