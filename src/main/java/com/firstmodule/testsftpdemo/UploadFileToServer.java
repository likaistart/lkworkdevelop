package com.firstmodule.testsftpdemo;

import com.jcraft.jsch.*;

import java.io.File;

/**
 * @program: workrealdevelop
 * @description: 将文件上传到远程服务器
 * @author: likai
 * @create: 2019-05-10 14:58
 **/
public class UploadFileToServer {
    public static void main(String[] args) throws JSchException {
        SftpUtils sftpUtils = new SftpUtils();
        Session curSession = sftpUtils.sshSftpReadFile("172.27.4.15", 22, "work", "123456");

        File file = new File("");
        String uploadFile = "/Users/likai/lkstart/lktest/INCREASE_NAMELIST_right.txt";
        String pathUrl = "/home/work/lktest/INCREASE_NAMELIST_right.txt";
        long beginTamp = System.currentTimeMillis();

        sftpUtils.upload(pathUrl, uploadFile, curSession);
        if (null != file) {
            long length = file.length();
            System.out.println("文件内容长度为：" + length);


        }
        long endTamp = System.currentTimeMillis();


        long l = endTamp - beginTamp;


    }
}



