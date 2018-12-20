package com.cyx.project.modules.sys.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@IdClass(SalariesPK.class)
public class Salaries {
    private int empNo;
    private int salary;
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

    @Basic
    @Column(name = "salary", nullable = false)
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Id
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Salaries salaries = (Salaries) o;

        if (empNo != salaries.empNo) return false;
        if (salary != salaries.salary) return false;
        if (fromDate != null ? !fromDate.equals(salaries.fromDate) : salaries.fromDate != null) return false;
        if (toDate != null ? !toDate.equals(salaries.toDate) : salaries.toDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = empNo;
        result = 31 * result + salary;
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        result = 31 * result + (toDate != null ? toDate.hashCode() : 0);
        return result;
    }
}
