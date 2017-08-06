package com.muzi.service;

import com.muzi.entity.Users;

//用户业务逻辑接口
public interface UsersDao {
	//用户登录方法
	public boolean userlogin(Users u);
	
}
