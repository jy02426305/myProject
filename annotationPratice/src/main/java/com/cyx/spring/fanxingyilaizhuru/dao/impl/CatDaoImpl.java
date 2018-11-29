package com.cyx.spring.fanxingyilaizhuru.dao.impl;

import com.cyx.spring.fanxingyilaizhuru.dao.AnimalDao;
import com.cyx.spring.fanxingyilaizhuru.dto.Cat;
import org.springframework.stereotype.Repository;

@Repository(value = "catDao")
public class CatDaoImpl extends BaseDaoImpl<Cat> implements AnimalDao<Cat> {
}
