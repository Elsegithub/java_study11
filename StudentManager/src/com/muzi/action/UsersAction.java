package com.muzi.action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.muzi.entity.Users;
import com.muzi.service.UsersDao;
import com.muzi.serviceImpl.UserDaoImp;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 
 * 用户action
 *
 */
@SuppressWarnings("serial")
public class UsersAction extends SupperAction implements ModelDriven<Users>{
	
	private Users users=new Users();
	
	//登陆的action
	public String login(){
		UsersDao uDao=new UserDaoImp();
		if(uDao.userlogin(users)){
			session.setAttribute("login_name", users.getUsername());
			return "login_success";
		}else {
//			System.out.println("错误"+users.getUsername()+","+users.getPassword());
			return "login_failure";
		}
	}
	
	//退出的action，将用户名设为空
	@SkipValidation
	public String logout(){
		if(session.getAttribute("login_name")!=null){
			session.removeAttribute("login_name");
		}
		return "logout_success";
	}
	
	
	//表单验证
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if ("".equals(users.getUsername().trim())) {
			this.addFieldError("usernameError", "用户名不能为空");
		}
		if(users.getPassword().length()<6){
			this.addFieldError("passwordError", "密码不能小于6位");
		}
	}

	
	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.users;
	}



	
}
