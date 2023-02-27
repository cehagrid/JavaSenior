package com.atguigu.java2;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 *      和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致。
 *      抽象方法的返回值类型即为构造器所属类的类型。
 * <p>
 *
 * 二、数组引用
 *      大家可以把数组看做一个特殊的类，则写法与构造器引用一致。
 * <p>
 * <p>
 * Created by shkstart
 */
public class ConstructorRefTest {
    //构造器引用
    //Supplier中的T get()
    @Test
    public void test1() {
        Supplier<Employee> sup1 = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println(sup1.get());

        System.out.println("****************************");

        Supplier<Employee> sup2 = () -> new Employee();
        System.out.println(sup2.get());

        System.out.println("****************************");
        Supplier<Employee> sup3 = Employee::new;
        System.out.println(sup3.get());


    }

    //Function中的R apply(T t)
    @Test
    public void test2() {
        Function<Integer,Employee> f1 = new Function<Integer, Employee>() {
            @Override
            public Employee apply(Integer int1) {
                return new Employee(int1);
            }
        };
        System.out.println(f1.apply(1002));

        System.out.println("***************************");

        Function<Integer,Employee> f2 = id -> new Employee(id);
        System.out.println(f2.apply(1003));

        System.out.println("***************************");

        Function<Integer,Employee> f3 = Employee::new;
        System.out.println(f3.apply(1001));


    }

    //BiFunction中的R apply(T t,U u)
    @Test
    public void test3() {
        BiFunction<Integer,String,Employee> bi1 = new BiFunction<Integer, String, Employee>() {
            @Override
            public Employee apply(Integer integer, String s) {
                return new Employee(integer,s);
            }
        };
        System.out.println(bi1.apply(1001, "Tom"));

        System.out.println("***********************************");

        BiFunction<Integer,String,Employee> bi2 = (id,name) -> new Employee(id,name);
        System.out.println(bi2.apply(1002, "Jerry"));

        System.out.println("***********************************");

        BiFunction<Integer,String,Employee> bi3 = Employee::new;
        System.out.println(bi3.apply(1003, "hmm"));

    }

    //数组引用
    //Function中的R apply(T t)
    @Test
    public void test4() {
        Function<Integer,String[]> f1 = new Function<Integer, String[]>() {
            @Override
            public String[] apply(Integer integer) {
                return new String[integer];
            }
        };
        String[] strings = f1.apply(10);
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println(Arrays.toString(strings));

        System.out.println("************************");

        Function<Integer,Employee[]> f2 = num -> new Employee[num];
        Employee[] apply1 = f2.apply(10);
        System.out.println(Arrays.toString(apply1));

        System.out.println("************************");

        Function<Integer,Employee[]> f3 = Employee[]::new;
        Employee[] apply = f3.apply(10);
        for (Employee employee : apply) {
            System.out.println(employee);
        }
        System.out.println(Arrays.asList(apply));
    }
}
