package com.cyx.project.modules.sys.dao.impl;

import com.cyx.project.common.base.persistence.impl.BaseDaoImpl;
import com.cyx.project.modules.sys.dao.EmployeesDao;
import com.cyx.project.modules.sys.entity.Employees;
import org.springframework.stereotype.Repository;

@Repository(value = "employeesDao")
public class EmployeesDaoImpl extends BaseDaoImpl<Employees,Integer> implements EmployeesDao {
}
