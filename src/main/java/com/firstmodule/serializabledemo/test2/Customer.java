package com.firstmodule.serializabledemo.test2;

import java.io.Serializable;

/**
 * @program: lkworkdevelop
 * @description:
 * @author: likai
 * @create: 2019-06-02 12:00
 **/
public class Customer implements Serializable {

    //Customer类中没有定义serialVersionUID
    private String name;
    private int age;
    //新添加的sex属性
    private String sex;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Customer(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "name=" + name + ", age=" + age;
    }
}