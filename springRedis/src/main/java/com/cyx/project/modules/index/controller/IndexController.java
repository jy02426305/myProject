package com.cyx.project.modules.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/login")
    public String login(){
        return "admin/login.jsp";
    }

    @RequestMapping(value = "/main")
    public String main(){
        return "admin/main.jsp";
    }
}
