package com.cyx.spring.transaction.control;

import com.cyx.spring.transaction.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller(value = "bookShopControl")
public class BookShopControl {
    @Autowired
    private BookShopService bookShopService;

    public void buyBook(){
        bookShopService.buyBook();
    }
}
