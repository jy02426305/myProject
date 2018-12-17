package com.cyx.spring.fanxingyilaizhuru.service.impl;

import com.cyx.spring.fanxingyilaizhuru.dto.Person;
import com.cyx.spring.fanxingyilaizhuru.service.PersonService;
import org.springframework.stereotype.Service;

@Service(value="personService")
public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService<Person> {
}
