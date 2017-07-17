package com.example.test.demo.bean;

import java.util.Properties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Email_Send {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String emailTitle;
    private String emailDate;
	private String emailSender;
    private String emailReciever;
    private String emailContent;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getEmailTitle() {
		return emailTitle;
	}
	public void setEmailTitle(String emailTitle) {
		this.emailTitle = emailTitle;
	}
	public String getEmailDate() {
		return emailDate;
	}
	public void setEmailDate(String emailDate) {
		this.emailDate = emailDate;
	}
	public String getEmailSender() {
		return emailSender;
	}
	public void setEmailSender(String emailSender) {
		this.emailSender = emailSender;
	}
	public String getEmailReciever() {
		return emailReciever;
	}
	public void setEmailReciever(String emailReciever) {
		this.emailReciever = emailReciever;
	}
	public String getEmailContent() {
		return emailContent;
	}
	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}


}
