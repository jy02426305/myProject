package com.cyx.common.base.persistence;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T,PK extends Serializable> {
    Session getSession();

    T get(PK id);

    T load(PK id);

    PK save(T entity);

    void delete(T entity);

    void delete(PK id);

    void update(T entity);

    void saveOrUpdate(T entity);

    /**
     * 批量添加
     * @param entityList
     */
    void batchSave(List<T> entityList);

    /**
     * 批量删除
     * @param entityList
     */
    void batchDelete(List<T> entityList);

    /**
     * 批量更新
     * @param entityList
     */
    void batchUpdate(List<T> entityList);

    /**
     * 条件查询
     * @param hql
     * @param objects
     * @return
     */
    List<T> hqlQueryList(String hql,Object[] objects);

    /**
     * sql条件查询
     * @param sql
     * @param objects
     * @return
     */
    List<T> sqlQueryList(String sql,Object[] objects);
}