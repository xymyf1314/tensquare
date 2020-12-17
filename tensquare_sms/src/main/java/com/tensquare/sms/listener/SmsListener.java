package com.tensquare.sms.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <p>监听类
 * <p>Compiler: miyf
 * <p>版本:xxxxxxxxxx
 * <p>文件名：com.tensquare.sms.listener.SmsListener.java
 * <p>作者: miyf
 * <p>创建时间: 2020年12月17日 11:35
 * <p>负责人: miyf
 * <p>修改者： miyf
 * <p>修改时间：
 */
@Component
@RabbitListener(queues = "sms")
public class SmsListener {

    @RabbitHandler
    public void executeSms(Map<String, String> map) {
        System.out.println("手机号：" + map.get("mobile"));
        System.out.println("验证码：" + map.get("checkcode"));
    }
}
