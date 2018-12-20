package com.cyx.project.modules.sys.controller;

import com.cyx.project.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;


@Controller
@RequestMapping(value = "/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/list")
    public ModelAndView list(){
        ModelAndView view=new ModelAndView("admin/sysUser/list.jsp");
        try{
//            List<SysUser> list= sysUserService.sqlQueryList("select * from sys_user where id>?",new Object[]{1});
            int total=sysUserService.getCount("select count(1) from (select * from employees where emp_no>?) t",new Object[]{10017});
            System.out.println("总数：" + total);
//            view.addObject("list",list);
        }catch (Exception ex){
            System.out.println(ex);
        }
        return view;
    }
}
