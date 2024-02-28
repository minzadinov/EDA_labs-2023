package com.example.demo.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsSend {
    private final JmsTemplate jmsTemplate;

    @Autowired
    public JmsSend(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendEvent(String topic, Object event) {
        jmsTemplate.convertAndSend(topic, event);
    }
}
