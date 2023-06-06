package com.haiyun.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class MailUtils {

    //如果要使用邮箱 那么需要调用java提供的邮箱配置
    @Autowired
    private JavaMailSenderImpl mailSender;
    @Value("${spring.mail.username}")
    private String mailfrom;

    // 发送邮件 需要 发送人，接收人，邮件标题，邮件的主体信息
    // springboot 读取配置文件的信息 数据

    // 发送简单邮件
    public void sendSimpleEmail(String mailto, String title, String content) {
        //  定制邮件发送内容
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailfrom);
        message.setTo(mailto);

        // 设置邮件的标题
        message.setSubject(title);
        message.setText(content);
        // 发送邮件
        mailSender.send(message);
    }
}
