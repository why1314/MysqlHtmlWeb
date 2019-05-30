package com.itheima.utils;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * 发送邮件工具类
 */
public final class MailUtils {
    private MailUtils() {
    }

    /**
     * 发送邮件
     * 参数一:发送邮件给谁
     * 参数二:发送邮件的内容
     */
    public static void sendMail(String toEmail, String emailMsg) throws Exception {
        //1_创建Java程序与163邮件服务器的连接对象
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.126.com");
        props.put("mail.smtp.auth", "true");
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("why191314bzd", "b123456");
            }
        };
        Session session = Session.getInstance(props, auth);
        //2_创建一封邮件
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("why191314bzd@126.com"));
        message.setRecipient(RecipientType.TO, new InternetAddress(toEmail));
        message.setSubject("用户激活");
        message.setContent(emailMsg, "text/html;charset=UTF-8");
        //3_发送邮件
        Transport.send(message);
    }

    /**
     * 测试类
     */
    public static void main(String[] args) throws Exception {
        String toEmail = "1826552585@qq.com";
        String emailMsg = "测试一下";
        sendMail(toEmail, emailMsg);
        System.out.println("发送成功。。。");
    }
}








