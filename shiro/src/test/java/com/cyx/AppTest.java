package com.cyx;

import static org.junit.Assert.assertTrue;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

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
}
