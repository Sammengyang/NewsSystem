package com.zmy.Utils;


import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.util.Random;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-12 23:23
 */
public class SendSmsUtil {
    public static String SendSms(String tel) {
        /**
         * 1.导包
         * 2.把实例代码导到项目里
         * 3.改accessKeyId  accessSecret
         * 4.测试
         * DefaultProfile.getProfile("default", "<accessKeyId>", "<accessSecret>");
         */
				/*
						用户登录名称 sam@1182235743306275.onaliyun.com
						登录密码 pGJHtw}&uGUdhKb8Gf!uKTq24@q0ISCm
						AccessKey ID LTAI5tLx26Rk5Z8iUsKTT5WE
						AccessKey Secret 5Z3XbvAPnLqVBQr5YpWv6JZjYPsFtw
				*/
        DefaultProfile profile = DefaultProfile.getProfile("default", "LTAI5tLx26Rk5Z8iUsKTT5WE", "5Z3XbvAPnLqVBQr5YpWv6JZjYPsFtw");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("PhoneNumbers", tel);
        request.putQueryParameter("SignName", "阿里云短信测试");
        request.putQueryParameter("TemplateCode", "SMS_154950909");
        // 产生验证码
//        String code = UUID.randomUUID().toString().replace("-","").substring(0,6);
        Random random = new Random();
        int code = random.nextInt(888888) +100000;
        System.out.println(code);
        request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");

        try {
            CommonResponse response = client.getCommonResponse(request);
            // Message : ok 发送短信成功
            System.out.println(response.getData());
        } catch (ClientException e) {
            e.printStackTrace();
        }
        String cod = String.valueOf(code);
        return cod;
    }
}
