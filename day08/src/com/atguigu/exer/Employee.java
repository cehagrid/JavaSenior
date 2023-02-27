package com.atguigu.exer;

/**
 * 定义一个Employee类。
 * 该类包含：private成员变量name，age，birthday,其中birthday 为MyDate 类的对象；
 * 并为每一个属性定义getter,setter方法；
 * 并重写toString 方法输出，name，age，birthday
 *
 * @author llystart
 * @create 2023-01-10-17:57
 */
public class Employee implements Comparable<Employee>{
    private String name;
    private int age;
    private MyDate birthday;

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    //按照姓名的顺序排
    //指明泛型时的写法
    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }

    //按name排序
    //没有指明泛型时的写法
//    @Override
//    public int compareTo(Object o) {
//        if(o instanceof Employee){
//            Employee e = (Employee) o;
//            return this.name.compareTo(e.name);
//        }else{
////            return 0;
//            throw new RuntimeException("传入的数据类型不一致");
//        }

//    }
}
