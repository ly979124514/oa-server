package com.example.test.demo.bean;

import java.io.File;
import java.sql.Date;
import java.util.Properties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import oracle.sql.CHAR;
import oracle.sql.CLOB;
import oracle.sql.DATE;


//电子邮件实体
@Entity
public class Email {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private String mail_id;
 	private String send_time;
 	private String to_name;
 	private String from_name;
 	private String copy_to_name;
 	private String secret_to_name;
 	private String from_id;
 	private String to_id;
 	private String secret_to_id;
 	private String copy_to_id;
 	private String subject;
 	private String content;
 	private String send_flag;
 	private String file1FileName;
 	private String file2FileName;
 	private String file3FileName;
 	private String file1FilePath;
 	private String file2FilePath;
 	private String file3FilePath;
 	private String file1Flag;
 	private String file2Flag;
 	private String file3Flag;
 	private File file1;
 	private File file2;
 	private File file3;
 	private String sms_remind;
 	private String receiptFlag;
 	private String flag;//老系统新系统邮件标志 0 新邮件 1 老邮件
	public String getMail_id() {
		return mail_id;
	}
	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}
	public String getSend_time() {
		return send_time;
	}
	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}
	public String getTo_name() {
		return to_name;
	}
	public void setTo_name(String to_name) {
		this.to_name = to_name;
	}
	public String getFrom_name() {
		return from_name;
	}
	public void setFrom_name(String from_name) {
		this.from_name = from_name;
	}
	public String getCopy_to_name() {
		return copy_to_name;
	}
	public void setCopy_to_name(String copy_to_name) {
		this.copy_to_name = copy_to_name;
	}
	public String getSecret_to_name() {
		return secret_to_name;
	}
	public void setSecret_to_name(String secret_to_name) {
		this.secret_to_name = secret_to_name;
	}
	public String getFrom_id() {
		return from_id;
	}
	public void setFrom_id(String from_id) {
		this.from_id = from_id;
	}
	public String getTo_id() {
		return to_id;
	}
	public void setTo_id(String to_id) {
		this.to_id = to_id;
	}
	public String getSecret_to_id() {
		return secret_to_id;
	}
	public void setSecret_to_id(String secret_to_id) {
		this.secret_to_id = secret_to_id;
	}
	public String getCopy_to_id() {
		return copy_to_id;
	}
	public void setCopy_to_id(String copy_to_id) {
		this.copy_to_id = copy_to_id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSend_flag() {
		return send_flag;
	}
	public void setSend_flag(String send_flag) {
		this.send_flag = send_flag;
	}
	public String getFile1FileName() {
		return file1FileName;
	}
	public void setFile1FileName(String file1FileName) {
		this.file1FileName = file1FileName;
	}
	public String getFile2FileName() {
		return file2FileName;
	}
	public void setFile2FileName(String file2FileName) {
		this.file2FileName = file2FileName;
	}
	public String getFile3FileName() {
		return file3FileName;
	}
	public void setFile3FileName(String file3FileName) {
		this.file3FileName = file3FileName;
	}
	public String getFile1FilePath() {
		return file1FilePath;
	}
	public void setFile1FilePath(String file1FilePath) {
		this.file1FilePath = file1FilePath;
	}
	public String getFile2FilePath() {
		return file2FilePath;
	}
	public void setFile2FilePath(String file2FilePath) {
		this.file2FilePath = file2FilePath;
	}
	public String getFile3FilePath() {
		return file3FilePath;
	}
	public void setFile3FilePath(String file3FilePath) {
		this.file3FilePath = file3FilePath;
	}
	public String getFile1Flag() {
		return file1Flag;
	}
	public void setFile1Flag(String file1Flag) {
		this.file1Flag = file1Flag;
	}
	public String getFile2Flag() {
		return file2Flag;
	}
	public void setFile2Flag(String file2Flag) {
		this.file2Flag = file2Flag;
	}
	public String getFile3Flag() {
		return file3Flag;
	}
	public void setFile3Flag(String file3Flag) {
		this.file3Flag = file3Flag;
	}
	public File getFile1() {
		return file1;
	}
	public void setFile1(File file1) {
		this.file1 = file1;
	}
	public File getFile2() {
		return file2;
	}
	public void setFile2(File file2) {
		this.file2 = file2;
	}
	public File getFile3() {
		return file3;
	}
	public void setFile3(File file3) {
		this.file3 = file3;
	}
	public String getSms_remind() {
		return sms_remind;
	}
	public void setSms_remind(String sms_remind) {
		this.sms_remind = sms_remind;
	}
	public String getReceiptFlag() {
		return receiptFlag;
	}
	public void setReceiptFlag(String receiptFlag) {
		this.receiptFlag = receiptFlag;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}

	
}