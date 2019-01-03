package com.cyx.project.modules.sys.service.impl;

import com.cyx.project.modules.sys.dao.SysUserDao;
import com.cyx.project.modules.sys.entity.SysUser;
import com.cyx.project.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public int testGetSysUser(int id){
        return sysUserDao.get(id).getSysUserRoleList().size();
    }
}
