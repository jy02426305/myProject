package com.cyx.spring.zhujie.aspect;

import org.aspectj.lang.JoinPoint;

import java.util.ArrayList;

public class LoggerAspect {
    public void beforeMethod(JoinPoint joinPoint){
        System.out.println("this method name:" + joinPoint.getSignature().getName());
    }
}
