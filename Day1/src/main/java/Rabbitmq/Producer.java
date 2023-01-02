package Rabbitmq;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @author LiGuanda
 * @date 2022/12/26 上午 11:47:31
 * @description no description right now...
 * @filename Producer.java
 */

public class Producer {

    public static final String QUEUE_NAME = "hello";


    public void send() {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.16.131");
        factory.setUsername("admin");
        factory.setPassword("123");
        try (Connection connection = factory.newConnection()) {

            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "JuJingyi loves Dage!";

            channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println("消息发生完毕！");

        } catch (IOException | TimeoutException e) {

            throw new RuntimeException(e);

        }


    }


}
