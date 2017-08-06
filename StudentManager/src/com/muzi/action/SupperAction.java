package com.muzi.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 *����action�ĸ���
 *
 */
public class SupperAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware {

	
	protected HttpServletRequest request;//�������
	protected HttpServletResponse response;//��Ӧ����
	protected ServletContext application;//ȫ�ֶ���
	protected HttpSession session;//��Ӧ����
	
	@Override
	public void setServletContext(ServletContext application) {
		// TODO Auto-generated method stub
		this.application=application;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response=response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
		this.session=this.request.getSession();
	}
	
}
