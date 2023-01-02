package RabbitMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author LiGuanda
 * @date 2022/12/27 上午 10:56:46
 * @description no description right now...
 * @filename RabbitUtils.java
 */


public class RabbitUtils {


    public static Channel getChannel() {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.16.131");
        factory.setUsername("admin");
        factory.setPassword("123");
        try {

            Connection connection = factory.newConnection();
            return connection.createChannel();

        } catch (IOException | TimeoutException e) {

            e.printStackTrace();
            return null;

        }

    }


}
