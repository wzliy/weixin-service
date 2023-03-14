package com.tencent.wxcloudrun.model;

import lombok.Data;

@Data
public class ChatGptAI {
    /**
     * 请求次数
     */
    private Integer reqTimes;
    /**
     * 请求状态
     */
    private String status;
    /**
     * 回复内容
     */
    private String reply;
}
