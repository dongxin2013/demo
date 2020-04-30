package com.example.demo.jpush.service.impl;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;
import com.example.demo.jpush.config.JiGuangConfig;
import com.example.demo.jpush.model.JPushBean;
import com.example.demo.jpush.service.MyJiGuangPushService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 极光推送
 * 封装第三方api相关
 *
 * @author dongx
 */
@Service
@Slf4j
public class MyJiGuangPushServiceImpl implements MyJiGuangPushService {
    @Resource
    private JiGuangConfig jPushConfig;

    /**
     * 广播 (所有平台，所有设备, 不支持附加信息)
     *
     * @param jPushBean 推送内容
     * @return boolean
     */
    @Override
    public boolean pushAll(JPushBean jPushBean) {
        return sendPush(PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.all())
                .setNotification(Notification.alert(jPushBean.getAlert()))
                .build());
    }

    /**
     * ios广播
     *
     * @param jPushBean 推送内容
     * @return boolean
     */
    @Override
    public boolean pushIos(JPushBean jPushBean) {
        return sendPush(PushPayload.newBuilder()
                .setPlatform(Platform.ios())
                .setAudience(Audience.all())
                .setNotification(Notification.ios(jPushBean.getAlert(), jPushBean.getExtras()))
                .build());
    }

    /**
     * ios通过registerId推送 (一次推送最多 1000 个)
     *
     * @param jPushBean  推送内容
     * @param registerId 推送id
     * @return boolean
     */
    @Override
    public boolean pushIos(JPushBean jPushBean, String... registerId) {
        return sendPush(PushPayload.newBuilder()
                .setPlatform(Platform.ios())
                .setAudience(Audience.registrationId(registerId))
                .setNotification(Notification.ios(jPushBean.getAlert(), jPushBean.getExtras()))
                .build());
    }

    /**
     * ios通过 tags 推送 (一次推送最多 1000 个)
     *
     * @param jPushBean  推送内容
     * @param tags 标签
     * @return boolean
     */
    @Override
    public boolean pushIosByTags(JPushBean jPushBean, String... tags) {
        return sendPush(PushPayload.newBuilder()
                .setPlatform(Platform.ios())
                .setAudience(Audience.tag(tags))
                .setNotification(Notification.ios(jPushBean.getAlert(), jPushBean.getExtras()))
                .build());
    }
    /**
     * ios通过 alias 推送 (一次推送最多 1000 个)
     *
     * @param jPushBean  推送内容
     * @param alias 别名
     * @return boolean
     */
    @Override
    public boolean pushIosByAlias(JPushBean jPushBean, String... alias) {
        return sendPush(PushPayload.newBuilder()
                .setPlatform(Platform.ios())
                .setAudience(Audience.alias(alias))
                .setNotification(Notification.ios(jPushBean.getAlert(), jPushBean.getExtras()))
                .build());
    }

    /**
     * android广播
     *
     * @param jPushBean 推送内容
     * @return boolean
     */
    @Override
    public boolean pushAndroid(JPushBean jPushBean) {
        return sendPush(PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.all())
                .setNotification(Notification.android(jPushBean.getAlert(), jPushBean.getTitle(), jPushBean.getExtras()))
                .build());
    }

    /**
     * android通过registerId推送 (一次推送最多 1000 个)
     *
     * @param jPushBean  推送内容
     * @param registerId 推送id
     * @return boolean
     */
    @Override
    public boolean pushAndroid(JPushBean jPushBean, String... registerId) {
        return sendPush(PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.registrationId(registerId))
                .setNotification(Notification.android(jPushBean.getAlert(), jPushBean.getTitle(), jPushBean.getExtras()))
                .build());
    }

    /**
     * android通过 tag 推送 (一次推送最多 1000 个)
     *
     * @param jPushBean  推送内容
     * @param tags 标签
     * @return boolean
     */
    @Override
    public boolean pushAndroidByTags(JPushBean jPushBean, String... tags) {
        return sendPush(PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.tag(tags))
                .setNotification(Notification.android(jPushBean.getAlert(), jPushBean.getTitle(), jPushBean.getExtras()))
                .build());
    }
    /**
     * android通过 alias 推送 (一次推送最多 1000 个)
     *
     * @param jPushBean  推送内容
     * @param alias 别名
     * @return boolean
     */
    @Override
    public boolean pushAndroidByAlias(JPushBean jPushBean, String... alias) {
        return sendPush(PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.alias(alias))
                .setNotification(Notification.android(jPushBean.getAlert(), jPushBean.getTitle(), jPushBean.getExtras()))
                .build());
    }

    /**
     * 调用api推送
     *
     * @param pushPayload 推送实体
     * @return boolean
     */
    @Override
    public boolean sendPush(PushPayload pushPayload) {
        log.info("发送极光推送请求: {}", pushPayload);
        PushResult result = null;
        try {
            result = jPushConfig.getJPushClient().sendPush(pushPayload);
        } catch (APIConnectionException e) {
            log.error("极光推送连接异常: ", e);
        } catch (APIRequestException e) {
            log.error("极光推送请求异常: ", e);
        }
        if (result != null && result.isResultOK()) {
            log.info("极光推送请求成功: {}", result);
            return true;
        } else {
            log.info("极光推送请求失败: {}", result);
            return false;
        }
    }
}
