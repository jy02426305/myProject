package com.cyx.project.common.session;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class MySessionDao  {
//    @Autowired
//    private RedisManager redisManager;
//
//    @Override
//    public void delete(Session session) {
//        if(session == null || session.getId() == null){
//            System.out.println("Session is null");
//            return;
//        }
//        redisManager.hdelete(session.getId().toString());
//    }
//
//    @Override
//    public Collection<Session> getActiveSessions() {
//        List<Session> list = redisManager.hmget();
//        return list;
//    }
//
//    @Override
//    public void update(Session session) throws UnknownSessionException {
//        if(session == null || session.getId() == null){
//            System.out.println("Session is null");
//            return;
//        }
//        Serializable sessionId = session.getId();
//        redisManager.hadd(sessionId.toString(), session);
//    }
//
//    @Override
//    protected Serializable doCreate(Session session) {
//        Serializable sessionId = generateSessionId(session);
//        assignSessionId(session, sessionId);
//        //添加进redis
//        redisManager.hadd(sessionId.toString(), session);
//
//        return sessionId;
//    }
//
//    @Override
//    protected Session doReadSession(Serializable sessionId) {
//        return redisManager.hget(sessionId.toString());
//    }
}
