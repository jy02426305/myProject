package com.cyx.spring.transaction.control;

import com.cyx.spring.transaction.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

@Controller(value = "bookShopControl")
public class BookShopControl {
    @Autowired
    private BookShopService bookShopService;

    public void buyBook(){
        bookShopService.buyBook();
    }

    @Transactional
    public void buyBooks(){
        Map<String,Object> data1=new HashMap<>();
        data1.put("bookName","百年孤独");
        data1.put("stockId",2);
        data1.put("username","张三");
        Map<String,Object> data2=new HashMap<>();
        data2.put("bookName","论语");
        data2.put("stockId",1);
        data2.put("username","张三");
        Queue<Map<String,Object>> queue=new LinkedList();
        queue.add(data2);
        queue.add(data1);

        while (queue.size()>0){
            Map<String,Object> map=queue.poll();
            bookShopService.buyBook2(map);
        }
        queue=null;
    }
}
