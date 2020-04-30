package com.example.demo.jpush.service;

import com.example.demo.jpush.model.JPushBean;

/**
 * 推送服务
 * 封装业务功能相关
 * @author dongx
 */
public interface JiGuangPushService {
    /**
     * 推送全部, 不支持附加信息
     * @param jPushBean 推送内容
     * @return boolean
     */
    boolean pushAll(JPushBean jPushBean);

    /**
     * 推送全部ios
     * @param jPushBean 推送内容
     * @return boolean
     */
    boolean pushIos(JPushBean jPushBean);

    /**
     * 推送ios 指定id
     *
     * @param jPushBean 推送内容
     * @param registerIds id[]
     *
     * @return boolean
     */
    boolean pushIos(JPushBean jPushBean, String... registerIds);

    /**
     * 推送ios 指定Tag
     * @param jPushBean 推送内容
     * @param tags 标签
     * @return boolean
     */
    boolean pushIosByTags(JPushBean jPushBean, String... tags);

    /**
     * 推送ios 指定 alias
     *
     * @param jPushBean  推送内容
     * @param alias 别名
     *
     * @return boolean
     */
    boolean pushIosByAlias(JPushBean jPushBean, String... alias);

    /**
     * 推送全部android
     * @param jPushBean 推送内容
     * @return boolean
     */
    boolean pushAndroid(JPushBean jPushBean);

    /**
     * 推送android 指定id
     *
     * @param jPushBean 推送内容
     * @param registerId id
     * @return boolean
     */
    boolean pushAndroid(JPushBean jPushBean, String... registerId);

    /**
     * 推送android 指定 tag
     * @param jPushBean  推送内容
     * @param tags 别名
     * @return boolean
     */
    boolean pushAndroidByTags(JPushBean jPushBean, String... tags);

    /**
     * 推送android 指定 alias
     *
     * @param jPushBean  推送内容
     * @param alias 别名
     *
     * @return boolean
     */
    boolean pushAndroidByAlias(JPushBean jPushBean, String... alias);

    /**
     * 剔除无效 register
     *
     * @param registerIds 推送id
     * @return String[]
     */
    String[] checkRegisterIds(String[] registerIds);
}