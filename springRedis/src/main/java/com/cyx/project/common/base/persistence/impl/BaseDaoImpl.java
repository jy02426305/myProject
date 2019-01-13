package com.cyx.project.common.base.persistence.impl;

import com.cyx.project.common.base.dto.Page;
import com.cyx.project.common.base.persistence.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.*;

public class BaseDaoImpl<T,PK extends Serializable> implements BaseDao<T,PK> {
    private final static int BATCH_SIZE = 50;

    @Autowired
    private SessionFactory sessionFactory;
    // 存储泛型的实际参数
    private Class<T> clazz;
    public BaseDaoImpl(){
        // 谁实现该类，这就是谁的类字节码
        Class c = this.getClass();
        // 返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type
        Type type = c.getGenericSuperclass();
        // 将类型强转为参数化类型
        ParameterizedType pType = (ParameterizedType) type;
        // 获取该类的父类的所有实际类型参数，也就是泛型的实际参数
        // 这里也就是获取BaseDaoImpl的实际类型参数
        Type[] actualTypeArguments = pType.getActualTypeArguments();
        // 将实际类型参数赋值给成员变量
        clazz = (Class<T>) (actualTypeArguments[0]);
    }

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public T get(PK id){
        return getSession().get(clazz,id);
    }

    /**
     * 查询一级缓存中是否有该对象， 有就返回缓存的对象。无则返回只有id属性的代理对象
     * @param id
     * @return
     */
    @Override
    public T load(PK id){
        return getSession().load(clazz,id);
    }

    @Override
    public PK save(T entity){
        return (PK)getSession().save(entity);
    }

    @Override
    public void delete(T entity){
        getSession().delete(entity);
    }

    @Override
    public void delete(PK id){
        getSession().delete(get(id));
    }

    @Override
    public void update(T entity){
        getSession().update(entity);
    }

    @Override
    public void saveOrUpdate(T entity){
        getSession().saveOrUpdate(entity);
    }

    @Override
    public T getByColumn(Map.Entry<String,Object> param){
        Assert.notNull(param,"参数不可为空");
        String hql="select o from "+clazz.getSimpleName()+" o where "+param.getKey()+"=?1";
        Query query=getSession().createQuery(hql);
        query.setParameter(1,param.getValue());
        List<T> list=query.list();
        if(list==null || list.size()==0){
            return null;
        }
        Assert.isTrue(list.size()==1,"结果不是唯一");
        T entity=list.get(0);
        return entity;
    }

    @Override
    public boolean exists(Map.Entry<String,Object> param){
        Assert.notNull(param,"参数不可为空");
        Query queryCount = getSession().createQuery("select count(1) from "
                + clazz.getSimpleName() + " o" + " where "+param.getKey()+"=?0");
        queryCount.setParameter(0,param.getValue());
        Long count = (Long) queryCount.uniqueResult();
        return count>0?true:false;
    }

    /**
     * 批量添加
     * @param entityList
     */
    @Override
    public void batchSave(List<T> entityList){
        for(int i=0,len=entityList.size();i<len;i++){
            getSession().save(entityList.get(i));
            if(i%BATCH_SIZE==0){
                getSession().flush();//与数据库数据同步
                getSession().clear();//清除内部缓存的全部数据，及时释放出占用的内存
            }
        }
        if(entityList.size()%BATCH_SIZE!=0){
            getSession().flush();//与数据库数据同步
            getSession().clear();//清除内部缓存的全部数据，及时释放出占用的内存
        }
    }

    /**
     * 批量删除
     * @param entityList
     */
    @Override
    public void batchDelete(List<T> entityList){
        for(int i=0,len=entityList.size();i<len;i++){
            getSession().delete(entityList.get(i));
            if(i%BATCH_SIZE==0){
                getSession().flush();//与数据库数据同步
                getSession().clear();//清除内部缓存的全部数据，及时释放出占用的内存
            }
        }
        if(entityList.size()%BATCH_SIZE!=0){
            getSession().flush();//与数据库数据同步
            getSession().clear();//清除内部缓存的全部数据，及时释放出占用的内存
        }
    }

    /**
     * 批量更新
     * @param entityList
     */
    @Override
    public void batchUpdate(List<T> entityList){
        for(int i=0,len=entityList.size();i<len;i++){
            getSession().update(entityList.get(i));
            if(i%BATCH_SIZE==0){
                getSession().flush();//与数据库数据同步
                getSession().clear();//清除内部缓存的全部数据，及时释放出占用的内存
            }
        }
        if(entityList.size()%BATCH_SIZE!=0){
            getSession().flush();//与数据库数据同步
            getSession().clear();//清除内部缓存的全部数据，及时释放出占用的内存
        }
    }

    /**
     * hql条件查询，hql语句占位符必须要 ?0 带索引值的形式（蛋疼的改动）
     * @param hql
     * @param params
     * @return
     */
    @Override
    public List<T> hqlQueryList(String hql,HashMap<Integer,Object> params){
        Query query = getSession().createQuery(hql);
        if(params!=null){
            Iterator iterator=params.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry entry=(Map.Entry)iterator.next();
                query.setParameter((int)entry.getKey() ,entry.getValue());
            }
        }
        return query.list();
    }

    /**
     * hql条件查询
     * @param hql
     * @param params
     * @return
     */
    @Override
    public List<T> hqlQueryListByParamName(String hql, HashMap<String,Object> params){
        Query query = getSession().createQuery(hql);
        if(params!=null){
            Iterator iterator=params.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry entry=(Map.Entry)iterator.next();
                query.setParameter(entry.getKey().toString(),entry.getValue());
            }
        }
        return query.list();
    }

    /**
     * sql条件查询
     * @param sql
     * @param params
     * @return
     */
    @Override
    public List<T> sqlQueryList(String sql,Object[] params){
        NativeQuery<T> query= getSession().createNativeQuery(sql,clazz);
        if(params!=null){
            for (int i = 0,len=params.length; i < len; i++) {
                query.setParameter(i+1,params[i]);
            }
        }
        return query.list();
    }

    /**
     * sql条件查询
     * @param sql
     * @param params
     * @return
     */
    @Override
    public List<T> sqlQueryListByParamName(String sql, HashMap<String,Object> params){
        NativeQuery<T> query = getSession().createNativeQuery(sql,clazz);
        if(params!=null){
            Iterator iterator=params.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry entry=(Map.Entry)iterator.next();
                query.setParameter(entry.getKey().toString(),entry.getValue());
            }
        }
        return query.list();
    }

    /**
     * sql查询总记录数
     * @param sql
     * @param params
     * @return
     */
    @Override
    public int sqlQueryCount(String sql, Object[] params) {
        NativeQuery sqlQuery = getSession().createNativeQuery(sql);
        if(params!=null){
            for (int i = 0,len=params.length; i < len; i++) {
                sqlQuery.setParameter(i+1,params[i]);
            }
        }
        BigInteger total= (BigInteger) sqlQuery.uniqueResult();
        return total.intValue();
    }

    /**
     * sql查询总记录数
     * @param sql
     * @param params
     * @return
     */
    @Override
    public int sqlQueryCountByParamName(String sql, HashMap<String, Object> params) {
        NativeQuery sqlQuery = getSession().createNativeQuery(sql);
        if(params!=null){
            Iterator iterator=params.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry entry=(Map.Entry)iterator.next();
                sqlQuery.setParameter(entry.getKey().toString(),entry.getValue());
            }
        }
        BigInteger total= (BigInteger) sqlQuery.uniqueResult();
        return total.intValue();
    }

    /**
     * sql分页分页查询
     * @param sql
     * @param params
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public Page<T> sqlQueryPage(String sql,Object[] params,int pageIndex,int pageSize){
        NativeQuery<T> sqlQuery=getSession().createNativeQuery(sql,clazz);
        String countSql="select count(*) from ("+sql+") t";
        NativeQuery countQuery = getSession().createSQLQuery(countSql);
        if(params!=null){
            for (int i = 0,len=params.length; i < len; i++) {
                sqlQuery.setParameter(i+1,params[i]);
                countQuery.setParameter(i+1,params[i]);
            }
        }
        Page<T> page=new Page<>();
        int count=((BigInteger)countQuery.uniqueResult()).intValue();
        pageIndex=pageIndex>0?pageIndex:1;
        if(!canPage(pageIndex,pageSize,count)){
            return page;
        }
        List<T> list=sqlQuery.setFirstResult((pageIndex-1)*pageSize).setMaxResults(pageSize).list();
        page.setCount(count);
        page.setData(list);
        return page;
    }

    /**
     * sql分页分页查询
     * @param sql
     * @param params
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public Page<T> sqlQueryPageByParamName(String sql,HashMap<String,Object> params,int pageIndex,int pageSize){
        long start= System.currentTimeMillis();
        NativeQuery<T> sqlQuery=getSession().createNativeQuery(sql,clazz);
        String countSql="select count(*) from ("+sql+") t";
        NativeQuery countQuery = getSession().createSQLQuery(countSql);
        if(params!=null){
            Iterator iterator=params.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry entry=(Map.Entry)iterator.next();
                sqlQuery.setParameter(entry.getKey().toString(),entry.getValue());
                countQuery.setParameter(entry.getKey().toString(),entry.getValue());
            }
        }
        Page<T> page=new Page<>();
        int count=((BigInteger)countQuery.uniqueResult()).intValue();
        pageIndex=pageIndex>0?pageIndex:1;
        if(!canPage(pageIndex,pageSize,count)){
            return page;
        }
        List<T> list=sqlQuery.setFirstResult((pageIndex-1)*pageSize).setMaxResults(pageSize).list();
        page.setCount(count);
        page.setData(list);
        long end=System.currentTimeMillis();
        System.out.println("用时：" + (end - start));
        return page;
    }



    /**
     * 判断能否分页查询 ，页码从1开始
     * @param pageIndex
     * @param pageSize
     * @param total
     * @return
     */
    private boolean canPage(int pageIndex, int pageSize, int total) {
        if ((pageIndex - 1) > 0 && (pageIndex - 1) * pageSize >= total) {
            return false;
        }
        return true;
    }

    /****************************** HQL ******************************/
    @Override
    public Page<T> hqlQueryPage() {
        return hqlQueryPage(-1, -1, null, null, null);
    }

    @Override
    public Page<T> hqlQueryPage(int firstResult, int maxResult) {
        return hqlQueryPage(firstResult, maxResult, null, null, null);
    }

    @Override
    public Page<T> hqlQueryPage(int firstResult, int maxResult,
                                        LinkedHashMap<String, String> orderby) {
        return hqlQueryPage(firstResult, maxResult, null, null, orderby);
    }

    @Override
    public Page<T> hqlQueryPage(int firstResult, int maxResult,
                                        String where, Object[] params) {
        return hqlQueryPage(firstResult, maxResult, where, params, null);
    }

    @Override
    @SuppressWarnings("all")
    public Page<T> hqlQueryPage(int firstResult, int maxResult,
                                        String where, Object[] params, LinkedHashMap<String, String> orderby) {
        String entityName = clazz.getSimpleName();
        String whereql = where != null && !"".equals(where.trim()) ? " where "
                + where : "";
        Session session = getSession();
        Query query = session.createQuery("select o from " + entityName + " o"
                + whereql + buildOrderby(orderby));
        if (firstResult != -1 && maxResult != -1)
            query.setFirstResult(firstResult).setMaxResults(maxResult);
        setQueryParameter(query, params);

        Page<T> qr = new Page<T>();
        // qr.setResultlist(query.getResultList());
        Query queryCount = session.createQuery("select count(1) from "
                + entityName + " o" + whereql);
        setQueryParameter(queryCount, params);
        Long count = (Long) queryCount.uniqueResult();
        qr.setCount(count.intValue());
        qr.setData(query.list());
        return qr;
    }

    /**
     * 设置查询参数
     *
     * @param query
     *            查询对象
     * @param params
     *            参数值
     */
    public void setQueryParameter(Query query, Object[] params) {
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
    }

    /**
     * 构建排序语句
     *
     * @param orderby
     *            排序属性与asc/desc, Key为属性,Value为asc/desc
     * @return
     */
    public String buildOrderby(LinkedHashMap<String, String> orderby) {
        StringBuilder sb = new StringBuilder();
        if (orderby != null && !orderby.isEmpty()) {
            sb.append(" order by ");
            for (Map.Entry<String, String> entry : orderby.entrySet()) {
                sb.append("o.").append(entry.getKey()).append(" ")
                        .append(entry.getValue()).append(',');
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}