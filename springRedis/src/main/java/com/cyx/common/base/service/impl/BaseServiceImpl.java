package com.cyx.common.base.service.impl;

import com.cyx.common.base.persistence.BaseDao;
import com.cyx.common.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class BaseServiceImpl<T, PK extends Serializable> implements BaseService<T, PK> {

    @Autowired
    private BaseDao<T, PK> baseDao;

    @Override
    public T get(PK id) {
        return baseDao.get(id);
    }

    @Override
    public T load(PK id) {
        return baseDao.load(id);
    }

    @Override
    public PK save(T entity) {
        return baseDao.save(entity);
    }

    @Override
    public void delete(T entity) {
        baseDao.delete(entity);
    }

    @Override
    public void delete(PK id) {
        baseDao.delete(id);
    }

    @Override
    public void update(T entity) {
        baseDao.update(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        baseDao.saveOrUpdate(entity);
    }

    @Override
    public void batchSave(List<T> entityList) {
        baseDao.batchSave(entityList);
    }

    @Override
    public void batchDelete(List<T> entityList) {
        baseDao.batchDelete(entityList);
    }

    @Override
    public void batchUpdate(List<T> entityList) {
        baseDao.batchUpdate(entityList);
    }

    @Override
    public List<T> hqlQueryList(String hql, Object[] objects) {
        return baseDao.hqlQueryList(hql,objects);
    }

    @Override
    public List<T> sqlQueryList(String sql, Object[] objects) {
        return baseDao.sqlQueryList(sql,objects);
    }
}
