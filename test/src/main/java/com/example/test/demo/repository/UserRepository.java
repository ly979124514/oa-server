package com.example.test.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.test.demo.bean.UserInfo;

public interface UserRepository extends CrudRepository<UserInfo, Integer>{
       public UserInfo findByUserName(String UserName);
}
