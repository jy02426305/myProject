package com.cyx.project.controller;

import com.cyx.project.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/home")
public class HomeController {
    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/say")
    @ResponseBody
    public String say(){
        return memberService.testMethod1("hello");
    }
}
