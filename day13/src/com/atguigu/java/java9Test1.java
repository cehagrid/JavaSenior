package com.atguigu.java;


import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * @author llystart
 * @create 2023-02-06-20:44
 */
public class java9Test1 {
    //java9新特性8：集合工厂方法：创建只读集合
    //java8的写法
    @Test
    public void test1() {
        List<String> namesList = new ArrayList<>();
        namesList.add("Joe");
        namesList.add("Bob");
        namesList.add("Bill");
        //返回的nameList是一个只读集合
        namesList = Collections.unmodifiableList(namesList);
//        namesList.add("Tom");
        System.out.println(namesList);
    }

    @Test
    public void test2() {
        List<String> list = Collections.unmodifiableList(Arrays.asList("a", "b", "c"));
        Set<String> set = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("a", "b", "c")));
        // 如下操作不适用于jdk 8 及之前版本,适用于jdk 9
        Map<String, Integer> map = Collections.unmodifiableMap(new HashMap<>() {
            {
                put("a", 1);
                put("b", 2);
                put("c", 3);
            }
        });
        map.forEach((k, v) -> System.out.println(k + ":" + v));

    }

    @Test
    public void test3(){
        //此时得到的集合List也是一个只读集合
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        //报异常
        list.add(6);
    }


    //java9新特性8：集合工厂方法：创建只读集合
    @Test
    public void test4(){
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        //不能添加
//        list.add(6);

        System.out.println(list);

        Set<Integer> set = Set.of(23, 43, 545, 6, 76, 74, 54, 5);
        System.out.println(set);
        //不能添加
//        set.add(3456);

        Map<String, Integer> map = Map.of("Tom", 23, "Jerry", 54);
        System.out.println(map);
        //不能添加
//        map.put("ss",65);

        Map<String, Integer> map1 = Map.ofEntries(Map.entry("Tom", 23), Map.entry("Jerry", 43), Map.entry("hanmeimei", 43));
        //不能添加
//        map.put("lilei",66);
        System.out.println(map1);



    }

    //java9新特性九：InputStream 的新方法：transferTo()
    @Test
    public void test5(){
        ClassLoader cl = this.getClass().getClassLoader();
        try (InputStream is = cl.getResourceAsStream("hello.txt");
             OutputStream os = new FileOutputStream("src\\hello1.txt")) {
            is.transferTo(os); // 把输入流中的所有数据直接自动地复制到输出流中
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
