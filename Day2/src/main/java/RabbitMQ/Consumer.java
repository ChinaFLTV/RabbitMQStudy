package RabbitMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author LiGuanda
 * @date 2022/12/27 上午 10:35:33
 * @description no description right now...
 * @filename Consumer.java
 */


public class Consumer {


    public final String QUEUE_NAME = "hello";


    public void consume() {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.16.131");
        factory.setUsername("admin");
        factory.setPassword("123");
        try {

            System.out.println("C1 was ready...");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.basicConsume(QUEUE_NAME, true,
                    (consumerTag, message) -> System.out.println("Receive --> " + message),
                    consumerTag -> System.out.println("Receive Failed QAQ "));

        } catch (IOException | TimeoutException e) {

            throw new RuntimeException(e);

        }


    }


}
