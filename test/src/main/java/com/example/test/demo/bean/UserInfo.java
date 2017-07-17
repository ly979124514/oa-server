package com.example.test.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//用户实体
@Entity
public class UserInfo {
      @Id
      @GeneratedValue(strategy=GenerationType.AUTO)
      private long Id;
      private String userName;
      private int userAge;
      private String userPasswd;
      private String userId;
      private int signed;
      private String userDept;
      private String mailAddress;
      public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String maillAddress) {
		this.mailAddress = maillAddress;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserPasswd() {
		return userPasswd;
	}
	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getSign() {
		return signed;
	}
	public void setSign(int signed) {
		this.signed = signed;
	}
	public String getUserDept() {
		return userDept;
	}
	public void setUserDept(String userDept) {
		this.userDept = userDept;
	}      
}
