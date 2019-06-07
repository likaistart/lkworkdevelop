package com.firstmodule.simpledemo;

import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: lkworkdevelop
 * @description:
 * @author: likai
 * @create: 2019-06-03 17:19
 **/
public class SimpleCollectionDemo {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<String>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        list.add("d");
//
//        for (String str : list
//        ) {
//            //if (str == "b") {
//            //   list.remove("b");
//            //}
//            System.out.println(str);
//        }
//        char a='哦';
//        System.out.println(a);


        char cha = '我';
        System.out.println(cha);  //我

        //通过Integer中的toBinaryString方法转char为二进制
        String binaryString = Integer.toBinaryString(cha);
        System.out.println(binaryString);  //1100010  00010001

        String s = String.valueOf(binaryString);
        System.out.println(s);
    }
}
