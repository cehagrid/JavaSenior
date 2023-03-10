package com.atguigu.java;

import org.junit.Test;

import java.util.Optional;

/**
 * @author llystart
 * @create 2023-02-06-15:54
 */
public class OptionalTest {

    @Test
    public void test1(){
        //empty()：创建的Optional对象内部的value = null
        Optional<Object> op1 = Optional.empty();
        if (!op1.isPresent()) {//Optional封装的数据是否包含数据
            System.out.println("数据为空");
        }
        System.out.println(op1);
        System.out.println(op1.isPresent());
//        System.out.println(op1.get());

    }

    @Test
    public void test2(){
        String str = "hello";
        str = null;
        //of(T t):封装数据t生成Optional对象。要求t非空，否则报错。
        Optional<String> op1 = Optional.of(str);
        //get()通常与of()方法搭配使用。用于获取内部封装的数据value
        String str1 = op1.get();
        System.out.println(str1);

    }
    @Test
    public void test3(){
        String str = "beijing";
        str = null;
        //ofNullable(T t): 封装数据t赋给Optional内部的value。不要求t非空
        Optional<String> op1 = Optional.ofNullable(str);
        //orElse(T t1):如果Optional内部的value非空，则返回此value值。如果
        //value为空，返回t1
        System.out.println(op1.get());
//        String str2 = op1.orElse("shanghai");
//        System.out.println(str2);

    }

}
