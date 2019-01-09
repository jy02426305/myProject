package com.cyx.shiro.servlet;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="loginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req,resp);
//        String username=req.getParameter("username");
//        String password=req.getParameter("password");
//        if(username!=null && username.equals("zhangsan") && password.equals("123456")){
//            req.setAttribute("username",username);
//            req.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(req,resp);
//        }else{
//            if(username!=null){
//                req.setAttribute("errMsg","帐号或密码有误");
//            }
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req,resp);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //如果登录失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
        String exceptionClassName=(String)req.getAttribute("shiroLoginFailure");
        if(exceptionClassName!=null){
            if(UnknownAccountException.class.getName().equals(exceptionClassName)){
                req.setAttribute("errMsg","用户不存在");
            }else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)){
                req.setAttribute("errMsg","密码错误");
            }else if(LockedAccountException.class.getName().equals(exceptionClassName)){
                req.setAttribute("errMsg","用户被锁");
            }else{
                req.setAttribute("errMsg","未知错误");
            }
        }
        //此方法不处理登录成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
        //登录失败还是到login页面
        req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req,resp);
    }
}
