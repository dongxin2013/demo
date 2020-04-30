package com.example.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.IUserTempService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 用户临时表 前端控制器
 * </p>
 *
 * @author 董鑫
 * @since 2019-10-30
 */
@Controller
@RequestMapping("/temp/user-temp")
public class UserTempController {

    @Resource
    private IUserTempService userTempServiceImpl;

    @RequestMapping("/save")
    public JSONObject save(@RequestParam("filePath") String filePath) {
        userTempServiceImpl.saveUserList(filePath);
        JSONObject json = new JSONObject();
        json.put("status","ok");
        return json;
    }

}

