package com.deepskilling.exercises.ioc;

/*
 * Demo: Shows that the IoC container manages object creation & lifecycle,
 * not the client. The client simply asks the container for a named bean.
 */
public class IoCExerciseDemo {
    public static void main(String[] args) {
        System.out.println("=== Inversion of Control (IoC) Demonstration ===\n");

        Container container = new Container();

        container.registerBean("emailService", new EmailService());
        container.registerBean("smsService", new SmsService());

        System.out.println();

        MessageService email = container.getBean("emailService", MessageService.class);
        System.out.println("Email: " + email.getMessage());

        MessageService sms = container.getBean("smsService", MessageService.class);
        System.out.println("SMS: " + sms.getMessage());

        System.out.println();
        System.out.println("Container controls lifecycle — client never uses 'new' directly.");
        System.out.println("Client only interacts with the container (IoC in action).");
    }
}
