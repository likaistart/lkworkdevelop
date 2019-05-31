package com.firstmodule.simpledemo;

import java.util.*;

/**
 * @program: workdemo
 * @description:
 * @author: likai
 * @create: 2019-05-31 17:20
 **/
public class CollectionDemo {
    public static void main(String[] args) {
        SortedMap<Integer, String> sm =
                new TreeMap<Integer, String>();
//        sm.put(new Integer(2), "practice");
//        sm.put(new Integer(3), "quiz");
//        sm.put(new Integer(5), "code");
//        sm.put(new Integer(4), "contribute");
//        sm.put(new Integer(1), "geeksforgeeks");
        sm.put(new Integer(1), null);
        Set s = sm.entrySet();

        // Using iterator in SortedMap
        Iterator i = s.iterator();

        // Traversing map. Note that the traversal
        // produced sorted (by keys) output .
        while (i.hasNext()) {
            Map.Entry m = (Map.Entry) i.next();

            int key = (Integer) m.getKey();
            String value = (String) m.getValue();

            System.out.println("Key : 【" + key +
                    "】  value : 【" + value + "】");
        }
    }
}
