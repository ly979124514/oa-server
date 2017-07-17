package com.example.test.demo.dao;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.test.demo.bean.Notice;
/*
 * “通知”的DAO接口配置
 * 
 * 
 */

@Repository
public class NoticeDao {
     @Resource
     private JdbcTemplate jdbcTemplate;
     
     public List<Notice> getNotice()
     {
    	 String sql = "select * from notice";
    	 List list;
    	 try {
			list = jdbcTemplate.queryForList(sql);
		} catch (Exception e) {
			System.out.println(e);
			return null;
			// TODO: handle exception
		}
    	return list;
     }
     
     public Notice getNoticeByTitle(String title)
     {
    	 String sql = "select * from notice where notice_title = "+"'"+title+"'";
    	 RowMapper<Notice> rowMapper = new BeanPropertyRowMapper<>(Notice.class);
    	 Notice notice = new Notice();
    	 try {
		//	notice = jdbcTemplate.queryForObject(sql, new Object[]{title.toString().getBytes("UTF-8")},rowMapper);
			notice = jdbcTemplate.queryForObject(sql,rowMapper);

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
    	return notice;
    	 
     }
}
