package com.deepskilling.spring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
class AppConfigTest {

    @Autowired
    private MessageService emailService;

    @Autowired
    private NotificationClient notificationClient;

    @Test
    void emailService_shouldSendMessage() {
        String msg = emailService.getMessage();
        assertTrue(msg.contains("Email"));
    }

    @Test
    void notificationClient_shouldNotBeNull() {
        assertNotNull(notificationClient);
    }
}
