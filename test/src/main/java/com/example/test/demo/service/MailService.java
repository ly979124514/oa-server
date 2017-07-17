package com.example.test.demo.service;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.boot.model.source.internal.hbm.Helper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.alibaba.fastjson.JSONObject;
import com.example.test.demo.bean.Email;
import com.example.test.demo.config.MailConfig;
import com.example.test.demo.dao.EmailDao;

/*
 * 邮件模块的service配置
 * 
 */


@Service
//@ComponentScan({"com.example.test.demo.config.MailConfig"})
public class MailService {
	   @Resource
	   private JavaMailSender mailSender;
	   @Resource
	   private JdbcTemplate jdbcTemplate;
	   @Resource
	   private MailConfig mailConfig = MailConfig.getInstance(); 
	   @Transactional
	   //向数据库插入新邮件数据 参数：emailTitle/邮件题目、emailDate/邮件日期、emailContent/邮件内容、emailContent/邮件接收者、emailSender/邮件发送者
	   public void NewEmail(String emailTitle,String emailDate,String emailContent,String emailReciever,String emailSender){
		   String sql = "insert into email(email_title,email_date,email_content,email_reciever,email_sender) values(?,?,?,?,?)";
		   System.out.println("Operating INSERT");
		   try {
			   System.out.println("---------------------------");
			   jdbcTemplate.update(sql,new Object[]{emailTitle.toString().getBytes("UTF-8"),emailDate.toString().getBytes("UTF-8"),emailContent.toString().getBytes("UTF-8"),emailReciever.toString().getBytes("UTF-8"),emailSender.toString().getBytes("UTF-8")});
		   } catch (Exception e) {
			// TODO: handle exception
			   System.out.println("error is "+e);
		}
	   }
//       public void sendSimpleMail()
//       {   
//    	   SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//    	   System.out.println("SetFrom");
//    	   simpleMailMessage.setFrom("ly979124514@163.com");    	   
//    	   System.out.println("SetTo");
//    	   simpleMailMessage.setTo("979124514@qq.com");
//    	   simpleMailMessage.setSubject("主题：简单邮件");
//    	   simpleMailMessage.setText("TEST CONTETN123123123123");
//    	   
//    	   mailSender.send(simpleMailMessage);
//       }
       //发送邮件 参数：to/目的地址、from/源地址、subject/题目、content/内容、date/日期
       //public void sendMail(String to, String from, String subject, String content,String date)
       public void sendMail(JSONObject MailObject)
       {
    	  
//    	   SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//    	   
//    	  // EmailDao emailDao = new EmailDao();
//    	   simpleMailMessage.setFrom(from);
//    	   simpleMailMessage.setTo(to);
//    	   simpleMailMessage.setSubject(subject);
//    	   simpleMailMessage.setText(content);
    	//   mailConfig.setSetting("ly979124514", "ly200801014");
    	   
    	   Email mEmail = new Email();
    	   mEmail.setEmailReciever(MailObject.getString("emailReciever"));
    	   mEmail.setEmailTitle( MailObject.getString("emailTitle"));
    	   mEmail.setEmailContent(MailObject.getString("emailContent"));
    	   mEmail.setEmailDate(MailObject.getString("emailDate"));
    	   JavaMailSender javaMailSender = mailConfig.getJavaMailSender();
    	   MimeMessage mailMessage = javaMailSender.createMimeMessage();
    	   sendToOne(mailMessage, mEmail,javaMailSender,mailConfig);
    	   	   
    	  // this.NewEmail(subject, date, content, from, to);
    	   
       }
       private void sendToOne(MimeMessage mailMessage,Email email,JavaMailSender javaMailSender,MailConfig mailConfig)
       {
    	   MimeMessageHelper helper = null;
    	   try {
    		  helper = new MimeMessageHelper(mailMessage,true);
			  mailMessage.setContent(email.getEmailContent(), "text/html");
			  helper.setSubject(email.getEmailTitle());
			//  helper.setFrom(email.getEmailSender());
			  helper.setFrom(mailConfig.getMailAddress());

		} catch (MessagingException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
    	
    	try {
    		assert helper != null;
    		helper.setTo(email.getEmailReciever());
    		
    	} catch (MessagingException e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    	javaMailSender.send(mailMessage);
       }
       
}
