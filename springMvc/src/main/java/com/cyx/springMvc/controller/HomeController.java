package com.cyx.springMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.awt.SunHints;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

    @RequestMapping(value = "/index")
    public ModelAndView index(){
        System.out.println("this page is home page");
        ModelAndView mav=new ModelAndView();
        mav.setViewName("/view/home/index.jsp");
        mav.addObject("msg","hello world");
        return mav;
    }

    @RequestMapping(value = "/getModel")
    @ResponseBody
    public String getModel(Integer id){
        return "获取id："+id;
    }

    @RequestMapping(value = "/getNames")
    @ResponseBody
    public String[] getNames(){
        return new String[]{"张三","李四","王五"};
    }
}
