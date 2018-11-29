package com.cyx.spring.fanxingyilaizhuru.dao.impl;

import com.cyx.spring.fanxingyilaizhuru.dao.AnimalDao;
import com.cyx.spring.fanxingyilaizhuru.dto.Dog;
import org.springframework.stereotype.Repository;

@Repository(value="dogDao")
public class DogDaoImpl extends BaseDaoImpl<Dog> implements AnimalDao<Dog> {
}
