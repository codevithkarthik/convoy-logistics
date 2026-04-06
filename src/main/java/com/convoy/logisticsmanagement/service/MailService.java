package com.convoy.logisticsmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendMail(String toMail, String subject, String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("karthikkalluri2003@gmail.com");
		message.setTo(toMail);
		message.setSubject(subject);
		message.setText(content);
		javaMailSender.send(message);
	}
}
