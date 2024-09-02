package com.gruposei.gestion_orquestas.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailSender {

    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.mail.yahoo.com");
        mailSender.setPort(587);

        mailSender.setUsername("abcdef@yahoo.com");
        mailSender.setPassword("123asdb");
        // iporkrtzszeuitbt
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.startssl.enable", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    public void sendMessageWithAttachment(String to, String subject, String text, InputStream inputStream) throws MessagingException, IOException {

        JavaMailSender mailSender = getJavaMailSender();

        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("davidboffelli@yahoo.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text);

//        FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
        helper.addAttachment("QRTicket.pdf", new ByteArrayResource(IOUtils.toByteArray(inputStream)));

        mailSender.send(message);
        // ...
    }
}
