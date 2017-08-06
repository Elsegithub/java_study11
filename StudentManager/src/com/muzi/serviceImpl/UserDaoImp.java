package com.muzi.serviceImpl;


import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.muzi.db.MyHibernateSessionFactory;
import com.muzi.entity.Users;
import com.muzi.service.UsersDao;

public class UserDaoImp implements UsersDao {

	@Override
	public boolean userlogin(Users u) {
		//�������
		Transaction tx = null;
		String hqlString="";
		try {
			//��session
			Session session=MyHibernateSessionFactory.getSessionFactory().openSession();
			tx=session.beginTransaction();
			//����hql���
			hqlString="from Users where username=? and password=?";
			org.hibernate.Query query=session.createQuery(hqlString);
			//ͨ��setparamerter���ò���
			query.setParameter(0, u.getUsername());
			query.setParameter(1, u.getPassword());
			List list=query.list();
			//�ύ����
			tx.commit();
//System.out.println("����"+u.getUsername()+","+u.getPassword());
			if(list.size()>0){
				return true;
			}else{
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return false;
		}
		finally{
			if(tx!=null){
				tx=null;
			}
		}
	}
	
}
