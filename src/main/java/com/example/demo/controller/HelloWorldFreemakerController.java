package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: demo
 * @description:
 * @author: dongxin
 * @create: 2019-10-16 14:44
 **/
@Slf4j
@Controller
@RequestMapping("/hello")
public class HelloWorldFreemakerController {
    /**
     *     * 设置数据，返回到freemarker视图
     *     * @return
     *    
     */
    @RequestMapping("/say")
    public JSONObject say() {
        JSONObject json = new JSONObject();
        json.put("message", "hello world!");
        json.put("status", "ok");
        boolean flag = true;
        while (flag) {
            try {
                Thread.sleep(5000);
                log.info(json.toJSONString());
            } catch (InterruptedException e) {
                e.printStackTrace();
                flag=false;
            }
        }
        return json;
    }
}
