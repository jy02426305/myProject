package com.cyx.spring.InitializingBeanPractice;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component(value = "testClass")
public class TestClass implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("你好");
    }

    public void say(){
        System.out.println("hello");
    }
}
