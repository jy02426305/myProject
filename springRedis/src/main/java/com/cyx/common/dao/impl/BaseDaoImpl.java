package com.cyx.common.dao.impl;

import com.cyx.common.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

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
    public void deleteById(PK id){
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
     * 条件查询
     * @param hql
     * @param objects
     * @return
     */
    @Override
    public List<T> hqlQueryList(String hql,Object[] objects){
        Query query = getSession().createQuery(hql);
        if(objects!=null){
            for (int i = 0; i < objects.length; i++) {
                query.setParameter(i,objects[i]);
            }
        }
        return query.list();
    }

    /**
     * sql条件查询
     * @param sql
     * @param objects
     * @return
     */
    @Override
    public List<T> sqlQueryList(String sql,Object[] objects){
        NativeQuery<T> nativeQuery= getSession().createNativeQuery(sql,clazz);
        if(objects!=null){
            for (int i = 0; i < objects.length; i++) {
                nativeQuery.setParameter(i,objects[i]);
            }
        }
        return nativeQuery.list();
    }
}
