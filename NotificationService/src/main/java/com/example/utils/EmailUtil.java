package com.example.utils;

import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class EmailUtil {

    public void sendEmail(Session session, String toEmail, String subject, String body) {
        try {
            MimeMessage msg = new MimeMessage(session);

            // Set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            // Set mail subject
            msg.setSubject(subject, "UTF-8");

            // Set mail body
            msg.setText(body, "UTF-8");

            // Set mail sent date
            msg.setSentDate(new Date());

            // Set email recipient TO field
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

            System.out.println("Message is ready to send!!");

            // Send the email
            Transport.send(msg);

            System.out.println("Email is sent successfully!!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

