package com.cyx.project.service.impl;

import com.cyx.project.service.MemberService;
import org.springframework.stereotype.Service;

@Service(value = "memberService")
public class MemberServiceImpl implements MemberService{
    @Override
    public String testMethod1(String world){
        return world;
    }
}
