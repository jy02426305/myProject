package com.cyx.spring.zhujie.control;

import com.cyx.spring.zhujie.service.Practice18Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 声明式事务
 */
public class Practice18Control {
    private  Practice18Service practice18Service;

    public Practice18Service getPractice18Service() {
        return practice18Service;
    }

    public void setPractice18Service(Practice18Service practice18Service) {
        this.practice18Service = practice18Service;
    }

    public void buyBook2(){
        List<Map<String,Object>> list=new ArrayList<>();
        Map<String,Object> map1=new HashMap<>();
        map1.put("bookName","论语");
        map1.put("stockId",1);
        Map<String,Object> map2=new HashMap<>();
        map2.put("bookName","百年孤独");
        map2.put("stockId",2);
        list.add(map1);
        list.add(map2);
        for (Map<String, Object> stringObjectMap : list) {
            practice18Service.buyBook2(stringObjectMap.get("bookName").toString(),(int)stringObjectMap.get("stockId"));
        }
    }
}
