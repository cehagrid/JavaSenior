package com.atguigu.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义泛型类
 *
 * @author llystart
 * @create 2023-01-13-20:52
 */
public class Order<TTT> {

    String orderName;
    int orderId;

    //类的内部就可以使用类的泛型

    TTT orderT;

    public Order(){
        //编译不通过
//        TTT[] arr = new TTT[10];
        //编译通过
        TTT[] arr = (TTT[])new Object[10];

    }

    public Order(String orderName,int orderId,TTT orderT){
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    //如下的三个方法都不是泛型方法
    public TTT getOrderT(){
        return orderT;
    }

    public void setOrderT(TTT orderT){
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    //静态方法中不能用泛型。
//    public static void show(TTT orderT){
//        System.out.println(orderT);
//    }

    public void show(){
        //编译不通过
//        try {
//
//        }catch (TTT t){
//
//        }
    }

    //泛型方法：在方法中出现了泛型结构，泛型的参数与类的泛型参数没有任何关系。
    //换句话说：泛型方法所属的类是不是泛型类都没有关系。
    //泛型方法，可以声明为静态的。原因：泛型参数是在调用方法时确定的，并非实例化类时确定。
    public static <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);
        }
        return list;
    }
}
