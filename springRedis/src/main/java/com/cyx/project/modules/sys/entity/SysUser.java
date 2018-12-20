package com.cyx.project.modules.sys.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "sys_user")
public class SysUser implements Serializable {
    private int id;
    private String username;
    private String password;
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
    @Column(name = "username", nullable = true, length = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @OneToMany(mappedBy = "sysUser",fetch = FetchType.LAZY)
    public List<SysUserRole> getSysUserRoleList() {
        return sysUserRoleList;
    }

    public void setSysUserRoleList(List<SysUserRole> sysUserRoleList) {
        this.sysUserRoleList = sysUserRoleList;
    }
}
