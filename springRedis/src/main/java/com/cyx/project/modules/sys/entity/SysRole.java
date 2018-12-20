package com.cyx.project.modules.sys.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sys_role")
public class SysRole {
    private int id;
    private String name;
    private String describe;
    private Date createtime;
    private List<SysUserRole> sysUserRoleList;

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "describe", nullable = true, length = 100)
    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Basic
    @Column(name = "createtime", nullable = true)
    @Temporal(value =TemporalType.TIMESTAMP )
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Basic
    @OneToMany(mappedBy = "sysRole")
    public List<SysUserRole> getSysUserRoleList() {
        return sysUserRoleList;
    }

    public void setSysUserRoleList(List<SysUserRole> sysUserRoleList) {
        this.sysUserRoleList = sysUserRoleList;
    }
}
