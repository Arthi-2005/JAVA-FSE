package com.deepskilling.spring;

import org.springframework.stereotype.Service;

@Service
public class SmsService implements MessageService {
    @Override
    public String getMessage() {
        return "SMS sent successfully!";
    }
}
