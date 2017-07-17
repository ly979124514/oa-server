package com.example.test.demo.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.test.demo.bean.UserInfo;

import ch.qos.logback.core.net.SyslogOutputStream;


/*
 * 
 * 用户的DAO接口配置
 * 
 * 
 */

@Repository
public class UserDao {
   @Resource
   private JdbcTemplate jdbcTemplate;
   public UserInfo selectByUserName(String name,String passwd){
	   //mysql
	  // String sql = "select * from user_info where user_name= 'liyuan1' and user_passwd='abc1'";
	   //oracle
	   String sql = "select * from user_info where user_name= "+"'"+name+"'"+ "and user_passwd="+"'"+passwd+"'";
	   RowMapper<UserInfo> rowMapper = new BeanPropertyRowMapper<>(UserInfo.class);
	   UserInfo user;
	   try
	   {
		   System.out.println("Dao : "+sql+name+passwd);
//mysql		   user=jdbcTemplate.queryForObject(sql, new Object[]{name.toString().getBytes("UTF-8"),passwd.toString().getBytes("UTF-8")},rowMapper);
		   //oracle
		   user=jdbcTemplate.queryForObject(sql,rowMapper);

	   }
	   catch(Exception e){
		   System.out.println(e);
		   return null;
	   }
	   return user;
   }
   public List<UserInfo> getAllUser() {
	   String sql = "select * from user_info";
	   List list;
	   try {
		System.out.println("DAO:getAllUser");
		list = jdbcTemplate.queryForList(sql);
	} catch (Exception e) {
		// TODO: handle exception
		return null;
}
      return list;
   }
}
