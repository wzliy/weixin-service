package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.model.Message;
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
    public String get(@RequestBody Message message) {
        logger.info("收到消息推送：{}", message.getContent());

        return "success";
    }
}
