package com.example.test.demo.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.test.demo.bean.Email;
import com.example.test.demo.bean.News;
import com.example.test.demo.bean.Notice;

import com.example.test.demo.dao.EmailDao;
import com.example.test.demo.dao.NewsDao;
import com.example.test.demo.dao.NoticeDao;


@Service
public class catService {

  //  private CatDao catDao;
    @Resource
    private EmailDao emailDao;
    @Resource
    private NoticeDao noticeDao;
    @Resource
    private NewsDao newsDao;
    
    //根据名称获取邮件
    public Email getEmailByTitle(String title){
    	System.out.println("Server: getEmailByTitle");
    	return emailDao.getEmailByTitle(title);
    }
    //获取邮件列表
    public List<Email> getAllEmail()
    {
    	System.out.println("getAllEmail!!");
    	return emailDao.getAllEmail();
    }
    
    //获取公告列表
    public List<Notice> getNotice()
    {
    	System.out.println("getNotice");
    	return noticeDao.getNotice();
    }
    
    //根据名称获取公告
    public Notice getNoticeByTitle(String title)
    {
    	System.out.println("getNoticeByTitle");
    	return noticeDao.getNoticeByTitle(title);
    }
    //根据名称获取新闻
    public News getNewsByTitle(String title)
    {
    	System.out.println("getNEWSbytitle");
    	return newsDao.getNewsByTitle(title);
    }
    //获取新闻列表
    public List<News> getNews()
    {
    	System.out.println("getNEWS");
    	return newsDao.getNews();
    }
}

