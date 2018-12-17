package com.cyx.common.dao;

import org.hibernate.Session;

public interface BaseDao<T,PK> {
    Session getSession();
}
