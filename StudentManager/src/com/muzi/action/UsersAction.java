package com.muzi.action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.muzi.entity.Users;
import com.muzi.service.UsersDao;
import com.muzi.serviceImpl.UserDaoImp;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 
 * �û�action
 *
 */
@SuppressWarnings("serial")
public class UsersAction extends SupperAction implements ModelDriven<Users>{
	
	private Users users=new Users();
	
	//��½��action
	public String login(){
		UsersDao uDao=new UserDaoImp();
		if(uDao.userlogin(users)){
			session.setAttribute("login_name", users.getUsername());
			return "login_success";
		}else {
//			System.out.println("����"+users.getUsername()+","+users.getPassword());
			return "login_failure";
		}
	}
	
	//�˳���action�����û�����Ϊ��
	@SkipValidation
	public String logout(){
		if(session.getAttribute("login_name")!=null){
			session.removeAttribute("login_name");
		}
		return "logout_success";
	}
	
	
	//����֤
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if ("".equals(users.getUsername().trim())) {
			this.addFieldError("usernameError", "�û�������Ϊ��");
		}
		if(users.getPassword().length()<6){
			this.addFieldError("passwordError", "���벻��С��6λ");
		}
	}

	
	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.users;
	}



	
}
