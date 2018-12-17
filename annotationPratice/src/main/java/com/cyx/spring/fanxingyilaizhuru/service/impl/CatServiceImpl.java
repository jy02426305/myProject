package com.cyx.spring.fanxingyilaizhuru.service.impl;

import com.cyx.spring.fanxingyilaizhuru.dto.Cat;
import com.cyx.spring.fanxingyilaizhuru.service.AnimalService;
import org.springframework.stereotype.Service;

@Service(value="catService")
public class CatServiceImpl extends BaseServiceImpl<Cat> implements AnimalService<Cat> {
}
