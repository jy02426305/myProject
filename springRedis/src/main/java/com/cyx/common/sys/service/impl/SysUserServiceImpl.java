package com.cyx.common.sys.service.impl;

import com.cyx.common.base.service.impl.BaseServiceImpl;
import com.cyx.common.sys.dao.impl.SysUserDaoImpl;
import com.cyx.common.sys.entity.SysUser;
import com.cyx.common.sys.service.SysUserService;
import org.springframework.stereotype.Service;

@Service(value = "sysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUser,Integer> implements SysUserService {
}
