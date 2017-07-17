package com.example.test.demo.config;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class MailConfig {
	  
	private static MailConfig ourInstance = new MailConfig();
	private String host;
	private int port;
	private String username;
	private String password;
	private String mailAddress;
	private String auth;
	private String starttls;
	
	private MailConfig() {
		
	}
	
	@Bean
	public static MailConfig getInstance() {
		return ourInstance;
	}
	

	public void setSetting(String username,String password,String mailAddress) {
		this.host = "smtp.163.com";
		this.port = 25;
		this.username = username;
		this.password = password;
		this.mailAddress = mailAddress;
//		this.auth = Boolean.toString(true);
//		this.starttls = Boolean.toString(true);
	}
	

	public JavaMailSenderImpl getJavaMailSender() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		javaMailSender.setUsername(username);
		javaMailSender.setHost(host);
		javaMailSender.setPassword(password);
		javaMailSender.setPort(port);
		javaMailSender.setJavaMailProperties(getMailProperties());
		return javaMailSender;
	}
	
	public Properties getMailProperties() {
		Properties properties = new Properties();
		properties.setProperty("mail.smpt.auth","true");
		properties.setProperty("mail.mime.charset", "UTF-8");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		return properties;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	
	
}
