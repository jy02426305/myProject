package com.cyx.project.modules.sys.dao.impl;

import com.cyx.project.common.base.persistence.impl.BaseDaoImpl;
import com.cyx.project.modules.sys.dao.SysUserDao;
import com.cyx.project.modules.sys.entity.SysUser;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository(value="sysUserDao")
public class SysUserDaoImpl extends BaseDaoImpl<SysUser,Integer> implements SysUserDao {
}
