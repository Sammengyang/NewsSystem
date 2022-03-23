package com.zmy.service.Impl;

import com.zmy.dao.AccountDao;
import com.zmy.dao.Impl.accountDaoImpl;
import com.zmy.service.PictureService;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-23 14:54
 */
public class PictureServiceImpl implements PictureService {

    private final AccountDao accountDao = new accountDaoImpl();

    /**
     *  头像的图片名字存入数据库中
     *
     * @param username  用户名
     * @param fileName  图片名
     */
    @Override
    public void uploadPicture(String username, String fileName) {
        accountDao.uploadPicture(username,fileName);
    }

    @Override
    public String DownloadPic(String username) {
        return accountDao.DownloadPic(username);
    }
}
