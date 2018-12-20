package com.cyx.project.common.base.persistence;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.HashMap;
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
     * hql条件查询
     * @param hql
     * @param params
     * @return
     */
    List<T> hqlQueryList(String hql, HashMap<Integer, Object> params);

    /**
     * hql条件查询
     * @param hql
     * @param params
     * @return
     */
    List<T> hqlQueryListByParamName(String hql, HashMap<String, Object> params);

    /**
     * sql条件查询
     * @param sql
     * @param params
     * @return
     */
    List<T> sqlQueryList(String sql, Object[] params);

    /**
     * sql条件查询
     * @param sql
     * @param params
     * @return
     */
    List<T> sqlQueryListByParamName(String sql, HashMap<String, Object> params);

    /**
     * sql查询总记录数
     * @param sql
     * @param params
     * @return
     */
    int sqlQueryCount(String sql, Object[] params);

    /**
     * sql查询总记录数
     * @param sql
     * @param params
     * @return
     */
    int sqlQueryCountByParamName(String sql,HashMap<String,Object> params);
}