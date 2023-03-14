package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.ChatGptAI;
import com.tencent.wxcloudrun.model.Message;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MessageService {
    private static final Map<String, ChatGptAI> chatGptAIMap = new HashMap<>();

    /**
     * 处理消息
     * @param message message
     */
    public void handle(Message message) {
        // 1. 获取回复信息
        String reply = getReply(message);
        // 2. 调用微信接口进行回复
    }

    private String getReply(Message message) {
        String key = message.getContent() + "_" + message.getFromUserName();
        if (chatGptAIMap.get(key) != null) {
            ChatGptAI chatGptAI = chatGptAIMap.get(key);
            chatGptAI.setReqTimes(chatGptAI.getReqTimes() + 1);
        }
        if (message.getContent().equals("继续")) {
            if (chatGptAIMap.get(key) == null || chatGptAIMap.get(key).getStatus().equals("done")) {
                return "目前不在等待回复状态，请输入对话";
            }
            ChatGptAI chatGptAI = chatGptAIMap.get(key);
            if (chatGptAI.getStatus().equals("waiting")) {
                return "还在处理中，请稍后再试";
            } else if (chatGptAI.getStatus().equals("success")) {
                chatGptAI.setStatus("done");
                return chatGptAI.getReply();
            } else {
                return "目前不在等待回复状态，请输入对话";
            }
        }

        if (chatGptAIMap.get(key) == null || chatGptAIMap.get(key).getStatus().equals("waiting")) {
            // 多线程处理
            return "已开始处理，请稍等片刻后输入\"继续\"查看回复";
        }

        if (chatGptAIMap.get(key).getStatus().equals("done")) {
            // 多线程处理
            buildChatAI();
            return chatGptAIMap.get(key).getReply();
        }

        return "上一句对话正在处理中，请稍后输入\"继续\"查看回复";

    }

    private void buildChatAI() {
//        chatGptAIMap.put("")
    }

    private void wechatReply() {

    }

}
