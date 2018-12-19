package com.cyx.project.modules.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/home")
public class HomeController {
    @RequestMapping(value = "/say",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String say(){
        return "你好";
    }
}
