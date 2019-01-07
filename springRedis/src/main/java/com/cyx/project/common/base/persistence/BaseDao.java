package com.cyx.project.common.base.persistence;

import com.cyx.project.common.base.dto.Page;
import com.mysql.cj.QueryResult;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
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

    /******************************HQL******************************/
    /**
     * 分页获取所有记录
     * @return
     */
    public Page<T> hqlQueryPage();
    /**
     * 分页获取记录
     * @param firstResult 开始索引,如果输入值为-1,即获取全部数据
     * @param maxResult 每页获取的记录数,如果输入值为-1,即获取全部数据
     * @return
     */
    public Page<T> hqlQueryPage(int firstResult, int maxResult);
    /**
     * 分页获取记录
     * @param firstResult 开始索引,如果输入值为-1,即获取全部数据
     * @param maxResult 每页获取的记录数,如果输入值为-1,即获取全部数据
     * @param orderby 排序,Key为排序属性,Value为asc/desc,如:
     *  LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
    orderby.put("email", "asc");
    orderby.put("password", "desc");
     * @return
     */
    public Page<T> hqlQueryPage(int firstResult, int maxResult, LinkedHashMap<String, String> orderby);
    /**
     * 分页获取记录
     * @param firstResult 开始索引,如果输入值为-1,即获取全部数据
     * @param maxResult 每页获取的记录数,如果输入值为-1,即获取全部数据
     * @param where 条件语句,不带where关键字,条件语句只能使用位置参数,位置参数的索引值以1开始,如:o.username=?1 and o.password=?2
     * @param params 条件语句出现的位置参数值
     * @return
     */
    public Page<T> hqlQueryPage(int firstResult, int maxResult, String where, Object[] params);
    /**
     * 分页获取记录
     * @param firstResult 开始索引,如果输入值为-1,即获取全部数据
     * @param maxResult 每页获取的记录数,如果输入值为-1,即获取全部数据
     * @param where 条件语句,不带where关键字,条件语句只能使用位置参数,位置参数的索引值以1开始,如:o.username=?1 and o.password=?2
     * @param params 条件语句出现的位置参数值
     * @param orderby 排序,Key为排序属性,Value为asc/desc,如:
     *  LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
    orderby.put("email", "asc");
    orderby.put("password", "desc");
     * @return
     */
    public Page<T> hqlQueryPage(int firstResult, int maxResult, String where, Object[] params, LinkedHashMap<String, String> orderby);
}