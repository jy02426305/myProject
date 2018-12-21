package com.cyx.project.modules.sys.dao;

import com.cyx.project.common.base.persistence.BaseDao;
import com.cyx.project.modules.sys.entity.Employees;

public interface EmployeesDao extends BaseDao<Employees,Integer> {
    Employees testGet(int id);
}
