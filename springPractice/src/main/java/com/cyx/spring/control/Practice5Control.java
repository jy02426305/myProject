package com.cyx.spring.control;

import com.cyx.spring.service.Practice5Service;
import com.cyx.spring.service.impl.DogServiceImpl;
import com.cyx.spring.service.impl.Practice5ServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 复杂类型注入
 */
public class Practice5Control {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring.xml");
        Practice5ServiceImpl practice5ServiceImpl=(Practice5ServiceImpl)context.getBean("practice5ServiceImpl");
        List list=practice5ServiceImpl.getList();
        Map map=practice5ServiceImpl.getMap();
        Properties properties=practice5ServiceImpl.getProp();
        int[] intAry=practice5ServiceImpl.getIntAry();

        System.out.println(((DogServiceImpl)list.get(2)).getSound());
        System.out.println(((DogServiceImpl)map.get("王五")).getSound());
        System.out.println(properties.get("张三"));
        System.out.println(intAry[0]);
        System.out.println(practice5ServiceImpl.getDog().getSound());
    }
}
