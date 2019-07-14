package com.macro.mall.search.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.rabbitmq.client.Channel;

@Configuration
public class RabbitMqConfig {

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory factory) {
        return new RabbitTemplate(factory);
    }

    @Bean
    public ConnectionFactory connectionFactory() {
    	CachingConnectionFactory conn = new CachingConnectionFactory();
    	conn.setAddresses("localhost:5672");
    	conn.setUsername("guest");
    	conn.setPassword("guest");
    	return conn;
    }

  @Bean
  Channel getChannel(ConnectionFactory factory) {
  	Connection conn=factory.createConnection();
  	
  	Channel channel=conn.createChannel(false);

  	return channel;
  }
}
