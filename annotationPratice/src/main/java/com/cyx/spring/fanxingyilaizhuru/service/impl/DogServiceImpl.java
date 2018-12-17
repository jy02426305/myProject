package com.cyx.spring.fanxingyilaizhuru.service.impl;

import com.cyx.spring.fanxingyilaizhuru.dto.Dog;
import com.cyx.spring.fanxingyilaizhuru.service.AnimalService;
import org.springframework.stereotype.Service;

@Service(value="dogService")
public class DogServiceImpl extends BaseServiceImpl<Dog> implements AnimalService<Dog> {
}
