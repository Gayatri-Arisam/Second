package com.example.producerRabbitmq.producerRabbitmq.controller;

import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Producer {
@Autowired
private RabbitTemplate rabbitTemplate;
@Autowired
private HeadersExchange exchange;
@PostMapping("/post/{message}")
public String send(@PathVariable(value="message") String message)
{
//rabbitTemplate.convertAndSend(exchange.getName(),"routing.B",message);



rabbitTemplate.convertAndSend("queue.AA",message);
	/*
	 * MessageProperties messageProperties=new MessageProperties();
	 * 
	 * messageProperties.setHeader("colour", message); MessageConverter
	 * messageConverter=new SimpleMessageConverter(); Message
	 * message1=messageConverter.toMessage(message, messageProperties);
	 * rabbitTemplate.send(exchange.getName(),"",message1);
	 */
	
	
	return "Message sent successfully Yahoo";
}
}







