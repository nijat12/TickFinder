package com.tf.tickfinder;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class EmailTest {

	public static void main(String[] args) {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setUsername("tickfinderapp@gmail.com");
		mailSender.setPassword("v<Mx{4n{n%9d&Uq&");

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		mailSender.setJavaMailProperties(props);

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("tickfinderapp@gmail.com");
		message.setSubject("hello");
		message.setText("This is the body.");

		mailSender.send(message);
	}

}
