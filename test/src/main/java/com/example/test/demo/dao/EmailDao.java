package com.example.test.demo.dao;



import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.test.demo.bean.Email;


@Repository
public class EmailDao {
	   @Resource
	   private JdbcTemplate jdbcTemplate;
	   
	   public Email getEmailByTitle(String title){
		   /*
		    * 1、定义sql语句
		    * 2、定义一个rowmapper
		    * 3、执行
		    * 
		    * 
		    * */
//	       String sql = "select * from email where EMAIL_TITLE = :title";
		   String sql = "select * from email where EMAIL_TITLE = "+"'"+title+"'";
		   RowMapper<Email> rowMapper = new BeanPropertyRowMapper<>(Email.class);
//		   SqlParameterSource namedParameter = new MapSqlParameterSource("title",title);
		   System.out.println(sql);
		   Email email = new Email();
		   try
		   {   
	//		   email=jdbcTemplate.queryForObject(sql, new Object[]{parameter_string.toString().getBytes("UTF-8")},rowMapper);
			   email=jdbcTemplate.queryForObject(sql,rowMapper);
			   //.toString().getBytes("UTF-8")
		   }
		   catch(Exception e){
			   System.out.println(e);
			   return null;
		   }
		   return email;
	   }

	   //数据库操作 获取邮件列表
	   public List<Email> getAllEmail(){
		   String sql = "select * from email";		   
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
