package com.example.test.demo.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.test.demo.bean.UserInfo;
import com.example.test.demo.dao.UserDao;
import com.example.test.demo.repository.UserRepository;

@Service
public class UserService {
//	  @Resource
//	  private UserRepository userRepository;
	  @Resource
	  private UserDao userDao;
//	  @Transactional
//	  public void save(User user)
//	  {
//		  userRepository.save(user);
//	  }
	  
	  //根据名字和密码返回User实体， （类型）参数：（String）name/用户名、（String）passwd/密码
      public UserInfo selectByUserName(String name,String passwd)
      {
    	  System.out.println("Server : selectByName");
    	  return userDao.selectByUserName(name, passwd);
      }
      
      public List<UserInfo> getAllUser()
      {
    	  System.out.println("Server : getAllUser");
    	  return userDao.getAllUser();
      }

}
