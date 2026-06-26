package com.deepskilling.exercises.ioc;

public class EmailService implements MessageService {
    @Override
    public String getMessage() {
        return "Email sent!";
    }
}
