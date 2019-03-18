package com.cyx.project.modules.index.controller;

import com.cyx.project.common.util.DesUtils;
import com.cyx.project.common.util.HttpClientUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping(value="/zdLogin")
    public RedirectView zdLogin(){
        String username=DesUtils.encode("lisi","service,ideatc,com");
        String password=DesUtils.encode("123456","service,ideatc,com");
//        Map params=new HashMap();
//        params.put("username",DesUtils.encode("lisi","service,ideatc,com"));
//        params.put("password", DesUtils.encode("123456","service,ideatc,com"));
//        params.put("loginType","wp");
//        params.put("from","jjzd");
//        String str= HttpClientUtils.ajaxPost("http://localhost:8088/login",params);
//        System.out.println(str);
        return new RedirectView("http://localhost:8088/jjzdLogin?username=lisi&password=123456");
    }
}
