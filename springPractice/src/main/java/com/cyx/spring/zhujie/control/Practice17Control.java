package com.cyx.spring.zhujie.control;

import com.cyx.spring.zhujie.service.Practice17Service;
import com.cyx.spring.zhujie.service.impl.Practice17ServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/*
数据库连接spring JdbcTemplate
 */
public class Practice17Control {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:springJdbcTemplate.xml");
//        DataSource dataSource= context.getBean(DataSource.class);

        Practice17Service practice17Service=(Practice17ServiceImpl)context.getBean("practice17Service");
//        practice17Service.addZoo();
//        practice17Service.addZoo2();
        practice17Service.addZoo3();
    }

}
