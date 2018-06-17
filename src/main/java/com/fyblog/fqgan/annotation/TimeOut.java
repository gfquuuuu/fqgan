package com.fyblog.fqgan.annotation;

import static org.mockito.Mockito.CALLS_REAL_METHODS;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TimeOut {
	String value() default "1000";
}
