package DIP;

public class DIPDemo {
    public static void main(String[] args) {
        NotificationService emailService = new NotificationService(new EmailSender());
        emailService.notify("Welcome to the platform!");
        NotificationService smsService = new NotificationService(new SmsSender());
        smsService.notify("Your OTP is 1234");
    }
}
