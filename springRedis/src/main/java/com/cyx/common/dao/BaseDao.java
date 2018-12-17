package com.cyx.common.dao;

import org.hibernate.Session;

import java.util.List;

public interface BaseDao<T,PK> {
    Session getSession();

    T get(PK id);

    T load(PK id);

    PK save(T entity);

    void delete(T entity);

    void deleteById(PK id);

    void update(T entity);

    void saveOrUpdate(T entity);

    void batchSave(List<T> entityList);

    void batchDelete(List<T> entityList);

    void batchUpdate(List<T> entityList);

    List<T> hqlQueryList(String hql,Object[] objects);

    List<T> sqlQueryList(String sql,Object[] objects);
}
