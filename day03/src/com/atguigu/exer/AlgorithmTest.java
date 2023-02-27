package com.atguigu.exer;

import org.junit.Test;

import java.util.Arrays;

/**
 * 练习5：常见算法题目
 *
 * @author llystart
 * @create 2022-12-17-12:08
 */
public class AlgorithmTest {
    /*
   1. 模拟一个trim方法，去除字符串两端的空格。
   2. 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”
   3. 获取一个字符串在另一个字符串中出现的次数。
        比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
    */
    @Test
    public void test1() {
        String str1 = "  abcdefg  ";
//        char[] chars = str1.toCharArray();
//        System.out.println(chars.length);//11
        String str2 = myTrim(str1);
        System.out.println("---" + str2 + "---");//"abcdefg"
        StringBuffer str3 = new StringBuffer(str2);
//        System.out.println(str3.reverse());
        System.out.println(myReverse(7, 3, str2));

        System.out.println("-------------------------------");
        String str = "abkkcadkabkebfkabkskab";
        System.out.println(myMatch(str, "ab"));
//        System.out.println(str.indexOf("azb", 1));
    }

    /**
     * @param str 传入字符串
     * @return 返回去掉首位端空格的字符串
     */
    public String myTrim(String str) {

        char[] char1 = str.toCharArray();
        int count = 0;//记录空格数
        for (int i = 0; i < char1.length; i++) {//数前面的空格
            if (char1[i] == ' ') {
                count++;
            } else {
                break;
            }
        }
        // 移除前面的空格装入char2[]
        char[] char2 = new char[char1.length - count];
        if (count != 0) {
            for (int i = 0; i < char2.length; i++) {
                char2[i] = char1[i + count];
            }
            count = 0;
        }

        for (int i = char2.length - 1; i >= 0; i--) {//数后面的空格
            if (char2[i] == ' ') {
                count++;
            } else {
                break;
            }
        }
        // 移除后面的空格装入char3[]
        char[] char3 = new char[char2.length - count];
        if (count != 0) {
            for (int i = 0; i < char3.length; i++) {
                char3[i] = char2[i];
            }
        }
        //转回String
        String s = new String(char3);
        return s;
    }

    /**
     * 翻转操作：翻转指定段内的字符
     *
     * @param str   输入的字符串
     * @param start 起始位置
     * @param end   结束位置（左开右闭）
     * @return 返回修改后的字符串
     */
    public String myReverse(int start, int end, String str) {
        //1.先找到需要翻转的字符串
        //q1:判断start 是否小于 end
//        if (end - start < 0) {
////            throw new Exception;//可以抛异常在方法内或外解决
//            System.out.println("起始位置小于结束位置");
//            return null;
//        }
        char[] strOfChar = str.toCharArray();
        char[] temporaryArray;
        if (start < end) {
            temporaryArray = new char[end - start];
            for (int i = 0; i < end - start; i++) {
                temporaryArray[i] = strOfChar[i + start - 1];
            }
        } else {
            temporaryArray = new char[start - end];
            for (int i = 0; i < start - end; i++) {
                temporaryArray[i] = strOfChar[i + end - 1];
            }
        }

        //2.翻转
        String s1 = new String(temporaryArray);
        StringBuilder str1 = new StringBuilder(s1);
        s1 = str1.reverse().toString();
        temporaryArray = s1.toCharArray();

        //3.装回str
        if (start < end) {//3 < 8
            for (int i = 0; i < end - start; i++) {
                strOfChar[i + start - 1] = temporaryArray[i];
            }
        } else {
            for (int i = 0; i < start - end; i++) {
                strOfChar[i + end - 1] = temporaryArray[i];
            }
        }

        return new String(strOfChar);
    }

    /**
     * @param str    主串
     * @param substr 模式串
     * @return 匹配成功的次数
     */
    public int myMatch(String str, String substr) {
        int count = 0;//记录匹配成功的次数，不成功返回0
        int num = 0;//起始位置
        while (true) {
            num = str.indexOf(substr, num);
            if (num != -1) {//存在能匹配的串
                num += substr.length();
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    //创建next[]表，逻辑图上所有的角标都从1开始,kmp没有用上
    private int[] buildNext(String substr) {
        //1.将字符串转数组，再建一个同等长度next表
        char[] subToChar = substr.toCharArray();
        int[] next = new int[subToChar.length + 1];//next[]多一位0位空着1位设0，从1开始

        //2.由subToChar[]串生成next[]表,i不会回头
        int i = 1, j = 0;
        next[1] = 0;//next[]表真正的第一位
        while (i < subToChar.length) {
            if (j == 0 || subToChar[i - 1] == subToChar[j - 1]) {//字符串数组角标同步为1开始
                ++i;
                ++j;
                next[i] = j;//
            } else {
                j = next[j];
            }
        }

        //3.返回nextval[]
        return next;
    }

    /*
    * 4.获取两个字符串中最大相同子串。比如：str1 = "abcwerthelloyuiodef";str2 = "cvhellobnm"
    提示：将短的那个串进行长度依次递减的子串与较长的串比较。
    5.对字符串中字符进行自然顺序排序。
        提示：
     1）字符串变成字符数组。
     2）对数组排序，选择，冒泡，Arrays.sort();
     3）将排序后的数组变成字符串。
    *
    */
    @Test
    public void test2() {
        String str1 = "abcwerthelloyuiodef";
        String str2 = "cvhellobnm";

//        char[] c1 = str1.toCharArray();
//        char[] c2 = str2.toCharArray();
//        System.out.println(c1.length);
//        System.out.println(c2.length);
//        c1 = c2;
//        System.out.println(c1.length);
//        System.out.println(c2.length);
//        str1 = new String(c1);
//        System.out.println(str1);
        System.out.println(maxSubStr(str1, str2));
        System.out.println(maxSort(str1));
    }

    /**
     * 为短的串准备一个数组，记录每减少一个字符后能匹配长串的最大长度，根据数组中的最大值，
     * 推测出哪个字母开头的最大；准备一个maxMatch记录每轮循环匹配长度
     *
     * @param strLong
     * @param strShort
     * @return
     */
    private String maxSubStr(String strLong, String strShort) {
        if (strLong.length() < strShort.length()) {
            System.out.println("请按长串在前，短串在后输入字符串！");
            return null;
        }
        char[] chLong = strLong.toCharArray();
        char[] chShort = strShort.toCharArray();
        int[] inShort = new int[chShort.length];//记录数组在每一位数组开头情况下最大匹配长度
        String strReturn = new String(strShort);//返回串

        /**
         * 按顺序比较字母，相同都++，不同短的归零重新比较，并记录最长匹配；
         * 短的长度和长度长度剩余的字符串比较，短的长度长就不比了跳出循环；
         *  还能比较，去掉首位字符生成新数组，继续比较；
         * 跳出循环后将最长匹配数计入数组，并去掉短的首位字符进入下一轮；
         * 结束对比后，遍历数组找到最大值，数组位置对应短字符开始位置，数组数对应字符长度；
         * 取出字符；
         */
        for (int k = 0; k < strShort.length(); k++) {//k记录去掉几个字符，当k最大时还有一个字符
            int maxLength = 0;//临时存储最大值
            int j = 0;//i不回头，j回头

            //chShort[]去掉k个字符,先去掉,再比较
            if (k != 0) {
                strShort = strShort.substring(1, strShort.length());
                chShort = strShort.toCharArray();
            }
            for (int i = 0; i < chLong.length; ) {
                if (chShort[j] == chLong[i]) {
                    j++;
                    i++;
                    if (maxLength < j) {//有可能最后都成功
                        maxLength = j;
                    }
                } else {//失配后处理
                    if (maxLength < j) {
                        maxLength = j;
                    }
                    if (j != 0) {
                        j = 0;
                    } else if (j == 0) {
                        i++;
                    }
                }
            }
            inShort[k] = maxLength;
        }

        //收集完数组，找到最大值索引
//        int maxMatch;//记录每轮对比能匹配的最大值
        int max = 0;
        int index = 0;
        for (int i = 0; i < inShort.length; i++) {
            if (max < inShort[i]) {
                max = inShort[i];
            }
        }
        for (int i = 0; i < inShort.length; i++) {
            if (max == inShort[i]) {//如果多个相等只返回第一个相等的值
                index = i;
                break;
            }
        }

        return strReturn.substring(index, index + max);
    }

    /**
     * 字符串排序
     *
     * @param str
     * @return
     */
    private String maxSort(String str) {
        /**
         * 字符转成数组，数组ascii数字排序，再转回串
         */
        char[] chars = str.toCharArray();
        StringBuffer orderChar = new StringBuffer(str);
        Arrays.sort(chars);
        return new String(chars);
    }

    //"cvhellobnm"
//    private char[] bubbleSort(char[] ch){
//        for (int i = 0; i < ch.length; i++) {
//
//        }
//
//        return ch;
//    }



}
