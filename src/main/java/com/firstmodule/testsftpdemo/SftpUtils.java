package com.firstmodule.testsftpdemo;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @program: workrealdevelop
 * @description:
 * @author: likai
 * @create: 2019-05-10 15:14
 **/
public class SftpUtils {
    /**
     * @param hostIp
     * @param port
     * @param user
     * @param psw
     * @return
     */
    public Session sshSftpReadFile(String hostIp, int port, String user, String psw) {
        boolean result = false;

        Session curSession = null;
        JSch jsch = new JSch();
        try {
            if (port <= 0) {
                // 连接服务器，采用默认端口
                curSession = jsch.getSession(user, hostIp);
            } else {
                // 采用指定的端口连接服务器
                curSession = jsch.getSession(user, hostIp, port);
            }
            // 如果服务器连接不上，则抛出异常
            if (curSession == null) {
                throw new Exception("session is null");
            }
            // 设置登陆主机的密码
            curSession.setPassword(psw);// 设置密码
            // 设置第一次登陆的时候提示，可选值：(ask | yes | no)
            curSession.setConfig("StrictHostKeyChecking", "no");
            curSession.connect();
            result = true;
        } catch (Exception e) {
            //logger.error(e.getMessage(), e);
        } finally {
            if (result) {
                //  logger.debug("jsch connect host:{} success", hostIp);
            } else {
                //logger.debug("jsch connect host:{} failure", hostIp);
            }
        }
        return curSession;
    }


    public void upload(String directory, String uploadFile, Session session) {
        ChannelSftp chSftp = null;
        try {
            Channel channel = session.openChannel("sftp"); // 打开SFTP通道
            channel.connect(); // 建立SFTP通道的连接
            chSftp = (ChannelSftp) channel;
            File file = new File(uploadFile);
            long fileSize = file.length();

            /*方法一*/
            OutputStream out = chSftp.put(directory); // 使用OVERWRITE模式
            byte[] buff = new byte[1024 * 256]; // 设定每次传输的数据块大小为256KB
            int read;
            if (out != null) {
                InputStream is = new FileInputStream(uploadFile);
                do {
                    read = is.read(buff, 0, buff.length);
                    if (read > 0) {
                        out.write(buff, 0, read);
                    }
                    out.flush();
                } while (read >= 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            chSftp.quit();
        }
    }
}
