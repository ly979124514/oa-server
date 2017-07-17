package com.example.test.demo.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;


//通知实体
@Entity
public class Notice {
       @Id
       @GeneratedValue(strategy = GenerationType.AUTO)
       private int id;
       private String noticePublisher;
       private Date noticePublishtime;
       private String noticeTitle;
       private String noticeContent;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNoticePublisher() {
		return noticePublisher;
	}
	public void setNoticePublisher(String noticePublisher) {
		this.noticePublisher = noticePublisher;
	}
	public Date getNoticePublishtime() {
		return noticePublishtime;
	}
	public void setNoticePublishtime(Date noticePublishtime) {
		this.noticePublishtime = noticePublishtime;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
}
