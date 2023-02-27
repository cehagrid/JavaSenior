package com.atguigu.java;

import org.junit.Test;

import java.util.Date;

/**
 * @author llystart
 * @create 2022-12-21-20:01
 */
public class DateTimeTest {

    /*
     * java.util.Date类
     *   |---java.sql.Date类
     *
     * 1.两个构造器的使用
     *      > 构造器一：Date()：创建了一个当前时间的Date对象
     *      > 构造器二：创建指定毫秒数的Date对象
     *
     * 2.两个方法的使用
     *     > toString():显示当前的年、月、日、时、分、秒
     *     > getTime():获取当前Date对象对应的毫秒数。（时间戳）
     *
     * 3.java.sql.Date对应着数据库中的日期类型的变量
     *      >如何实例化
     *      >如何将java.util.Date ---> java.sql.Date
     *
     */
    @Test
    public void test2() {
        //构造器一：Date()：创建了一个当前时间的Date对象
        Date date1 = new Date();
        System.out.println("对应日期星期时间等："+date1.toString());

        System.out.println("对应的毫秒数："+date1.getTime());//还是毫秒数1671628027349

        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(1671628027349L);
        System.out.println("对应日期星期时间等："+date2);

        //创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(1671628027349L);
        System.out.println("对应日期："+date3);//2022-12-21  包含时分秒
        System.out.println("时间戳一致："+date3.getTime());//与输入构造器的参数一致

        //如何将java.util.Date 对象转换为 java.sql.Date对象
        //情况一：向上转型
        Date date4 = new java.sql.Date(232323323232L);
        java.sql.Date date5 = (java.sql.Date) date4;
        //情况二：转毫秒数输入构造器
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());

    }

    //1.System类中的currentTimeMillis()
    @Test
    public void test1() {
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。
        //称为时间戳
        System.out.println("系统时间时间戳："+time);//1671628053220
    }

}
