package com.cyx.common.sys.dao.impl;

import com.cyx.common.base.persistence.impl.BaseDaoImpl;
import com.cyx.common.sys.dao.SysUserDao;
import com.cyx.common.sys.entity.SysUser;
import org.springframework.stereotype.Repository;

@Repository(value="sysUserDao")
public class SysUserDaoImpl extends BaseDaoImpl<SysUser,Integer> implements SysUserDao {
}
