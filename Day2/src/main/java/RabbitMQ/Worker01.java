package RabbitMQ;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author LiGuanda
 * @date 2022/12/27 上午 11:04:07
 * @description no description right now...
 * @filename Worker01.java
 */


public class Worker01 {


    public static final String QUEUE_NAME = "hello";


    public static void main(String[] args) {


        System.out.println("C2 was ready...");
        Channel channel = RabbitUtils.getChannel();

        DeliverCallback deliverCallback = (consumerTag, message) -> System.out.println("Worker01->Rec-> " + Arrays.toString(message.getBody()));

        CancelCallback cancelCallback = consumerTag -> System.out.println("Worker01 Failed!");

        try {

            channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);

        } catch (IOException e) {

            throw new RuntimeException(e);

        }


    }


}
