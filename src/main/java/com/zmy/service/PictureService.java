package com.zmy.service;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-23 14:53
 */
public interface PictureService {

    /**
     *  头像的图片名字存入数据库中
     *
     * @param username  用户名
     * @param fileName  图片名
     */
    void uploadPicture(String username,String fileName);

    /**
     *  下载头像
     *
     * @param username
     * @return
     */
    String DownloadPic(String username);
}
