package com.cyx.hibernate.control;

import com.cyx.hibernate.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller(value = "bookShopControl")
public class BookShopControl {

    @Autowired
    private BookShopService bookShopService;

    public void buyBooks() {
        bookShopService.buyBook("论语",1,"张三");
        bookShopService.buyBook("百年孤独",2,"张三");
    }
}
