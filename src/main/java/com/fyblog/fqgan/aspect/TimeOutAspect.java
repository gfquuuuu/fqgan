package com.fyblog.fqgan.aspect;

import static org.hamcrest.CoreMatchers.nullValue;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * 
 * @author Administrator
 *
 */

@Aspect
@Component
public class TimeOutAspect {
	@Pointcut("@annotation(com.fyblog.fqgan.annotation.TimeOut)")
	public void pointcut() {
		
	}
	
	@Before("pointcut()")
	public void TestBefore(JoinPoint joinPoint) {
		System.out.println("前置通知" + joinPoint.getArgs()[0]);
	}
	@After("pointcut()")
	public void TestAfter(JoinPoint joinPoint) {
		System.out.println("后置通知" + joinPoint.getArgs()[0]);
	}
	
	@Around("pointcut()")
	public Object around(ProceedingJoinPoint joinPoint) {
		System.out.println("环绕通知1");
		Object object = null;
		
		try {
			object = joinPoint.proceed();
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		
		System.out.println("环绕通知2");
		return object;
		
	}

}
