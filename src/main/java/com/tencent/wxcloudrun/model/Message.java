package com.tencent.wxcloudrun.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

@Data
public class Message implements Serializable {

    /**
     * 唯一消息ID，可能发送多个重复消息，需要注意用此 ID 去重
     */
    @JsonProperty("MsgId")
    private long msgId;
    /**
     * 小程序/公众号的原始ID，资源复用配置多个时可以区别消息是给谁的
     */
    @JsonProperty("ToUserName")
    private String toUserName;
    /**
     * 该小程序/公众号的用户身份openid
     */
    @JsonProperty("FromUserName")
    private String fromUserName;
    /**
     * 消息时间
     */
    @JsonProperty("CreateTime")
    private long createTime;
    /**
     * 消息类型
     */
    @JsonProperty("MsgType")
    private String msgType;
    /**
     * 消息内容
     */
    @JsonProperty("Content")
    private String content;
}
