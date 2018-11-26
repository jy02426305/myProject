package com.cyx.spring.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class Practice12ServiceImpl implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean的后置处理(init之前)："+bean+"，beanName："+beanName);
        //可以修改bean后返回
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean的后置处理(init之后)："+bean+"，beanName："+beanName);
        //可以修改bean后返回
        return bean;
    }
}
