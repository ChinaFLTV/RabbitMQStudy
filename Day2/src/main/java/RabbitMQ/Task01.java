package RabbitMQ;

import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author LiGuanda
 * @date 2022/12/27 上午 11:21:59
 * @description no description right now...
 * @filename Task01.java
 */


public class Task01 {


    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) {

        Channel channel = RabbitUtils.getChannel();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String message = scanner.next();
            try {

                channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));

            } catch (IOException e) {

                throw new RuntimeException(e);

            }
            System.out.println("Send Successfully! -->" + message);

        }


    }


}
