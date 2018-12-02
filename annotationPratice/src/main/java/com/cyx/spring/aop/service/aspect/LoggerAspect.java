package com.cyx.spring.aop.service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1) //执行优先级，值越小，优先级越高
public class LoggerAspect {
    @Pointcut("execution(* com.cyx.spring.aop.*.*.*(..))")
    private void myPointcut() {
    }

    @Before(value="myPointcut()")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("beforeMethod...");
    }

    @AfterReturning(value="myPointcut()",returning="reval")
    public void afterReturningMetod(JoinPoint joinPoint,String reval) {
        System.out.println("afterReturningMetod...return value："+reval);
    }

    @Around("myPointcut()")
    public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around（before method），methodName："+pjp.getSignature().getName());
        Object obj = pjp.proceed();
        System.out.println("around(after method)");
        return obj;
    }

    @AfterThrowing(value="myPointcut()",throwing="ex")
    public void afterThrowing(JoinPoint joinpoint,Exception ex){
        System.out.println("this method name:" + joinpoint.getSignature().getName() + ",occurs:" + ex.getMessage());
    }

}
