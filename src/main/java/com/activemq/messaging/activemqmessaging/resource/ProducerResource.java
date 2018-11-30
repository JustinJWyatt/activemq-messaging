package com.activemq.messaging.activemqmessaging.resource;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/publish")
public class ProducerResource {

    @Autowired
    JmsTemplate template;

    @Autowired
    ActiveMQQueue queue;

    @GetMapping("/{message}")
    public String publish (@PathVariable("message") final String message){
        template.convertAndSend(queue, message);

        return "Published successfully";
    }
}
