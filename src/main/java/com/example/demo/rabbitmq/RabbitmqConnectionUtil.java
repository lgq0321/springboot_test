package com.example.demo.rabbitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author liuguoquan
 * @version 1.0
 * @description
 * @date 2019/12/27 20:59
 */
public class RabbitmqConnectionUtil {

    public static Connection getConnection()
    {
        try
        {
            Connection connection = null;
            //定义一个连接工厂
            ConnectionFactory factory = new ConnectionFactory();
            //设置服务端地址（域名地址/ip）
            factory.setHost("111.229.51.50");
            //设置服务器端口号
            factory.setPort(5672);
            //设置虚拟主机(相当于数据库中的库)
            factory.setVirtualHost("/");
            //设置用户名
            factory.setUsername("guest");
            //设置密码
            factory.setPassword("guest");
            connection = factory.newConnection();
            return connection;
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
