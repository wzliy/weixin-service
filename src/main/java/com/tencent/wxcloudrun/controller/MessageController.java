package com.tencent.wxcloudrun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息接收推送服务
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    private final Logger logger = LoggerFactory.getLogger(CounterController.class);;



    /**
     * 获取当前计数
     * @return API response json
     */
    @PostMapping(value = "/receive")
    public String get(@RequestBody String action) {
        logger.info("收到消息推送：{}", action);

        return "success";
    }
}
