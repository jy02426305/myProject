package com.cyx.spring.fanxingyilaizhuru.control;

import com.cyx.spring.fanxingyilaizhuru.dto.Cat;
import com.cyx.spring.fanxingyilaizhuru.dto.Dog;
import com.cyx.spring.fanxingyilaizhuru.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AnimalControl {
    @Autowired
    private AnimalService dogService;

    @Autowired
    private AnimalService catService;

    public void doSomething(){
        dogService.say();
        catService.say();
    }
}
