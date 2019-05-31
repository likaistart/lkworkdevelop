package com.firstmodule.simpledemo;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;

/**
 * @program: workdemo
 * @description:
 * @author: likai
 * @create: 2019-05-30 11:52
 **/
public class EncoderDemo {
    public static void main(String[] args) throws UnsupportedEncodingException, CharacterCodingException {
        //Charset latin1 = Charset.forName("ISO-8859-1");    // 只能表示的英文字符
        Charset latin1 = Charset.forName("UTF-8");    // 只能表示的英文字符
        CharsetEncoder encoder = latin1.newEncoder();    // 得到编码器
        CharsetDecoder decoder = latin1.newDecoder();    // 得到解码器
        // 通过CharBuffer类中的
        //CharBuffer cb = CharBuffer.wrap("a");
        CharBuffer cb = CharBuffer.wrap("杭州的小强");
        ByteBuffer buf = encoder.encode(cb);    // 进行编码操作
        System.out.println(decoder.decode(buf));    // 进行解码操作

        System.out.println("***********华丽的分割线***********");

        SortedMap<String, Charset> all = Charset.availableCharsets();    // 得到全部可用的字符集
        Iterator<Map.Entry<String, Charset>> iter = all.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Charset> me = iter.next();
            System.out.println(me.getKey() + " --> " + me.getValue());
        }
    }
}
