package com.mywaysai.smartprocurementvendormanagementsystem.service;



import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendSimpleMail(String to, String subject, String body) {
        try {
            SimpleMailMessage msg = new SimpleMailMessage();

            msg.setFrom("ganeshnbbombulage@gmail.com"); // ✅ important
            msg.setTo("ganeshnbbombulage@gmail.com");
            msg.setSubject(subject);
            msg.setText(body);

            mailSender.send(msg);

            System.out.println("✅ Email sent successfully to " + to);

        } catch (Exception e) {
            System.out.println("❌ Email failed");
            e.printStackTrace();
        }
    }
}