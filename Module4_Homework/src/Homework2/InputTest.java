package Homework2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InputTest {

    public static void main(String[] args) {

        //使用ArrayList记录输入的字符串
        List<String> list = new ArrayList<>();

        //缓冲区
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String str = null;
            System.out.println("请输入任意字符串内容，输入end结束");
            while (true) {
                str = br.readLine();
                /*if((str = br.readLine()) != null){
                    System.out.println("请继续输入：");
                }*/
                //如果是end，结束输入
                if ("end".equals(str)) {
                    System.out.println("输入结束！");
                    break;
                }
                //提示继续输入
                System.out.println("请继续输入：");
                list.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流对象并释放资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //使用比较器给记录的字符串排序
        Collections.sort(list, Collections.reverseOrder());

        //将排好序的字符串写入到abc.txt下
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("abc.txt"));
            for (String st : list) {
                bw.write(st);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流对象并释放资源
            if (null != bw) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
