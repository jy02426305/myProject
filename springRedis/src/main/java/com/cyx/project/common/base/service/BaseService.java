package com.cyx.project.common.base.service;

import com.cyx.project.common.base.dto.Page;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
@Deprecated
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

    /**
     * sql分页分页查询
     * @param sql
     * @param params
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Page<T> sqlQueryPage(String sql, Object[] params, int pageIndex, int pageSize);

    /**
     * sql分页分页查询
     * @param sql
     * @param params
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Page<T> sqlQueryPageByParamName(String sql,HashMap<String,Object> params,int pageIndex,int pageSize);
}
