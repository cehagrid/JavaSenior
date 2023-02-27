package com.atguigu.java2;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 *
 * 1.使用情景：当要传递给Lambda体的操作，已经有实现的方法，可以用方法引用！
 *
 * 2.方法引用，本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例。所以
 * 	方法引用，也是函数是接口的实例
 *
 * 3.使用格式：	类(或对象) :: 方法名
 *
 * 4.具体分如下三种情况：
 * 	 对象 :: 非静态方法（实例方法）
 * 	 类 :: 静态方法（类方法）
 *
 * 	 类 :: 非静态方法
 *
 * 5.方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值与方法引用的方法的
 * 	 形参列表和返回值 相同！
 *
 * Created by shkstart.
 */
public class MethodRefTest {

	// 情况一：对象 :: 实例方法
	//Consumer中的void accept(T t)
	//PrintStream中的void println(T t)
	@Test
	public void test1() {
		Consumer<String> con1 = str -> System.out.println(str);
		con1.accept("北京");

		System.out.println("*************************");
		PrintStream ps = System.out;
		Consumer<String> con2 = ps::println;
//		Consumer<String> con2 = System.out::println;
		con2.accept("beijing");

	}
	
	//Supplier中的T get()
	//Employee中的String getName()
	@Test
	public void test2() {
		Employee emp = new Employee(1001,"Tom",23,5600);
		Supplier<String> sup1 = () -> emp.getName();
		System.out.println(sup1.get());

		System.out.println("*************************");

		Supplier<String> sup2 = emp::getName;
		System.out.println(sup2.get());

	}

	// 情况二：类 :: 静态方法
	//Comparator中的int compare(T t1,T t2)
	//Integer中的int compare(T t1,T t2)
	@Test
	public void test3() {
		Comparator<Integer> com1 = (t1,t2) -> Integer.compare(t1,t2);
		System.out.println(com1.compare(12, 21));

		System.out.println("****************************");

		Comparator<Integer> com2 = Integer::compare;
		System.out.println(com2.compare(12, 2));

	}
	
	//Function中的R apply(T t)
	//Math中的Long round(Double d)
	@Test
	public void test4() {
		Function<Double,Long> fun = new Function<Double, Long>() {
			@Override
			public Long apply(Double aDouble) {
				return Math.round(aDouble);
			}
		};
		fun.apply(12345.2);

		Function<Double,Long> fun1 = d -> Math.round(d);
		System.out.println(fun1.apply(123.2));

		System.out.println("****************************");

		Function<Double,Long> fun2 = Math::round;
		System.out.println(fun2.apply(234.2));


	}

	// 情况三：类 :: 实例方法 
	// Comparator中的int comapre(T t1,T t2)
	// String中的int t1.compareTo(t2)
	@Test
	public void test5() {
		Comparator<String> com1 = (t1,t2) -> t1.compareTo(t2);
		System.out.println(com1.compare("abc", "abd"));

		System.out.println("****************************");

		Comparator<String> com2 = String::compareTo;
		System.out.println(com2.compare("abd", "abm"));
	}

	//BiPredicate中的boolean test(T t1, T t2);
	//String中的boolean t1.equals(t2)
	@Test
	public void test6() {
		BiPredicate<String,String> bi1 = new BiPredicate<String, String>() {
			@Override
			public boolean test(String s, String s2) {
				return s.equals(s2);
			}
		};
		System.out.println(bi1.test("abc", "abc"));

		System.out.println("***************************");

		BiPredicate<Integer,Integer> bi2 = (o1,o2) -> o1.equals(o2);
		System.out.println(bi2.test(123, 234));

		System.out.println("***************************");

		BiPredicate<Double,Double> bi3 = Double::equals;
		System.out.println(bi3.test(123.3, 123.4));

	}
	
	// Function中的R apply(T t)
	// Employee中的String getName();
	@Test
	public void test7() {
		Function<Employee,String> f1 = new Function<Employee, String>() {
			@Override
			public String apply(Employee employee) {
				return employee.getName();
			}
		};
		Employee e1 = new Employee(1001,"Jerry",23,6000);
		System.out.println(f1.apply(e1));

		System.out.println("***************************");

		Employee e2 = new Employee();
		Function<Employee,String> f2 = (t) -> t.getName();
		System.out.println(f2.apply(e2));

		System.out.println("***************************");

		Employee e3 = new Employee();
		Function<Employee,String> f3 = Employee::getName;
		System.out.println(f3.apply(e3));
	}

}
