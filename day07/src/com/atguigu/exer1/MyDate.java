package com.atguigu.exer1;

/**
 * MyDate类包含：
 * private成员变量year,month,day:并为每一个属性定义getter，setter方法：
 *
 * @author llystart
 * @create 2023-01-10-17:49
 */
public class MyDate implements Comparable {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        if (o instanceof MyDate) {
            MyDate m = (MyDate) o;

            //比较年
            int minusYear = this.getYear() - m.getYear();
            if (minusYear != 0) {
                return minusYear;
            }

            //比较月
            int minusMouth = this.getMonth() - m.getMonth();
            if (minusMouth != 0) {
                return minusMouth;
            }

            //比较日
            return this.getDay() - m.getDay();
        }

        throw new RuntimeException("传入数据类型不一致");

    }
}
