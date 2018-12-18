package com.cyx.common.sys.controller;

import com.cyx.common.sys.entity.SysUser;
import com.cyx.common.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/list")
    public ModelAndView list(){
        ModelAndView view=new ModelAndView("admin/sysUser/list.jsp");
        try{

            List<SysUser> list= sysUserService.sqlQueryList("select * from sys_user where id>?",new Object[]{1});
            view.addObject("list",list);
        }catch (Exception ex){
            System.out.println(ex);
        }
        return view;
    }
}
