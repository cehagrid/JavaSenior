package com.atguigu.exer2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author llystart
 * @create 2023-01-23-11:12
 */
public class FileDemo {

    @Test
    public void test1() throws IOException {
        File file = new File("D:\\io\\io1");
        boolean mkdirs = file.mkdirs();
        if(mkdirs){
            System.out.println("mkdir成功");
        }
        File file1 = new File("D:\\io\\io1\\hello.txt");
        boolean newFile1 = file1.createNewFile();
        if(newFile1){
            System.out.println("创建成功1");
        }
        //创建一个与file同目录下的另一个文件,文件名为：haha.txt
        File destFile = new File(file.getParent(),"haha.txt");
        boolean newFile = destFile.createNewFile();
        if (newFile) {
            System.out.println("创建成功！2");
        }
    }
}
