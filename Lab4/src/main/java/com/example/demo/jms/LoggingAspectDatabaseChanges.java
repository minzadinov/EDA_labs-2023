package com.example.demo.jms;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class LoggingAspectDatabaseChanges {
    @Autowired
    private JmsSend jmsSendEvent;

    private void sendJmsEvent(String name, String retVal) {
        retVal = retVal.isEmpty() ? "" : retVal;

        if (name.contains(EventType.save.name())) {
            jmsSendEvent.sendEvent("event", new WatchDogEntity(retVal, EventType.save));
            jmsSendEvent.sendEvent("email", new EmailEntity("test@test.ru", retVal));
        } else if (name.contains(EventType.delete.name())) {
            jmsSendEvent.sendEvent("event", new WatchDogEntity(retVal, EventType.delete));
            jmsSendEvent.sendEvent("email", new EmailEntity("test@test.ru", retVal));
        }
    }

    @AfterReturning(pointcut = "execution(* com.example.demo.repos.CommandRepo.*(..))", returning = "retVal")
    public void trackDatabaseCommandChanges(JoinPoint joinPoint, Object retVal) {
        String name = joinPoint.getSignature().toString();
        if (retVal == null) {
            sendJmsEvent(name, "Command");
        } else {
            sendJmsEvent(name, retVal.toString());
        }
    }

    @AfterReturning(pointcut = "execution(* com.example.demo.repos.ProjectRepo.*(..))", returning = "retVal")
    public void trackDatabaseProjectChanges(JoinPoint joinPoint, Object retVal) {
        String name = joinPoint.getSignature().toString();
        if (retVal == null) {
            sendJmsEvent(name, "Project");
        } else {
            sendJmsEvent(name, retVal.toString());
        }
    }
}
