package com.example.services;

import com.example.utils.EmailUtil;
import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Properties;


@Service
public class NotificationService {

    // Inject the values from the application.properties file
    @Value("${mail.from.email}")
    private String fromEmail;

    @Value("${mail.from.password}")
    private String fromEmailPassword;

    @Value("${mail.subject}")
    private String subject;

    @Value("${mail.body}")
    private String body;

    @Autowired
    private EmailUtil emailUtil;


    public void sendEmailNotification(String toEmail, String username) {
        // Set the properties of the email client
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");  // SMTP Host
        props.put("mail.smtp.port", "587");  // TLS Port
        props.put("mail.smtp.auth", "true");  // Enable authentication
        props.put("mail.smtp.starttls.enable", "true");  // Enable STARTTLS

        // Create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            // Override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, fromEmailPassword);
            }
        };
        // Create a Session object to authenticate the email client with the email server
        Session session = Session.getInstance(props, auth);

        emailUtil.sendEmail(session, toEmail, subject, body.replaceAll("<username>", username));
    }
}
