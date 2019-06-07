package com.firstmodule.serializabledemo.serial.serialdemo2;

import java.io.Serializable;
/**
 * @program: lkworkdevelop
 * @description:
 * @author: likai
 * @create: 2019-06-02 23:46
 **/

public class Person implements Serializable {
    private static final long serialVersionUID = 1234567890L;
    public int id;
    public String name;
    //public int age;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

//    public Person(int id, String name, int age) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//    }

    public String toString() {
        return "Person: " + id
                + ",name:" + name;
//                + ",age:" + age;
    }
}
