package com.example.springrabbitmq.model;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProducerController {
    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange exchange;

    @PostMapping("/post")
    public String send(@RequestBody Message message) {
        rabbitTemplate.convertAndSend(exchange.getName(),"routing.A", message);
        return "Message sent successfully";
    }
}
