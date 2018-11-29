package com.cyx.spring.zhujie.control;

import com.cyx.spring.zhujie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller(value="userControl")
@Lazy(value=true) //延迟加载，有使用到UserControl才生成对象（单例）
public class UserControl {
    @Autowired(required = false)
    private UserService userService;

    public void say(){
        if(userService!=null){
            userService.sayUser();
            userService.sayOrder();
        }
    }

    public UserControl(){
        System.out.println("UserControl 构造函数...");
    }

    public void showSelf() {
        System.out.println("UserControl showSelf...");
    }
}
