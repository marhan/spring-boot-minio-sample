package de.markushanses.finance.haspa.retriever.adapter.rabbitmq.outbound;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMessageProducer {

    private final RabbitTemplate rabbitTemplate;
    
    public BankAccountMessageProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }
    public void sendFirstMessage(){
        this.rabbitTemplate.convertAndSend("directExchange", "first","Welcome");
    }
    public void sendSecondMessage(){
        this.rabbitTemplate.convertAndSend("directExchange", "second","Welcome Again");
    }
}