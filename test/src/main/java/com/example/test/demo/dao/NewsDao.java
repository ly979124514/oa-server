package com.example.test.demo.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import com.example.test.demo.bean.News;

/*
 * “新闻”的DAO接口配置
 * 
 * 
 */

@Repository
public class NewsDao {
       @Resource
       private JdbcTemplate jdbcTemplate;
       //
       public News getNewsByTitle(String title)
       {
    	   //mysql
    	   //String sql = "select * from news where news_title = ?";
    	   //oracle
    	   String sql = "select * from news where news_title = "+"'"+title+"'";
		   RowMapper<News> rowMapper = new BeanPropertyRowMapper<>(News.class);
		   News news = new News();
		   try
		   {   
			//mysql   news=jdbcTemplate.queryForObject(sql, new Object[]{title.toString().getBytes("UTF-8")},rowMapper);
			   //oracle
			   news=jdbcTemplate.queryForObject(sql,rowMapper);

		   }
		   catch(Exception e){
			   return null;
		   }
		   return news;
       }
       
       public List<News> getNews()
       {
    	   String sql = "select * from news";
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
