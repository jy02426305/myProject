package com.cyx.project.modules.sys.dao.impl;

import com.cyx.project.common.base.persistence.impl.BaseDaoImpl;
import com.cyx.project.modules.sys.dao.SysUserDao;
import com.cyx.project.modules.sys.entity.SysUser;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository(value="sysUserDao")
public class SysUserDaoImpl extends BaseDaoImpl<SysUser,Integer> implements SysUserDao {
}
