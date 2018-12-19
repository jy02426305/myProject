package com.cyx.project.common.base.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public interface BaseService<T,PK extends Serializable> {
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
     * hql条件查询
     * @param hql
     * @param params
     * @return
     */
    List<T> hqlQueryList(String hql, HashMap<String,Object> params);

    /**
     * sql条件查询
     * @param sql
     * @param objects
     * @return
     */
    List<T> sqlQueryList(String sql,Object[] objects);

    /**
     * sql条件查询
     * @param sql
     * @param params
     * @return
     */
    List<T> sqlQueryList(String sql,HashMap<String,Object> params);
}
