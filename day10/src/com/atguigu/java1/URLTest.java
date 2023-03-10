package com.atguigu.java1;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL网络编程
 * 1.URL统一资源定位符，对应着互联网的某一资源地址
 * 2.格式
 * http://localhost:8080/examples/beauty.JPG?username=Tom
 * 协议   主机名    端口号     资源地址        参数列表
 *
 * @author llystart
 * @create 2023-01-30-11:47
 */
public class URLTest {

    public static void main(String[] args) {
        try {

            URL url = new URL("http://localhost:8080/examples/beauty.JPG?username=Tom");

//            public String getProtocol( ) 获取该URL的协议名
            System.out.println("协议名:"+url.getProtocol());
//            public String getHost( ) 获取该URL的主机名
            System.out.println("主机名:"+url.getHost());
//            public String getPort( ) 获取该URL的端口号
            System.out.println("端口号:"+url.getPort());
//            public String getPath( ) 获取该URL的文件路径
            System.out.println("文件路径:"+url.getPath());
//            public String getFile( ) 获取该URL的文件名
            System.out.println("文件名:"+url.getFile());
//            public String getQuery( ) 获取该URL的查询名
            System.out.println("查询名:"+url.getQuery());


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
