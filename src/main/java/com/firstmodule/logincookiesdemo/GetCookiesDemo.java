package com.firstmodule.logincookiesdemo;

import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @program: workrealdevelop
 * @description:
 * @author: likai
 * @create: 2019-05-10 19:10
 **/
public class GetCookiesDemo {
    @Test
    public void getCookies() {
        final String antiFraudUrl = "http://172.27.133.106:9080";
        final String postUrl = antiFraudUrl + "/api/v1/user/login";
        //String param = "username=" + "likai" + "&password=" + "a1234567" + "&ie=utf-8";
        String param = "username=" + "dakai537" + "&password=" + "a1234567" + "&tenantId=" + "anti_fraud_test" + "&ie=utf-8";
        //String param = "username=" + "likai" + "&password=" + "a1234567";
        CookiesUtils cookiesUtils = new CookiesUtils();
        Map<String, List<String>> headerFields = cookiesUtils.httpURLConnectionPOST(postUrl, param);
        Map<String, String> loginCookies = cookiesUtils.handleLoginCookies(headerFields);
        if (null!=loginCookies&&loginCookies.size()>0) {
            System.out.println("loginCookies数量为:"+loginCookies);
        }else {
            System.out.println("loginCookies数量为:"+loginCookies);
        }
    }
}
