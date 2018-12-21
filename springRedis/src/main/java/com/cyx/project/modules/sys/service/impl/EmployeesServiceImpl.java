package com.cyx.project.modules.sys.service.impl;

import com.cyx.project.modules.sys.dao.EmployeesDao;
import com.cyx.project.modules.sys.entity.Employees;
import com.cyx.project.modules.sys.service.EmployeesService;
import org.springframework.stereotype.Service;

@Service(value = "employeesService")
public class EmployeesServiceImpl implements EmployeesService {
    private EmployeesDao employeesDao;

    @Override
    public Employees testGet(int id) {
        return employeesDao.testGet(id);
    }
}
