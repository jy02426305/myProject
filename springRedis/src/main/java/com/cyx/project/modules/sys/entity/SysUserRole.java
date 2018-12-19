package com.cyx.project.modules.sys.entity;

import javax.persistence.*;

@Entity
@Table(name = "sys_user_role")
public class SysUserRole {
    private int id;

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
