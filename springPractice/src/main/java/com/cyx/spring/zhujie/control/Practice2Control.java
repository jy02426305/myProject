package com.cyx.spring.zhujie.control;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring DI（bean成员赋值）
 */
public class Practice2Control {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        AnimalControl animalControl = (AnimalControl) context.getBean("animalControl");
        animalControl.call();

//        TestClass tc = new TestClass();//内部静态类可实例化
//        tc.ss();
    }

//    private static class TestClass {
//        private Practice2Control p;
//        public void ss() {
//            System.out.println("1");
//        }
//    }
}
