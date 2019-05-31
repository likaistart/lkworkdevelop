package com.firstmodule.simpledemo;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;

/**
 * @Description https://www.cnblogs.com/kongxianghao/articles/6894354.html
 * @Author Li Kai[ lkaistart@gmail.com]
 * @Data 2019/5/18/018 22:12
 **/
public class Test1 {
    public static void main(String[] args)throws Exception {
        Charset charset = Charset.forName("UTF-8");
        CharsetEncoder charsetEncoder = charset.newEncoder();
        CharsetDecoder charsetDecoder = charset.newDecoder();

        CharBuffer fa = CharBuffer.wrap("f房贷");
        ByteBuffer encode = charsetEncoder.encode(fa);
        CharBuffer decode = charsetDecoder.decode(encode);
        System.out.println(decode);

        SortedMap<String,Charset> all = null ;
        all = Charset.availableCharsets() ;    // 得到全部可用的字符集
        Iterator<Map.Entry<String,Charset>> iter = null ;
        iter = all.entrySet().iterator() ;
        while(iter.hasNext()){
            Map.Entry<String,Charset> me = iter.next() ;
            System.out.println(me.getKey() + " --> " + me.getValue()) ;
        }
    }
}
