package control;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SpringServletContextListener  implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //1.获取Spring配置文件名称
        ServletContext servletContext=servletContextEvent.getServletContext();
        String config=servletContext.getInitParameter("contextConfigLocation");

        //2.创建IOC容器
        ApplicationContext context=new ClassPathXmlApplicationContext(config);

        //3.把IOC容器放在ServletContext的一个属性中
        servletContext.setAttribute("ApplicationContext",context);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
