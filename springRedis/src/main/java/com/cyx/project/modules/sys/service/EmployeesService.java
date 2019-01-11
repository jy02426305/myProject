package com.cyx.project.modules.sys.service;

import com.cyx.project.common.base.dto.Page;
import com.cyx.project.modules.sys.entity.Employees;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface EmployeesService {
    Employees testGet(int id);

    Employees getEntity(int id);

    Page<Employees> getPage();

    boolean exists(Map.Entry<String,Object> params);

    Employees getByEmpNo(int empNo);
}
