package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author llystart
 * @create 2023-02-06-21:32
 */
public class Java9Test2 {

    //java9新特性十：Stream API的加强
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(23, 43, 45, 55, 61, 54, 32, 2, 34, 89, 7);
        //takeWhile 返回从开头开始的尽量多的元素
        list.stream().takeWhile(x -> x < 60).forEach(System.out::println);
        System.out.println();
        //dropWhile():
        list.stream().dropWhile(x -> x < 60).forEach(System.out::println);
    }

    @Test
    public void test2() {
        //of()参数中的多个元素，可以包含null值
        Stream<Integer> stream1 = Stream.of(1, 2, 3, null);
        stream1.forEach(System.out::println);
        //of()参数不能存储单个null值
        Stream<Integer> stream2 = Stream.of(null, null);
        stream2.forEach(System.out::println);

        System.out.println();
        Integer i = 10;
        //i = null;
        //ofNullable():形参变量是可以为null值的单个元素
        Stream<Integer> stream3 = Stream.ofNullable(i);
        long count = stream3.count();
        System.out.println(count);

    }

    @Test
    public void test3() {
        Stream.iterate(0, x -> x + 1).limit(10).forEach(System.out::println);
        System.out.println();
        //java9新增的重载方法
        Stream.iterate(0, x -> x < 100, x -> x + 1).forEach(System.out::println);

    }

    //java9新特性十一：Optional提供了新的方法stream()
    @Test
    public void test4() {
        List<String> list = new ArrayList<>();
        list.add("Tom");
        list.add("Jerry");
        list.add("Tim");
        Optional<List<String>> optional = Optional.ofNullable(list);
        Stream<List<String>> stream = optional.stream();
//        long count = stream.count();
//        System.out.println(count);
        stream.flatMap(x -> x.stream()).forEach(System.out::println);
    }
}
