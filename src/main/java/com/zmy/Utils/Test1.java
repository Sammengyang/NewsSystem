package com.zmy.Utils;

import com.zmy.dao.AccountDao;
import com.zmy.dao.AuthDao;
import com.zmy.dao.ColunmnDao;
import com.zmy.dao.Impl.AuthDaoImpl;
import com.zmy.dao.Impl.ColunmnDaoImpl;
import com.zmy.dao.Impl.accountDaoImpl;
import com.zmy.pojo.Account;
import com.zmy.pojo.Colunmn;
import com.zmy.service.Impl.SignServiceImpl;
import com.zmy.service.SignService;
import org.junit.Test;

import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-18 23:25
 */
public class Test1 {
    private final AuthDao authDao = new AuthDaoImpl();
    private final AccountDao accountDao = new accountDaoImpl();
    private ColunmnDao colunmnDao = new ColunmnDaoImpl();

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
    // 获取所有栏目
    @Test
    public void testtel(){
        ColunmnDao colunmnDao = new ColunmnDaoImpl();
        List<Colunmn> colList = colunmnDao.getColList();
        System.out.println(colList.get(1).toString());
    }
    //测试给账户授权
    @Test
    public void testAuth(){
        Account account = new Account();
        account.setUserName("sam");
        authDao.authtoAccount(account);
    }

}
