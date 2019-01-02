package com.cyx.project.modules.sys.controller;

import com.cyx.project.common.base.dto.Page;
import com.cyx.project.common.base.service.BaseService;
import com.cyx.project.common.utils.JedisUtil;
import com.cyx.project.modules.sys.entity.Employees;
import com.cyx.project.modules.sys.entity.SysUser;
import com.cyx.project.modules.sys.service.EmployeesService;
import com.cyx.project.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private EmployeesService employeesService;

    @Autowired
    private RedisTemplate redisTemplate;

//    @Autowired
//    private BaseService<SysUser,Integer> sysUserService;

    @Autowired
    private JedisUtil jedisUtil;

    @RequestMapping(value = "/list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response){
        ModelAndView view=new ModelAndView("admin/sysUser/list.jsp");
        try{
            request.getSession().setAttribute("myName","caiyuanxing");
//            jedisUtil.set("car","banz");
//            System.out.println(redisTemplate.opsForValue().get("wechat"));
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
//            SysUser sysUser= sysUserService.get(1);
//            System.out.println(sysUser.getUsername());

//            System.out.println("权限数量："+sysUserService.testGetSysUser(274));
//            Employees employees = employeesService.testGet(10001);
//            System.out.println(employees.getFirstName());
//            sysUserService.sqlQueryList()
        }catch (Exception ex){
            System.out.println(ex);
        }
        return view;
    }
}
