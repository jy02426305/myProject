package com.cyx.project.modules.sys.service.impl;

import com.cyx.project.common.base.dto.Page;
import com.cyx.project.modules.sys.dao.EmployeesDao;
import com.cyx.project.modules.sys.entity.Employees;
import com.cyx.project.modules.sys.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.Map;

@Service(value = "employeesService")
public class EmployeesServiceImpl implements EmployeesService {
    @Autowired
    private EmployeesDao employeesDao;

    @Override
    public Employees testGet(int id) {
        return employeesDao.testGet(id);
    }

    @Override
    public Employees getEntity(int id) {
        return employeesDao.getEntity(id);
    }

    @Override
    public Page<Employees> getPage() {
        return employeesDao.hqlQueryPage(1,10,"empNo>?0",new Object[]{10011});
    }

    @Override
    public boolean exists(Map.Entry<String, Object> param) {
        return employeesDao.exists(param);
    }

    @Override
    public Employees getByEmpNo(int empNo) {
        Map.Entry<String,Object> entry=new AbstractMap.SimpleEntry<>("empNo",empNo);
        return employeesDao.getByColumn(entry);
    }
}
