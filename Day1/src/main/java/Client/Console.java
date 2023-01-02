package Client;

import Rabbitmq.Producer;

/**
*
* @author LiGuanda
* @date 2022/12/26 下午 12:06:33
* @description no description right now...
* @filename Console.java
*
*/

public class Console {


    public static void main(String[] args) {

        Producer producer = new Producer();
        producer.send();


    }


}
