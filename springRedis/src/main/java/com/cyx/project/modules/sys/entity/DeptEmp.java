package com.cyx.project.modules.sys.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "dept_emp", schema = "ideatc_service", catalog = "")
@IdClass(DeptEmpPK.class)
public class DeptEmp {
    private int empNo;
    private String deptNo;
    private Date fromDate;
    private Date toDate;

    @Id
    @Column(name = "emp_no", nullable = false)
    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    @Id
    @Column(name = "dept_no", nullable = false, length = 4)
    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    @Basic
    @Column(name = "from_date", nullable = false)
    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    @Basic
    @Column(name = "to_date", nullable = false)
    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}
