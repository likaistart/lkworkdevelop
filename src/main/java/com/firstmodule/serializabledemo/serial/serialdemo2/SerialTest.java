package com.firstmodule.serializabledemo.serial.serialdemo2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @program: lkworkdevelop
 * @description:
 * @author: likai
 * @create: 2019-06-02 23:46
 **/
public class SerialTest {
    public static void main(String[] args) throws IOException {
        //Person person = new Person(1234, "wang", 100);
        Person person = new Person(1234, "wang");
        System.out.println("Person Serial" + person);
        FileOutputStream fos = new FileOutputStream("Person.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(person);
        oos.flush();
        oos.close();
    }
}
