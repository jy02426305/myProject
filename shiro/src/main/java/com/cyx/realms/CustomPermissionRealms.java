package com.cyx.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.ArrayList;
import java.util.List;

public class CustomPermissionRealms extends AuthorizingRealm {
    @Override
    public String getName() {
        return "MyRealms";
    }

    /**
     *
     * @param principalCollection 用户认证凭证信息：SimpleAuthenticationInfo：认证方法返回封装认证信息中第一个参数：用户信息（username/user）
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //当前登录用户信息：用户凭证
        String username=(String) principalCollection.getPrimaryPrincipal();

        //模拟查询数据库：查询用户事先指定的角色，以及用户权限
        List<String> roles=new ArrayList<>();//角色集合
        List<String> permission=new ArrayList<>();//权限集合
        //假设用户在数据库中有role1角色
        roles.add("role2");
        //假设角色拥有user:create权限
        permission.add("user:create");

        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addRoles(roles);
        info.addStringPermissions(permission);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username=(String) authenticationToken.getPrincipal();
        String password=String.valueOf((char[])authenticationToken.getCredentials());
        if (!username.equals("zhangsan")) {
            return null;
        }
        //参数1：明文  参数2：盐  参数3：散列次数
        Md5Hash md5Hash=new Md5Hash("666",username,3);
        // 模拟数据库中保存的密码
        String dbPassword=md5Hash.toString();
        //表示realms登录比对信息：参数1：用户信息（真实登录中是登录对象user对象），参数2：数据库中的密码，参数3：盐，参数4：当前realms名称
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, dbPassword, ByteSource.Util.bytes(username), getName());
        return simpleAuthenticationInfo;
    }
}
