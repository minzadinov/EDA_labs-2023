package com.example.demo.jms;

import com.example.demo.repos.EmailRepository;
import com.example.demo.repos.WatchDogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsReceive {
    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private WatchDogRepository watchDogRepository;

    @JmsListener(destination = "mail")
    public void receiveEmail(EmailEntity email) {
        emailRepository.save(email);
        System.err.println("Mail: " + email);
    }

    @JmsListener(destination = "event")
    public void receiveWatcherEvent(WatchDogEntity event) {
        watchDogRepository.save(event);
        System.err.println("Event: " + event);
    }
}
