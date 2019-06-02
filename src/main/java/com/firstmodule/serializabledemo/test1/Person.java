package com.firstmodule.serializabledemo.test1;

import java.io.Serializable;

/**
 * @program: workdemo
 * @description:
 * @author: likai
 * @create: 2019-05-31 18:15
 **/
public class Person implements Serializable {


    private int age;
    private String name;
    private String sex;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

