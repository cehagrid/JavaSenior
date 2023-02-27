package com.atguigu.exer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author llystart
 * @create 2023-01-27-13:18
 */
public class MyInput {
    //Read a string from the keyboard
    public static String readString(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //Declare and initialize the string
        String string = "";

        //Get the string from the keyboard
        try {
            string = br.readLine();
        } catch (IOException e) {
            System.out.println(e);
        }

        //Return the obtained from the keyboard
        return string;
    }

    //Read an int value from the keyboard
    public static int readInt(){return Integer.parseInt(readString());}
    //Read a double from the keyboard
    public static double readDouble(){return Double.parseDouble(readString());}
    //Read a byte from the keyboard
    public static byte readByte(){return Byte.parseByte(readString());}
    //Read a short from the keyboard
    public static short readShort(){return Short.parseShort(readString());}
    //Read a long from the keyboard
    public static long readLong(){return Long.parseLong(readString());}
    //Read a float from the keyboard
    public static float readFloat(){return Float.parseFloat(readString());}


}


