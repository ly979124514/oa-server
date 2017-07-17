package com.example.test.demo.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.test.demo.bean.Email;
import com.example.test.demo.bean.Email_Send;

@Repository
public class Email_SendDao {
	   @Resource
	   private JdbcTemplate jdbcTemplate;
	   
	   public Email_Send getEmailByTitle(String title){
		   /*
		    * 1、定义sql语句
		    * 2、定义一个rowmapper
		    * 3、执行
		    * 
		    * 
		    * */
//	       String sql = "select * from email where EMAIL_TITLE = :title";
		   String sql = "select * from email_sender where EMAIL_TITLE = "+"'"+title+"'";
		   RowMapper<Email_Send> rowMapper = new BeanPropertyRowMapper<>(Email_Send.class);
//		   SqlParameterSource namedParameter = new MapSqlParameterSource("title",title);
		   System.out.println(sql);
		   Email_Send email_Send = new Email_Send();
		   try
		   {   
	//		   email=jdbcTemplate.queryForObject(sql, new Object[]{parameter_string.toString().getBytes("UTF-8")},rowMapper);
			   email_Send=jdbcTemplate.queryForObject(sql,rowMapper);
			   //.toString().getBytes("UTF-8")
		   }
		   catch(Exception e){
			   System.out.println(e);
			   return null;
		   }
		   return email_Send;
	   }

	   //数据库操作 获取邮件列表
	   public List<Email> getAllEmail(){
		   String sql = "select * from email_Send";		   
		   List list;
		   try {
			   list = jdbcTemplate.queryForList(sql);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
		return list;   
	}
}
