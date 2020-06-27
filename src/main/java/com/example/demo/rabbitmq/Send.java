package com.example.demo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @author liuguoquan
 * @version 1.0
 * @description
 * @date 2019/12/27 20:59
 */
public class Send {
    /**
     * 队列名称
     */
    private static final String QUEUE_NAME = "liuguoquan";

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = RabbitmqConnectionUtil.getConnection();
        assert connection != null;
        Channel channel = connection.createChannel();
        /* 创建消息队列，并且发送消息 */
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "消息2";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println("生产了个'" + message + "'");

        /* 关闭连接 */
        channel.close();
        connection.close();
    }
}
