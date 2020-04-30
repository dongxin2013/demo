package com.example.demo.jpush.service;
import cn.jpush.api.push.model.PushPayload;
import com.example.demo.jpush.model.JPushBean;

/**
 * 极光推送
 * 封装第三方api相关
 * @author dongx
 */
public interface MyJiGuangPushService {
    /**
     * 广播 (所有平台，所有设备, 不支持附加信息)
     *
     * @param jPushBean 推送内容
     * @return boolean
     */
    boolean pushAll(JPushBean jPushBean);

    /**
     * ios广播
     *
     * @param jPushBean 推送内容
     * @return boolean
     */
    boolean pushIos(JPushBean jPushBean);

    /**
     * ios通过registerId推送 (一次推送最多 1000 个)
     *
     * @param jPushBean  推送内容
     * @param registerId 推送id
     * @return boolean
     */
    boolean pushIos(JPushBean jPushBean, String... registerId);

    /**
     * ios通过 tags 推送 (一次推送最多 1000 个)
     *
     * @param jPushBean  推送内容
     * @param tags 标签
     * @return boolean
     */
    boolean pushIosByTags(JPushBean jPushBean, String... tags);

    /**
     * ios通过 alias 推送 (一次推送最多 1000 个)
     *
     * @param jPushBean  推送内容
     * @param alias 别名
     * @return boolean
     */
    boolean pushIosByAlias(JPushBean jPushBean, String... alias);

    /**
     * android广播
     *
     * @param jPushBean 推送内容
     * @return boolean
     */
    boolean pushAndroid(JPushBean jPushBean);

    /**
     * android通过registerId推送 (一次推送最多 1000 个)
     *
     * @param jPushBean  推送内容
     * @param registerId 推送id
     * @return boolean
     */
    boolean pushAndroid(JPushBean jPushBean, String... registerId);

    /**
     * android通过 tag 推送 (一次推送最多 1000 个)
     *
     * @param jPushBean  推送内容
     * @param tags 标签
     * @return boolean
     */
    boolean pushAndroidByTags(JPushBean jPushBean, String... tags);

    /**
     * android通过 alias 推送 (一次推送最多 1000 个)
     *
     * @param jPushBean  推送内容
     * @param alias 别名
     * @return boolean
     */
    boolean pushAndroidByAlias(JPushBean jPushBean, String... alias);

    /**
     * 调用api推送
     *
     * @param pushPayload 推送实体
     * @return boolean
     */
    boolean sendPush(PushPayload pushPayload);
}