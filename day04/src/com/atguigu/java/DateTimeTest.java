package com.atguigu.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * jdk 8之前的日期和时间的API测试
 * 1.System类中currentTimeMillis();
 * 2.java.util.Date和子类java.sql.Date
 * 3.SimpleDateFormat
 * 4.Calendar
 *
 * @author llystart
 * @create 2022-12-30-15:36
 */
public class DateTimeTest {
    /*
     * SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析
     *
     * 1.两个操作:
     * 1.1格式化：日期 ---> 字符串
     * 1.2解析：格式化的逆过程，字符串 ---> 日期
     *
     * 2.SimpleDateFormat的实例化
     *
     */
    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化SimpleDateFormat:使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期 ---> 字符串
        Date date = new Date();
        System.out.println("原来的时间等："+date);

        String format = sdf.format(date);
        System.out.println("空参构造器的sdf后时间："+format);

        //解析：格式化的逆过程，字符串 ---> 日期
        String str = "2023/2/25 上午8:48";

//        Date date1 = sdf.parse("2023/2/25 上午8:485");
        Date date1 = sdf.parse(str);
        System.out.println("解析后："+date1);
        System.out.println("*******************************");

        //***************按照指定的方式格式化和解析：调用带参的构造器****************
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);//2022-12-30 07:45:51
        //解析:要求字符串必须是符合SimpleDateFormat识别的格式(通过构造器参数体现)，
        //否则，抛异常
        Date date2 = sdf1.parse("2022-12-30 07:45:51");
        System.out.println(date2);
    }

    /*
     * 练习一：字符串"2020-9-8"
     *
     * 练习二："三天打渔两天晒网" 1990-01-01 xxxx-xx-xx 打渔？晒网？
     *
     * 举例：2020-09-08 ？总天数
     *
     * 总天数 % 5 == 1,2,3 ：打渔
     * 总天数 % 5 == 4,0 ：晒网
     * 总天数的计算？
     * 方式一：(date2.getTime() - date1.getTime()) / 86400000 + 1
     * 方式二：硬算
     */
    @Test
    public void testExer() throws ParseException{
        String birth = "2020-9-8";

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf1.parse(birth);
//        System.out.println(date);

        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }

    /*
    * Calendar日历类的使用
    *
    *
    */

    @Test
    public void testCalendar(){
        //1.实例化
        //方式1：创建其子类（GregorianCalendar）的对象
        //方式2：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set()
        calendar.set(Calendar.DAY_OF_MONTH,22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);


        //getTime():日历类 ---> Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime()
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

    }
}
