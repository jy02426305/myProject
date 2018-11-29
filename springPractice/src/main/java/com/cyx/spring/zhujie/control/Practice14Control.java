package com.cyx.spring.zhujie.control;

import com.cyx.spring.zhujie.service.AnimalService;
import com.cyx.spring.zhujie.service.impl.CatServiceImpl;
import com.cyx.spring.zhujie.service.impl.DogServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
实例工厂方法
 */
public class Practice14Control {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring.xml");

        AnimalService dog=(DogServiceImpl)context.getBean("dogIns");
        AnimalService cat=(CatServiceImpl)context.getBean("catIns");
        dog.call();
        cat.call();
    }
}
