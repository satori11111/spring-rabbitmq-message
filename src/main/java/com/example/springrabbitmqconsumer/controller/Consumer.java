package com.example.springrabbitmqconsumer.controller;

import com.example.springrabbitmqconsumer.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {
    @RabbitListener(queues = "queue A")
    private void receiveFromA(Message message) {
        log.info(message.toString() + " from A");
    }

    @RabbitListener(queues = "queue B")
    private void receiveFromB(Message message) {
        log.info(message.toString() + " from B");
    }
}
