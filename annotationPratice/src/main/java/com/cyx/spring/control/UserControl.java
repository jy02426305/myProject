package com.cyx.spring.control;

import com.cyx.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller(value="userControl")
public class UserControl {
    @Autowired(required = false)
    private UserService userService;

    public void say(){
        if(userService!=null){
            userService.sayUser();
            userService.sayOrder();
        }
    }

    public void showSelf() {
        System.out.println("UserControl showSelf...");
    }
}
