package com.cyx.spring.zhujie.control;

import com.cyx.spring.zhujie.service.impl.DogFood;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
FactoryBean   spring提供的配置bean工厂类
 */
public class Practice15Control {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring.xml");
        DogFood dogFood=(DogFood)context.getBean("practice15ServiceImpl");
        System.out.println(dogFood.getTaste());
    }
}
