package com.cyx.project.modules.sys.controller;

import com.cyx.project.common.util.SpringContextUtils;
import com.cyx.project.modules.sys.entity.SysUser;
import com.cyx.project.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/list")
    public ModelAndView list(){
        SysUserService sysUserService= SpringContextUtils.getBean("sysUserService",SysUserService.class);
        ModelAndView view=new ModelAndView("admin/sysUser/list.jsp");
        try{
//            List<SysUser> list= sysUserService.sqlQueryList("select * from sys_user where id>?",new Object[]{1});
            List<SysUser> list= sysUserService.hqlQueryList("select sysUser from SysUser sysUser where id>?",new Object[]{1});

            view.addObject("list",list);
        }catch (Exception ex){
            System.out.println(ex);
        }
        return view;
    }
}
