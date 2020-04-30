package com.example.demo.service;

import com.example.demo.entity.UserTemp;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户临时表 服务类
 * </p>
 *
 * @author 董鑫
 * @since 2019-10-30
 */
public interface IUserTempService extends IService<UserTemp> {

    /**
     * 保存
     * @param filePath
     */
    void saveUserList(String filePath);
}
