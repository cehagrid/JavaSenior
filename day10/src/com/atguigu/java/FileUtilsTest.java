package com.atguigu.java;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author llystart
 * @create 2023-01-29-11:36
 */
public class FileUtilsTest {
    public static void main(String[] args) {
        File srcFile = new File("day10\\day.jpg");
        File destFile = new File("day10\\day2.jpg");

        try {
            FileUtils.copyFile(srcFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
