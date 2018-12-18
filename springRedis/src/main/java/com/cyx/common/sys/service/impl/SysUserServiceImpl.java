package com.cyx.common.sys.service.impl;

import com.cyx.common.sys.dao.impl.SysUserDaoImpl;
import com.cyx.common.sys.service.SysUserService;
import org.springframework.stereotype.Service;

@Service(value = "sysUserService")
public class SysUserServiceImpl extends SysUserDaoImpl implements SysUserService {
}
