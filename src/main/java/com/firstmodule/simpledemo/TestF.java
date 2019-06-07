package com.firstmodule.simpledemo;

/**
 * @program: lkworkdevelop
 * @description: https://www.cnblogs.com/hongten/p/hongten_java_integer_toBinaryString.html
 * @author: likai
 * @create: 2019-06-05 08:59
 **/
public class TestF {

    public static void main(String[] args) {
        //output:1000
        System.out.println(toBinaryString(8));
        printInfo();
    }

    /**
     * 这里是做&操作的测试，也就是说，在1&*（其中*代表其他数字，如：0,1,2,3,4...）操作的时候
     * 他们是进行二进制之间的&(与)运算操作。只有当*为奇数（1,3,5,7...）的时候，1*&操作才可以返回：1
     * 其他情况返回：0
     */
    private static void printInfo() {
        for (int i = 0; i < 10; i++) {
            System.out.println("i= " + i + "         " + (i & 1));
        }
        /*
        output:
        i= 0         0
        i= 1         1
        i= 2         0
        i= 3         1
        i= 4         0
        i= 5         1
        i= 6         0
        i= 7         1
        i= 8         0
        i= 9         1
        */
    }

    public static String toBinaryString(int i) {
        return toUnsignedString(i, 1);
    }

    /**
     * Convert the integer to an unsigned number.
     */
    private static String toUnsignedString(int i, int shift) {
        char[] buf = new char[32];
        int charPos = 32;
        int radix = 1 << shift;
        int mask = radix - 1;
        do {
            //这里的mask一直为：1，所以当i为奇数的时候，这里"i & mask"操作才为：1
            //否则返回：0
            //System.out.println(i & mask);
            buf[--charPos] = digits[i & mask];
            i >>>= shift;//右移赋值，左边空出的位以0填充
            //System.out.println(buf);
            //System.out.println(charPos);
            //System.out.println(i);
        } while (i != 0);
        return new String(buf, charPos, (32 - charPos));
    }

    final static char[] digits = {
            '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'
    };
}
