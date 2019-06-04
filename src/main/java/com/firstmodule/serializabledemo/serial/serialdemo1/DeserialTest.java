package com.firstmodule.serializabledemo.serial.serialdemo1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @program: lkworkdevelop
 * @description:
 * @author: likai
 * @create: 2019-06-02 23:41
 **/
public class DeserialTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person;

        FileInputStream fis = new FileInputStream("Person.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        person = (Person) ois.readObject();
        ois.close();
        System.out.println("Person Deserial" + person);
    }
}
