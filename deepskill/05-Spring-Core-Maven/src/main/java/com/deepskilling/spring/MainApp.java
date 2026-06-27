package com.deepskilling.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        NotificationClient client = context.getBean(NotificationClient.class);
        client.sendNotification();

        MessageService sms = context.getBean("smsService", MessageService.class);
        System.out.println(sms.getMessage());

        ((AnnotationConfigApplicationContext) context).close();
    }
}
