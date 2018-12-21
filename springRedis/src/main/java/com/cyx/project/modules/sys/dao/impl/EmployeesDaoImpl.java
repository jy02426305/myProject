package com.cyx.project.modules.sys.dao.impl;

import com.cyx.project.common.base.persistence.impl.BaseDaoImpl;
import com.cyx.project.modules.sys.dao.EmployeesDao;
import com.cyx.project.modules.sys.entity.Employees;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

@Repository(value = "employeesDao")
public class EmployeesDaoImpl extends BaseDaoImpl<Employees,Integer> implements EmployeesDao {

    @Override
    public Employees testGet(int id){
        String sql="select * from employeesDao where emp_no=?";
        NativeQuery<Employees> nativeQuery = super.getSession().createNativeQuery(sql, Employees.class);
        nativeQuery.setParameter(1,id);
        Employees employees = nativeQuery.uniqueResult();
        return employees;
    }
}
