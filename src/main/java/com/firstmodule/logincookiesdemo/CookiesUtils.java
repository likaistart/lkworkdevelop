package com.firstmodule.logincookiesdemo;



import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: workrealdevelop
 * @description:
 * @author: likai
 * @create: 2019-05-10 19:07
 **/
public class CookiesUtils {


    /**
     * 接口调用 POST
     *
     * @param POST_URL
     * @param parm
     */
    public Map<String, List<String>> httpURLConnectionPOST(String POST_URL, String parm) {
        Map<String, List<String>> headerFields = new HashMap<String, List<String>>();
        try {
            URL url = new URL(POST_URL); // 把字符串转换为URL请求地址

            // 将url 以 open方法返回的urlConnection 连接强转为HttpURLConnection连接 (标识一个url所引用的远程对象连接)
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 此时cnnection只是为一个连接对象,待连接中
            // 设置连接输出流为true,默认false (post 请求是以流的方式隐式的传递参数)
            connection.setDoOutput(true);
            // 设置连接输入流为true
            connection.setDoInput(true);
            // 设置请求方式为post
            connection.setRequestMethod("POST");
            // post请求缓存设为false
            connection.setUseCaches(false);
            // 设置该HttpURLConnection实例是否自动执行重定向
            connection.setInstanceFollowRedirects(true);
            // 设置请求头里面的各个属性 (以下为设置内容的类型,设置为经过urlEncoded编码过的from参数)
            // application/x-javascript text/xml->xml数据 application/x-javascript->json对象
            // application/x-www-form-urlencoded->表单数据
            // charset=utf-8 必须要，不然会出现乱码
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

            // 建立连接 (请求未开始,直到connection.getInputStream()方法调用时才发起,以上各个参数设置需在此方法之前进行)
            // 创建输入输出流,用于往连接里面输出携带的参数,(输出内容为?后面的内容)
            DataOutputStream dataout = new DataOutputStream(connection.getOutputStream());
            // 将参数输出到连接
            dataout.writeBytes(parm);
            headerFields = connection.getHeaderFields();
            // 输出完成后刷新并关闭流
            dataout.flush();
            dataout.close(); // 重要且易忽略步骤 (关闭流,切记!)
            // 连接发起请求,处理服务器响应 (从连接获取到输入流并包装为bufferedReader)
            BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            StringBuilder sb = new StringBuilder(); // 用来存储响应数据
            // 循环读取流,若不到结尾处
            while ((line = bf.readLine()) != null) {
                sb.append(line).append(System.getProperty("line.separator"));
            }
            bf.close(); // 重要且易忽略步骤 (关闭流,切记!)
            connection.disconnect(); // 销毁连接
        } catch (Exception e) {
            e.printStackTrace();
        }
        return headerFields;
    }


    /**
     * 处理反欺诈接口所需Cookies信息
     *
     * @return
     */
    public Map<String, String> handleLoginCookies(Map<String, List<String>> headerFields) {
        Map<String, String> cookiesMap = new HashMap<String, String>();
        if (headerFields != null) {
            // 获取token和session值，调用反欺诈添加/移除接口使用
            List<String> list = headerFields.get("Set-Cookie");
            if (list != null && list.size() > 1) {
                String[] split = list.get(1).split(";");
                if (split != null) {
                    String tokenId = split[0].replace("XSRF-TOKEN=", "");
                    cookiesMap.put("XSRF-TOKEN", tokenId);
                }

                String[] split2 = list.get(0).split(";");
                if (split2 != null) {
                    String sessionId = split2[0].replace("SESSION=", "");
                    cookiesMap.put("SESSION", sessionId);
                }
            }

        }
        return cookiesMap;
    }

}
