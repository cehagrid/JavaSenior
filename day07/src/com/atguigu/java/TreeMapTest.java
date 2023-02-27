package com.atguigu.java;

import com.atguigu.java1.User;
import org.junit.Test;

import java.util.*;

/**
 * |---TreeMap:保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或定制排序
 *           底层使用红黑树
 * @author llystart
 * @create 2023-01-12-15:00
 */
public class TreeMapTest {

    //向TreeMap中添加key-value，要求key必须是同一个类创建的对象
    //因为要按照key进行排序：自然排序、定制排序
    //自然排序
    @Test
    public void test1(){
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }
                throw new RuntimeException("输入的类型不匹配");
            }
        });

        User u1 = new User("Tom",23);
        User u2 = new User("Jerry",32);
        User u3 = new User("Jack",20);
        User u4 = new User("Rose",18);

        map.put(u1,98);
        map.put(u2,89);
        map.put(u3,76);
        map.put(u4,100);

        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object obj = iterator1.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + " ----------> " + entry.getValue());
        }

    }
}
