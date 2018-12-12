package control;

import org.springframework.context.ApplicationContext;
import service.PersonService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Hello extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        //1.从application域对象中得到IOC容器的引用
        ServletContext servletContext=getServletContext();
        ApplicationContext context=(ApplicationContext)servletContext.getAttribute("ApplicationContext");

        //2.从IOC容器中得到需要的bean
        PersonService personService=(PersonService)context.getBean("personService");
        personService.say();
    }
}
