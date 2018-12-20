package com.cyx.project.modules.sys.entity;

import sun.awt.SunHints;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sys_user_role")
public class SysUserRole {
    private int id;
    private SysUser sysUser;
    private SysRole sysRole;

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
    @ManyToOne
    @JoinColumn(name="userId")
    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    @Basic
    @ManyToOne
    @JoinColumn(name="roleId")
    public SysRole getSysRole() {
        return sysRole;
    }

    public void setSysRole(SysRole sysRole) {
        this.sysRole = sysRole;
    }
}
