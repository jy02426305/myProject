package com.cyx.realms;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class CustomRealms extends AuthorizingRealm {

    @Override
    public String getName() {
        return "MyRealms";
    }

    //授权操作
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证操作
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
//        String username = usernamePasswordToken.getUsername();
//        String password =String.valueOf(usernamePasswordToken.getPassword());

        String username=(String) authenticationToken.getPrincipal();
        if (!username.equals("zhangsan")) {
            return null;
        }
        //模拟数据库中的密码字段
        String dbPassword="666";
        //表示realms登录比对信息
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, dbPassword, getName());
        return simpleAuthenticationInfo;
    }
}
