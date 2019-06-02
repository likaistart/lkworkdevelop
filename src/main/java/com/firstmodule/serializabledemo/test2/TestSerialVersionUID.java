package com.firstmodule.serializabledemo.test2;

import java.io.*;

/**
 * @program: lkworkdevelop
 * @description:
 * @author: likai
 * @create: 2019-06-02 12:00
 **/
public class TestSerialVersionUID {
    public static void main(String[] args) throws Exception {
        SerializeCustomer();// 序列化Customer对象
        Customer customer = DeserializeCustomer();// 反序列Customer对象
        System.out.println(customer);
    }

    private static void SerializeCustomer() throws FileNotFoundException, IOException {
        Customer customer = new Customer("gacl", 25);
        // ObjectOutputStream 对象输出流
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
                new File("/Users/likai/4paradigmdoc/fileinfo/Customer.txt")));
        oo.writeObject(customer);
        System.out.println("Customer对象序列化成功！");
        oo.close();
    }

    private static Customer DeserializeCustomer() throws Exception, IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File("/Users/likai/4paradigmdoc/fileinfo/Customer.txt")));
        Customer customer = (Customer) ois.readObject();
        System.out.println("Customer对象反序列化成功！");
        return customer;
    }

}

