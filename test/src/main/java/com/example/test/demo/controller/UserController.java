package com.example.test.demo.controller;

import javax.annotation.Resource;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.demo.bean.UserInfo;
import com.example.test.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    
	@Resource UserService userService;
	@RequestMapping("/saveUser")
	public String save(){
		UserInfo user = new UserInfo();
		user.setId(2323);
		user.setUserAge(35);
		user.setUserName("liyuan");
		user.setUserPasswd("123");
//		userService.save(user);
		return "SAVE USER SUCCESS";
	}
//	@RequestMapping("/RegisterUser")
//	public String registerUser(long Id,int Age,String UserName,String Passwd)
//	{
//		userService.RegisterUser(Id, Age, UserName, Passwd);
//		return "REGISTER SUCCESS!";
//	}
	//@RequestMapping("/findBy")
}

