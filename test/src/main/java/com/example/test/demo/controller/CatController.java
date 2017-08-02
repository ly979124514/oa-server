package com.example.test.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.xml.ws.RespectBinding;

import org.aspectj.weaver.ast.Var;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.test.demo.bean.Email;
import com.example.test.demo.bean.News;
import com.example.test.demo.bean.Notice;
import com.example.test.demo.bean.UserInfo;
import com.example.test.demo.config.MailConfig;
//import com.example.test.demo.bean.cat;
import com.example.test.demo.service.MailService;
import com.example.test.demo.service.UserService;
import com.example.test.demo.service.catService;

/*
 * 设置操作的controller
 * 
 * 
 */


@RestController
@RequestMapping("/cat")
public class CatController {
     @Resource
     private catService catService;
     @Resource
     private MailService mailservice;
     @Resource 
     private UserService userService;
     @Resource
     private MailConfig mailConfig = MailConfig.getInstance(); 
     
//     @RequestMapping("/findByCatName")
//     public cat findByName(String catName){
//    	 return catService.findByCatName(catName);
//     }
//     
//     @RequestMapping("/selectByCatName")
//     public cat selectByCatName(String catName,int catAge){
//    	 cat cat = catService.selectByCatName(catName,catAge);
//    	 if(cat == null)
//    	 {
//    		 cat = new cat();
//        	 cat.setCatName("NULL");
//        	 cat.setId(0);
//        	 cat.setCatAge(0);
//        	 return cat;
//    	 }
//    	 else
//    	 {
//    		 return cat;
//    	 }
//     }
     //配置根据邮件题目获取邮件的url
     @RequestMapping("/getEmailByTitle")
     public Email selectByEmail(String title){
    	 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	 System.out.println("Controller getEmailByTitle "+simpleDateFormat.format(new Date()));
    	 Email email = catService.getEmailByTitle(title);
    	 if(email == null){
    		  email = new Email(); 
    		  email.setContent("error!!");
    		  email.setCopy_to_id(null);
    		  email.setCopy_to_name(null);
    		  email.setFile1(null);
    		  email.setFile1FileName(null);
    		  email.setFile1FilePath(null);
    		  email.setFile1Flag(null);
    		  email.setFile2(null);
    		  email.setFile2FileName(null);
    		  email.setFile2FilePath(null);
    		  email.setFile2Flag(null);
    		  email.setFile3(null);
    		  email.setFile3FileName(null);
    		  email.setFile3FileName(null);
    		  email.setFile3Flag(null);
    		  email.setFlag(null);
    		  email.setFrom_id(null);
    		  email.setFrom_name(null);
    		  email.setMail_id(null);
    		  email.setReceiptFlag(null);
    		  email.setSecret_to_id(null);
              email.setSecret_to_name(null);
              email.setSend_flag(null);
              email.setSend_time(null);
              email.setSms_remind(null);
              email.setSubject(null);
              email.setTo_id(null);
              email.setTo_name(null);
    		  return email;
    	 }
    	 else
    	 {
    		 return email;
    	 }
     }
     //配置获取邮件列表的URL
     @RequestMapping("/getAllEmail")
     public List<Email> getAllEmail(){
    	 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	 System.out.println("Controller getAllEmail"+simpleDateFormat.format(new Date()));
    	 List<Email> list = catService.getAllEmail();
    	 return list;
     }
     //配置获取通知列表的url
     @RequestMapping("/getNotice")
     public List<Notice> getNotice(){
    	 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	 System.out.println("Controller getNotice"+simpleDateFormat.format(new Date()));
    	 List<Notice> list = catService.getNotice();
    	 return list;
     }
     //配置根据通知题目获取通知的url （类型）参数：（String）title/通知题目
     @RequestMapping("/getNoticeByTitle")
     public Notice getNoticeBytitle(String title){
    	 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	 System.out.println("Controller getNoticeByTitle"+simpleDateFormat.format(new Date()));
    	 Notice notice = catService.getNoticeByTitle(title);
    	 if (notice == null) {
    		notice = new Notice();
			notice.setId(0);
			notice.setNoticeContent("出错了");
			notice.setNoticePublisher("出错了");
			notice.setNoticePublishtime(null);
            notice.setNoticeTitle("出错了");
	        return notice;		
		}
    	 else
    	 {
    		 return notice;
    	 }
     }
     
     //配置根据新闻题目获取新闻 （类型）参数：（String）title/新闻题目
     @RequestMapping("/getNewsByTitle")
     public News getNewsByTitle(String title){
    	 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	 System.out.println("Controller getNoticeByTitle"+simpleDateFormat.format(new Date()));
    	 News news = catService.getNewsByTitle(title);
    	 if (news == null) {
    		news = new News();
			news.setId(0);
			news.setNewsTitle("出错了！");
			news.setNewsContent("出错了");
			return news;
		}
    	 else
    	 {
    		 return news;
    	 }
     }
     //配置获取新闻列表的URL
     @RequestMapping("/getNews")
     public List<News> getNews(){
    	 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	 System.out.println("Controller getNews"+simpleDateFormat.format(new Date()));
    	 List<News> list = catService.getNews();
    	 return list;
     }
     //配置将邮件信息存入数据库
     @RequestMapping(value="/sendMail",method = RequestMethod.POST)
     public String SendMail(@RequestBody JSONObject jsonObject)
     {
    	   System.out.println("POST:SendMail");
    	   try {
    		   JSONObject MailObject = new JSONObject(jsonObject);    		   
//    		   mailservice.sendMail(MailObject.getString("emailReciever"), MailObject.getString("emailSender"), MailObject.getString("emailTitle"), MailObject.getString("emailContent"), MailObject.getString("emailDate"));
    		   mailservice.sendMail(MailObject);
               return "SUCCESS";
               
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return "FAIL";
		}
    	   
     }
//     @RequestMapping("/Mail")
//     public String tSendMail()
//     {
//    	 mailservice.sendSimpleMail();
//    	 return "Send Success";
//     }
//     @RequestMapping(method = RequestMethod.POST)
//     public void showClient(@RequestBody JSONObject jsonObject)
//     {
//    	 try{
//        	JSONObject testCatJson = new JSONObject(jsonObject);
//        	cat cat = new cat();
//    	    cat.setCatAge(testCatJson.getInteger("catAge"));
//    	    cat.setCatName(testCatJson.getString("catName"));
//    	    cat.setId(testCatJson.getIntValue("Id"));
//    	    catService.save(cat);
//    	 }
//    	 catch (Exception e) {
//			// TODO: handle exception
//    		System.out.println("----------------------------------------------------------------------------------");
//    		System.out.print(e);
//		}
//     }
     
     //根据用户名和密码获取用户信息  （类型）参数：（String）name/用户名，（String）passwd/密码
     @RequestMapping("/selectByUserName")
     public UserInfo selectByUserName(String name,String passwd)
     {
    	 UserInfo user = userService.selectByUserName(name, passwd);
    	 if(user == null)
    	 {
    		 user = new UserInfo();
        	 user.setId(0);
        	 user.setUserAge(0);
        	 user.setUserName("");
        	 user.setUserPasswd("");
        	 return user;
    	 }
    	 else
    	 {
    		 mailConfig.setSetting(user.getUserName(), user.getUserPasswd(), user.getMailAddress());
    		 return user;
    	 }
     }
     
     @RequestMapping("/getAllUser")
     public List<UserInfo> getAllUser()
     {
    	 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	 System.out.println("Controller getNews"+simpleDateFormat.format(new Date()));
    	 List<UserInfo> list = userService.getAllUser();
    	 return list;
     }
}
