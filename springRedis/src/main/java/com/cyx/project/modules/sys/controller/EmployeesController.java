package com.cyx.project.modules.sys.controller;

import com.cyx.project.common.base.dto.Page;
import com.cyx.project.modules.sys.entity.Employees;
import com.cyx.project.modules.sys.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/employees")
public class EmployeesController {

    @Autowired
    private EmployeesService employeesService;

    @RequestMapping(value = "testMethod1", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String testMethod1() {
        try {
            Employees employees = employeesService.getEntity(10003);
            System.out.println(employees.getFirstName());
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return "哈哈";
    }

    @RequestMapping(value = "testMethod2", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String testMethod2() {
        Page<Employees> page=employeesService.getPage();
        System.out.println(page.getCount());
        return "咩";
    }
}
