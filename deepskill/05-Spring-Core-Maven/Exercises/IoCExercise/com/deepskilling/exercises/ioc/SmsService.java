package com.deepskilling.exercises.ioc;

public class SmsService implements MessageService {
    @Override
    public String getMessage() {
        return "SMS sent!";
    }
}
