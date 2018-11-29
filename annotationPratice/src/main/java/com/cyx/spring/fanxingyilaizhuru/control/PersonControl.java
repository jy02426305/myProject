package com.cyx.spring.fanxingyilaizhuru.control;

import com.cyx.spring.fanxingyilaizhuru.dto.Person;
import com.cyx.spring.fanxingyilaizhuru.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PersonControl {
    @Autowired
    private PersonService personService;

    public void say(){
        personService.say();
        System.out.println(personService);
    }
}
