package com.cyx;

import static org.junit.Assert.assertTrue;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void shiroTest(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //2.解析配置文件，并且返回一些SecurityManger实例
        SecurityManager securityManager=factory.getInstance();
        //3.将SecurityManager绑定给SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        // 安全操作，Subject是当前登录的用户
        Subject currentUser=SecurityUtils.getSubject();
        // 测试在应用的当前会话中设置属性
        Session session = currentUser.getSession();
        session.setAttribute("name","caiyuanxing");
        System.out.println(session.getAttribute("name"));


        //4判断是否登录过
        if (!currentUser.isAuthenticated()) {
            //5.登录
            try {
                AuthenticationToken token=new UsernamePasswordToken("zhangsan","666");
                currentUser.login(token);
                if (currentUser.hasRole("role1")) {
                    System.out.println("当前用户角色role1");
                }
                currentUser.logout();
                if(!currentUser.isAuthenticated()){
                    System.out.println("用户登出");
                }
            }catch (UnknownAccountException uae){
                System.out.println("用户不存在");
            }catch (IncorrectCredentialsException ice){
                System.out.println("密码错误");
            }catch (LockedAccountException lae){
                System.out.println("用户被锁了");
            }catch (AuthenticationException ae){
                System.out.println("未知错误");
            }
        }else{
            System.out.println("还未登录");
        }
    }

    @Test
    public void customRealms(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realms.ini");
        //2.解析配置文件，并且返回一些SecurityManger实例
        SecurityManager securityManager=factory.getInstance();
        //3.将SecurityManager绑定给SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        // 安全操作，Subject是当前登录的用户
        Subject currentUser=SecurityUtils.getSubject();

        //4判断是否登录过
        if (!currentUser.isAuthenticated()) {
            //5.登录
            try {
                AuthenticationToken token=new UsernamePasswordToken("zhangsan","666");
                currentUser.login(token);
                System.out.println("登录成功");
            }catch (UnknownAccountException uae){
                System.out.println("用户不存在");
            }catch (IncorrectCredentialsException ice){
                System.out.println("密码错误");
            }catch (LockedAccountException lae){
                System.out.println("用户被锁了");
            }catch (AuthenticationException ae){
                System.out.println("未知错误");
            }
        }else{
            System.out.println("还未登录");
        }
    }

    @Test
    public void customPasswordRealms(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-cryptography.ini");
        //2.解析配置文件，并且返回一些SecurityManger实例
        SecurityManager securityManager=factory.getInstance();
        //3.将SecurityManager绑定给SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        // 安全操作，Subject是当前登录的用户
        Subject currentUser=SecurityUtils.getSubject();

        //4判断是否登录过
        if (!currentUser.isAuthenticated()) {
            //5.登录
            try {
                String username="zhangsan";
                String password="666";//会根据shiro-cryptography.ini中定义的加密算法生成新的字符串再去比对
                AuthenticationToken token=new UsernamePasswordToken(username,password);
                currentUser.login(token);
                System.out.println("登录成功");
            }catch (UnknownAccountException uae){
                System.out.println("用户不存在");
            }catch (IncorrectCredentialsException ice){
                System.out.println("密码错误");
            }catch (LockedAccountException lae){
                System.out.println("用户被锁了");
            }catch (AuthenticationException ae){
                System.out.println("未知错误");
            }
        }else{
            System.out.println("还未登录");
        }
    }

    @Test
    public void hasRoleTest(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-permission.ini");
        //2.解析配置文件，并且返回一些SecurityManger实例
        SecurityManager securityManager=factory.getInstance();
        //3.将SecurityManager绑定给SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        // 安全操作，Subject是当前登录的用户
        Subject currentUser=SecurityUtils.getSubject();

        //4判断是否登录过
        if (!currentUser.isAuthenticated()) {
            //5.登录
            try {
                AuthenticationToken token=new UsernamePasswordToken("lisi","888");
                currentUser.login(token);
                System.out.println("登录成功");

                if (currentUser.hasRole("role1")) {
                    System.out.println("我有role1权限");
                }

                if (currentUser.hasAllRoles(Arrays.asList("role1","role2"))) {
                    System.out.println("我有role1、role2权限");
                }

                System.out.println("我role1和role2的对应权限结果："+Arrays.toString(currentUser.hasRoles(Arrays.asList("role1", "role2"))));

                try{
                    //判断当前用户是否拥有某个角色，如果没有该角色，报异常：UnauthorizedException
                    currentUser.checkRole("role1");
                }catch (UnauthorizedException e){
                    System.out.println("我没有role1角色");
                }
                try{
                    //判断当前用户是否拥有某个角色，如果没有该角色，报异常：UnauthorizedException
                    currentUser.checkRole("role2");
                    System.out.println("我有role2角色");
                }catch (UnauthorizedException e){
                    System.out.println("我没有role2角色");
                }
                try{
                    //判断当前用户是否拥有某个角色，如果没有该角色，报异常：UnauthorizedException
                    currentUser.checkRoles("role1","role2");
                }catch (UnauthorizedException e){
                    System.out.println("我没有role1或role2角色");
                }

                if (currentUser.isPermitted("user:delete")) {
                    System.out.println(" 我有delete权限");
                }else{
                    System.out.println("我没有delete权限");
                }

                System.out.println("我delete和read权限情况：" + Arrays.toString(currentUser.isPermitted("user:delete","user:read")));

                System.out.println("我是否有create和 read权限" + currentUser.isPermittedAll("user:create", "user:read"));

                try{
                    currentUser.checkPermission("user:create");
                    System.out.println("我有create权限");
                }catch (AuthorizationException e){
                    System.out.println("我没有create权限");
                }

                try{
                    currentUser.checkPermission("user:read");
                    System.out.println("我有read权限");
                }catch (AuthorizationException e){
                    System.out.println("我没有read权限");
                }

            }catch (UnknownAccountException uae){
                System.out.println("用户不存在");
            }catch (IncorrectCredentialsException ice){
                System.out.println("密码错误");
            }catch (LockedAccountException lae){
                System.out.println("用户被锁了");
            }catch (AuthenticationException ae){
                System.out.println("未知错误");
            }
        }else{
            System.out.println("还未登录");
        }
    }
}
