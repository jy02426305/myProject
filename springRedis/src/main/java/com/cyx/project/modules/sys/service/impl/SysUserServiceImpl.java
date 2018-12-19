package com.cyx.project.modules.sys.service.impl;

import com.cyx.project.common.base.service.impl.BaseServiceImpl;
import com.cyx.project.modules.sys.entity.SysUser;
import com.cyx.project.modules.sys.service.SysUserService;
import org.springframework.stereotype.Service;

@Service(value = "sysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUser,Integer> implements SysUserService {
}
