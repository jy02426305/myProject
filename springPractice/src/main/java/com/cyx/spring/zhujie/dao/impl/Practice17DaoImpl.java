package com.cyx.spring.zhujie.dao.impl;

import com.cyx.spring.zhujie.dao.Practice17Dao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.HashMap;
import java.util.Map;

public class Practice17DaoImpl implements Practice17Dao {
    private static JdbcTemplate jdbcTemplate;
    private static NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    static {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:springJdbcTemplate.xml");
        jdbcTemplate=(JdbcTemplate)context.getBean("jdbcTemplate");
        namedParameterJdbcTemplate=(NamedParameterJdbcTemplate)context.getBean("namedParameterJdbcTemplate");
    }
    @Override
    public void addZoo() {
        String sql="insert into zoo (animalName,animalStatus) values (?,?)";
        jdbcTemplate.update(sql,"老虎",1);
    }

    @Override
    public void addZoo2(){
        String sql="insert into zoo (animalName,animalStatus) values (:animalName,:animalStatus)";
        Map<String,Object> parameter=new HashMap<>();
        parameter.put("animalName","猫");
        parameter.put("animalStatus",2);
        namedParameterJdbcTemplate.update(sql,parameter);
    }

    @Override
    public void addZoo3() {
        String sql="insert into zoo (animalName,animalStatus) values (:animalName,:animalStatus)";
        Zoo zoo=new Zoo();
        zoo.setAnimalName("狗");
        zoo.setAnimalStatus(1);
        SqlParameterSource sqlParameter=new BeanPropertySqlParameterSource(zoo);
        namedParameterJdbcTemplate.update(sql,sqlParameter);
    }

    class Zoo{
        private String animalName;
        private int animalStatus;

        public String getAnimalName() {
            return animalName;
        }

        public void setAnimalName(String animalName) {
            this.animalName = animalName;
        }

        public int getAnimalStatus() {
            return animalStatus;
        }

        public void setAnimalStatus(int animalStatus) {
            this.animalStatus = animalStatus;
        }
    }
}
