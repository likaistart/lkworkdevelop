package com.firstmodule.simpledemo;


import com.alibaba.druid.util.StringUtils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program: workrealdevelop
 * @description:
 * @author: likai
 * @create: 2019-05-10 19:48
 **/
public class Test {
    public static void main(String[] args) {
//      String filePath = "/Users/likai/lkstart/lktest/INCREASE_NAMELIST_right.txt";
        String filePath="/Users/likai/Downloads/1.txt";
        String s1 = readTxt(filePath);

        //  System.out.println(s1);

        //readTxtByNIO(filePath);
        // 若操作记录为空,即内容不符合要求直接return返回

    }


    public static String readTxtByNIO(String filePath) {
        StringBuffer stringBuffer = new StringBuffer();
        long time1 = System.currentTimeMillis();
        FileInputStream fis = null;
        FileChannel inChannel = null;
        int bufSize = 1024 * 10;
        try {
            fis = new FileInputStream(filePath);
            inChannel = fis.getChannel();
            //System.out.println("file size --->" + inChannel.size());
            ByteBuffer buffer = ByteBuffer.allocate(bufSize);
            // System.out.println("buffer init position --->"+buffer.position()+"---- buffer init remaining --->"+buffer.remaining());
            //这里标记了后面才可以调用buffer.reset(), 而且只能调用一次,
            //不然会抛出java.nio.InvalidMarkException
            //buffer.mark();
            String enterStr = "\n";
            StringBuffer strBuf = new StringBuffer("");
            int lineNum = 0;
            while (inChannel.read(buffer) != -1) {
                int rSize = buffer.position();
                buffer.clear();
                String tempString = new String(buffer.array(), 0, rSize);
                if (fis.available() == 0) {//最后一行，加入"\n分割符"
                    tempString += "\n";
                }

                int fromIndex = 0;

                int endIndex = 0;
                while ((endIndex = tempString.indexOf(enterStr, fromIndex)) != -1) {

                    String line = tempString.substring(fromIndex, endIndex);

                    line = new String(strBuf.toString() + line);
                    stringBuffer.append(line);
                    //System.out.println(line);

                    strBuf.delete(0, strBuf.length());

                    fromIndex = endIndex + 1;
                    lineNum++;
                }

                if (rSize > tempString.length()) {

                    strBuf.append(tempString.substring(fromIndex, tempString.length()));

                } else {
                    strBuf.append(tempString.substring(fromIndex, rSize));

                }
                //System.out.println("lineNum =" + lineNum);
            }
        } catch (Exception e) {
            System.out.println("文件读取错误!");
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            long time2 = System.currentTimeMillis();
            long time = (time1 - time2) / 1000;
            System.out.println("共花费" + time + "秒");
        }
        return String.valueOf(stringBuffer);
    }


    public Test() {
    }

    public static String readTxt(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String lineContent = null;
                int sumRecord = 0;
                Integer lineSum=0;
                long time1 = System.currentTimeMillis();
                while ((lineContent = br.readLine()) != null) {
                    ++sumRecord;
                    if (sumRecord == 1) {
                        lineSum =sumRecord;
                        continue;
                    }
                    stringBuilder.append(lineContent);
                    String[] split = lineContent.split("\\^\\|");
                    int length = split.length;

                    if (length > 5 && (split[5] == null || split[5].trim().length() == 0)) {
                        break;
                    }

                    // 若操作记录为空,即内容不符合要求直接return返回
                    if (StringUtils.isEmpty(split[5])&&(sumRecord-1)<lineSum) {
                        break;
                    }
                    System.out.println(split.length + "********"+lineSum+ "-------"+lineContent);
                    String valueOf = String.valueOf(split[5]);
                    break;
                }
                //System.out.println("总共"+num+"条数据！");
                long time2 = System.currentTimeMillis();
                long time = time1 - time2;
                System.out.println("共花费" + time + "秒");
                br.close();
            } else {
                System.out.println("文件不存在!");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("文件读取错误!");
        }
        return stringBuilder.toString();
    }

}
