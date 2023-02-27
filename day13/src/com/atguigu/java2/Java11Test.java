package com.atguigu.java2;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * @author llystart
 * @create 2023-02-07-8:29
 */
public class Java11Test {
    //Java 11 新特性一：String中新增的方法
    @Test
    public void test1(){
//    判断字符串是否为空白 " ".isBlank(); // true
        System.out.println("\t  \t  \n  ".isBlank());

//    去除首尾空白 " Javastack ".strip(); // "Javastack"
        System.out.println("-----"+"\t   \t abc  \n   ".strip()+"-----".strip());
        System.out.println("-----"+"\t   \t abc  \n   ".trim()+"-----".strip());

//    去除尾部空格 " Javastack ".stripTrailing(); // " Javastack"
        System.out.println("-----"+"\t   \t abc  \n   ".stripTrailing()+"-----");


//    去除首部空格 " Javastack ".stripLeading(); // "Javastack "
        System.out.println("-----"+"\t   \t abc  \n   ".stripLeading()+"-----");

//    复制字符串 "Java".repeat(3);// "JavaJavaJava"
        System.out.println("Java".repeat(3));

//    行数统计 "A\nB\nC".lines().count(); // 3
        System.out.println("A\nB\nC".lines().count());

    }

    //Java 11 新特性二：Optional升级
    @Test
    public void test2(){

        var op = Optional.empty();
        System.out.println(op.isPresent());//判断value是否存在
        System.out.println(op.isEmpty());//判断value是否为空

        op = Optional.of("abc");
        // orElseThrow() value非空，返回value；否则抛异常NoSuchElementException
        var obj = op.orElseThrow();
        System.out.println(obj);

        Optional<String> op1 = Optional.of("hello");
//        op = Optional.empty();
        //Optional<T> or(Supplier<?extends Optional<? extends T>> supplier)
        //value非空，返回对应的Optional；value为空，返回形参封装的Optional
        Optional<Object> op2 = op.or(() -> op1);
        System.out.println(op2);

    }

    //Java 11 新特性三：局部变量类型推断的升级
    @Test
    public void test3(){
        //错误的形式: 必须要有类型, 可以加上var
    //Consumer<String> con1 = (@Deprecated t) ->System.out.println(t.toUpperCase());
    //正确的形式:
    //使用var的好处是在使用lambda表达式时给参数加上注解。
        Consumer<String> con2 = (@Deprecated var t) -> System.out.println(t.toUpperCase());
    }

    //Java 11 新特性四：全新的HTTP 客户端API
    @Test
    public void test4(){
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request =
                    HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/test/")).build();
            HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();
            HttpResponse<String> response = client.send(request, responseBodyHandler);
            String body = response.body();
            System.out.println(body);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test5(){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request =
                HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/test/")).build();
        HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();
        CompletableFuture<HttpResponse<String>> sendAsync =
                client.sendAsync(request, responseBodyHandler);
        sendAsync.thenApply(t -> t.body()).thenAccept(System.out::println);
        //HttpResponse<String> response = sendAsync.get();
        //String body = response.body();
        //System.out.println(body);

    }

}
