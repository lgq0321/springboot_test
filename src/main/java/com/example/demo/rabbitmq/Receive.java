package com.example.demo.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author liuguoquan
 * @version 1.0
 * @description
 * @date 2019/12/27 21:01
 */
public class Receive {
    /**
     * 队列名称
     */
    private static final String QUEUE_NAME = "liuguoquan";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection connection = RabbitmqConnectionUtil.getConnection();
        assert connection != null;
        Channel channel = connection.createChannel();
            /* 声明要连接的队列 */
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println("等待消息产生：");

            /* 创建消费者对象，用于读取消息 */
            QueueingConsumer consumer = new QueueingConsumer(channel);
            channel.basicConsume(QUEUE_NAME, true, consumer);

            /* 读取队列，并且阻塞，即在读到消息之前在这里阻塞，直到等到消息，完成消息的阅读后，继续阻塞循环 */
            while (true) {
                QueueingConsumer.Delivery delivery = consumer.nextDelivery();
                String message = new String(delivery.getBody());
                System.out.println("收到消息'" + message + "'");
            }
    }
}
