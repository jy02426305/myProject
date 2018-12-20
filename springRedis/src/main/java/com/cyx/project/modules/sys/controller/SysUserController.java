package com.cyx.project.modules.sys.controller;

import com.cyx.project.common.base.dto.Page;
import com.cyx.project.common.base.service.BaseService;
import com.cyx.project.modules.sys.entity.Employees;
import com.cyx.project.modules.sys.entity.SysUser;
import com.cyx.project.modules.sys.service.EmployeesService;
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

    @Autowired
    private EmployeesService employeesService;

//    @Autowired
//    private BaseService<SysUser,Integer> sysUserService;

    @RequestMapping(value = "/list")
    public ModelAndView list(){
        ModelAndView view=new ModelAndView("admin/sysUser/list.jsp");
        try{
//            List<SysUser> list= sysUserService.sqlQueryList("select * from sys_user where id>?",new Object[]{1});
//            view.addObject("list",list);
//            int total=sysUserService.sqlQueryCount("select count(1) from (select * from sys_user where id>?) t",new Object[]{1});
//            System.out.println("总数：" + total);
//            Page<Employees> page=employeesService.sqlQueryPage("select * from employees where emp_no>?",new Object[]{10050},50,20);
//            System.out.println(page.getCount());

            //分页
//            HashMap<String,Object> params=new HashMap<>();
//            params.put("emp_no",10050);
//            Page<Employees> page=employeesService.sqlQueryPageByParamName("select * from employees where emp_no>:emp_no",params,50,20);
//            System.out.println(page.getCount());

            //级联
            SysUser sysUser= sysUserService.get(274);
            System.out.println(sysUser.getSysUserRoleList().size());
        }catch (Exception ex){
            System.out.println(ex);
        }
        return view;
    }
}
