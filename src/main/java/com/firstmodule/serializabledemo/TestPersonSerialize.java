package com.firstmodule.serializabledemo;

import java.io.*;

/**
 * @program: workdemo
 * @description:
 * @author: likai
 * @create: 2019-05-31 18:16
 **/
public class TestPersonSerialize {

    public static void main(String[] args) throws Exception {
        serializePerson();
        Person p = deserializePerson();
        System.out.println(p.getName() + ";" + p.getAge());


    }

    private static void serializePerson() throws FileNotFoundException, IOException {
        Person person = new Person();
        person.setName("测试实例");
        person.setAge(25);
        person.setSex("male");

        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
                new File("/Users/likai/4paradigmdoc/fileinfo/person.txt")));
        oo.writeObject(person);
        System.out.println("序列化成功");
        oo.close();
    }

    private static Person deserializePerson() throws IOException, Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("/Users/likai/4paradigmdoc/fileinfo/person.txt")));
        Person person = (Person) ois.readObject();
        System.out.println("反序列化成功");
        return person;
    }

}
