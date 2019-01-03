package com.cyx.project.modules.sys.service;

import com.cyx.project.modules.sys.entity.Employees;
import org.springframework.stereotype.Service;

public interface EmployeesService{
    Employees testGet(int id);

    Employees getEntity(int id);
}
