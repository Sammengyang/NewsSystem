package com.zmy.Utils;

import com.zmy.pojo.Account;
import com.zmy.service.Impl.SignServiceImpl;
import com.zmy.service.SignService;
import org.junit.Test;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-18 23:25
 */
public class Test1 {
    @Test
    public void test(){
        SendSmsUtil.SendSms("15039947675");
    }
    // 测试注册
    @Test
    public void testSign(){
        Account account = new Account();
        account.setUserName("sam");
        account.setPassword("1");
        account.setTel("110");
        SignService signService = new SignServiceImpl();
        signService.login(account);
    }
    @Test
    public void testtel(){
    }
}
