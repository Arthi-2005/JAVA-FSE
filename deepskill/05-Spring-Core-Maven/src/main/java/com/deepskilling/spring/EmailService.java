package com.deepskilling.spring;

import org.springframework.stereotype.Service;

@Service
public class EmailService implements MessageService {
    @Override
    public String getMessage() {
        return "Email sent successfully!";
    }
}
