package com.cyx.project.common.base.service.impl;

import com.cyx.project.common.base.dto.Page;
import com.cyx.project.common.base.persistence.BaseDao;
import com.cyx.project.common.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.HashMap;
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
    public List<T> hqlQueryList(String hql,HashMap<Integer,Object> params) {
        return baseDao.hqlQueryList(hql,params);
    }

    @Override
    public List<T> hqlQueryListByParamName(String hql, HashMap<String, Object> params) {
        return baseDao.hqlQueryListByParamName(hql,params);
    }

    @Override
    public List<T> sqlQueryList(String sql, Object[] objects) {
        return baseDao.sqlQueryList(sql,objects);
    }

    @Override
    public List<T> sqlQueryListByParamName(String sql, HashMap<String, Object> params) {
        return baseDao.sqlQueryListByParamName(sql,params);
    }

    @Override
    public int sqlQueryCount(String sql, Object[] params) {
        return baseDao.sqlQueryCount(sql,params);
    }

    @Override
    public int sqlQueryCountByParamName(String sql, HashMap<String, Object> params) {
        return baseDao.sqlQueryCountByParamName(sql,params);
    }

    @Override
    public Page<T> sqlQueryPage(String sql, Object[] params, int pageIndex, int pageSize) {
        return baseDao.sqlQueryPage(sql,params,pageIndex,pageSize);
    }

    @Override
    public Page<T> sqlQueryPageByParamName(String sql, HashMap<String, Object> params, int pageIndex, int pageSize) {
        return baseDao.sqlQueryPageByParamName(sql,params,pageIndex,pageSize);
    }
}
