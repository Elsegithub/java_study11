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
		//事务对象
		Transaction tx = null;
		String hqlString="";
		try {
			//打开session
			Session session=MyHibernateSessionFactory.getSessionFactory().openSession();
			tx=session.beginTransaction();
			//创建hql语句
			hqlString="from Users where username=? and password=?";
			org.hibernate.Query query=session.createQuery(hqlString);
			//通过setparamerter设置参数
			query.setParameter(0, u.getUsername());
			query.setParameter(1, u.getPassword());
			List list=query.list();
			//提交事务
			tx.commit();
//System.out.println("错误"+u.getUsername()+","+u.getPassword());
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
