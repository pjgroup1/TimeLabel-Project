package com.javateam.TimeLabel.service.impl;

import com.javateam.TimeLabel.model.MailVO;
import com.javateam.TimeLabel.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service("mailService")
public class MailServiceImpl implements MailService {
    // spring-context-support 필요함
    @Autowired
    JavaMailSender mailSender;

    @Override
    public void sendEmail(MailVO mail) {

        final MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

                helper.setFrom(mail.getMailFrom()); // recipient
                helper.setTo(mail.getMailTo()); // sender
                helper.setSubject(mail.getMailSubject());
                helper.setText(mail.getMailContent(), true);

            }
        };

        mailSender.send(preparator);
    }
}
