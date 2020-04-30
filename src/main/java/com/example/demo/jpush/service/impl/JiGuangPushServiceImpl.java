package com.example.demo.jpush.service.impl;

import com.example.demo.jpush.model.JPushBean;
import com.example.demo.jpush.service.JiGuangPushService;
import com.example.demo.jpush.service.MyJiGuangPushService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 推送服务
 * 封装业务功能相关
 *
 * @author dongx
 */
@Service
public class JiGuangPushServiceImpl implements JiGuangPushService {
    /**
     * 一次推送最大数量 (极光限制1000)
     */
    private static final int MAX_SIZE = 800;
    @Resource
    private MyJiGuangPushService jPushService;

    /**
     * 推送全部, 不支持附加信息
     *
     * @return boolean
     */
    @Override
    public boolean pushAll(JPushBean jPushBean) {
        return jPushService.pushAll(jPushBean);
    }

    /**
     * 推送全部ios
     *
     * @return boolean
     */
    @Override
    public boolean pushIos(JPushBean jPushBean) {
        return jPushService.pushIos(jPushBean);
    }

    /**
     * 推送ios 指定id
     *
     * @return boolean
     */
    @Override
    public boolean pushIos(JPushBean jPushBean, String... registerId) {
        /*剔除无效register*/
        registerId = checkRegisterIds(registerId);
        /*每次推送max_size个*/
        while (registerId.length > MAX_SIZE) {
            jPushService.pushIos(jPushBean, Arrays.copyOfRange(registerId, 0, MAX_SIZE));
            registerId = Arrays.copyOfRange(registerId, MAX_SIZE, registerId.length);
        }
        return jPushService.pushIos(jPushBean, registerId);
    }

    /**
     * 推送ios 指定Tag
     *
     * @return boolean
     */
    @Override
    public boolean pushIosByTags(JPushBean jPushBean, String... tags) {
        /*剔除无效tag*/
        tags = checkRegisterIds(tags);
        /*每次推送max_size个*/
        while (tags.length > MAX_SIZE) {
            jPushService.pushIosByTags(jPushBean, Arrays.copyOfRange(tags, 0, MAX_SIZE));
            tags = Arrays.copyOfRange(tags, MAX_SIZE, tags.length);
        }
        return jPushService.pushIosByTags(jPushBean, tags);
    }

    /**
     * 推送ios 指定 alias
     *
     * @param jPushBean  推送内容
     * @param alias 别名
     *
     * @return boolean
     */
    @Override
    public boolean pushIosByAlias(JPushBean jPushBean, String... alias) {
        /*剔除无效 alias*/
        alias = checkRegisterIds(alias);
        /*每次推送max_size个*/
        while (alias.length > MAX_SIZE) {
            jPushService.pushIosByAlias(jPushBean, Arrays.copyOfRange(alias, 0, MAX_SIZE));
            alias = Arrays.copyOfRange(alias, MAX_SIZE, alias.length);
        }
        return jPushService.pushIosByAlias(jPushBean, alias);
    }

    /**
     * 推送全部android
     *
     * @return boolean
     */
    @Override
    public boolean pushAndroid(JPushBean jPushBean) {
        return jPushService.pushAndroid(jPushBean);
    }

    /**
     * 推送android 指定id
     * @param jPushBean  推送内容
     * @param registerId 推送id
     * @return boolean
     */
    @Override
    public boolean pushAndroid(JPushBean jPushBean, String... registerId) {
        /*剔除无效register*/
        registerId = checkRegisterIds(registerId);
        /*每次推送max_size个*/
        while (registerId.length > MAX_SIZE) {
            jPushService.pushAndroid(jPushBean, Arrays.copyOfRange(registerId, 0, MAX_SIZE));
            registerId = Arrays.copyOfRange(registerId, MAX_SIZE, registerId.length);
        }
        return jPushService.pushAndroid(jPushBean, registerId);
    }

    /**
     * 推送android 指定id
     * @param jPushBean  推送内容
     * @param tags 别名
     * @return boolean
     */
    @Override
    public boolean pushAndroidByTags(JPushBean jPushBean, String... tags) {
        /*剔除无效tag*/
        tags = checkRegisterIds(tags);
        /*每次推送max_size个*/
        while (tags.length > MAX_SIZE) {
            jPushService.pushAndroidByTags(jPushBean, Arrays.copyOfRange(tags, 0, MAX_SIZE));
            tags = Arrays.copyOfRange(tags, MAX_SIZE, tags.length);
        }
        return jPushService.pushAndroidByTags(jPushBean, tags);
    }

    /**
     * 推送android 指定 alias
     *
     * @param jPushBean  推送内容
     * @param alias 别名
     *
     * @return boolean
     */
    @Override
    public boolean pushAndroidByAlias(JPushBean jPushBean, String... alias) {
        /*剔除无效 alias*/
        alias = checkRegisterIds(alias);
        /*每次推送max_size个*/
        while (alias.length > MAX_SIZE) {
            jPushService.pushAndroidByAlias(jPushBean, Arrays.copyOfRange(alias, 0, MAX_SIZE));
            alias = Arrays.copyOfRange(alias, MAX_SIZE, alias.length);
        }
        return jPushService.pushAndroidByAlias(jPushBean, alias);
    }

    /**
     * 剔除无效 register
     *
     * @param registerIds 推送id
     * @return String[]
     */
    @Override
    public String[] checkRegisterIds(String[] registerIds) {
        List<String> regList = new ArrayList<>(registerIds.length);
        for (String registerId : registerIds) {
            if (registerId != null && !"".equals(registerId.trim())) {
                regList.add(registerId);
            }
        }
        return regList.toArray(new String[0]);
    }
}
