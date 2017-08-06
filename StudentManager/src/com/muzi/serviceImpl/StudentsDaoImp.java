package com.muzi.serviceImpl;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.muzi.db.MyHibernateSessionFactory;
import com.muzi.entity.Students;
import com.muzi.service.StudentsDao;

/**
 * 
 *学生业务逻辑层
 */
public class StudentsDaoImp implements StudentsDao{

	@Override
	public List<Students> showStudentsList() {
		// TODO Auto-generated method stub
		Transaction tx=null;
		List<Students> list=null;
		String hql="";
		
		try {
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql="from Students";
			org.hibernate.Query query=session.createQuery(hql);
			list=query.list();
			tx.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return list;
		}finally{
			if(tx!=null){
				tx=null;
			}
		}
	}

	@Override
	public Students showStudent(String sid) {
		Transaction tx = null;
		try {
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			Students s=(Students) session.get(Students.class, sid);
			tx.commit();
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return null;
		
		}finally{
			if (tx!=null) {
				tx=null;
			}
		}
	}

	@Override
	public boolean addStudent(Students s) {
		// TODO Auto-generated method stub
		s.setSid(getNewId());
		Transaction tx = null;
		try {
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			session.save(s);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return false;
		
		}finally{
			if (tx!=null) {
				tx=null;
			}
		}
		
	}

	@Override
	public boolean deleteStudent(String sid) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			Students s=(Students) session.get(Students.class, sid);
			session.delete(s);	
			tx.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.commit();
			return false;
		}finally{
			if(tx!=null){
				tx=null;
			}
		}

		
	}

	@Override
	public boolean updateStudent(Students s) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		try {
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			Students students=(Students) session.get(Students.class, s.getSid());
			students.setSname(s.getSname());
			students.setAddress(s.getAddress());
			students.setBirthday(s.getBirthday());
			students.setGender(s.getGender());
			session.update(students);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return false;
		}finally{
			if(tx!=null){
				tx=null;
			}
		}
	}
	
	
	//获取新的id
	private String getNewId(){
		Transaction tx=null;
		String hqlString="";
		try {
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hqlString="select max(id) from Students";
			Query query=session.createQuery(hqlString);
			String sid=(String) query.uniqueResult();
			if(sid==null||"".equals(sid)){
				sid="001";
			}else {
				int a=Integer.parseInt(sid);
				a++;
				sid="00"+String.valueOf(a);
			}
			tx.commit();
			return sid;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return null;
		}finally{
			if(tx!=null){
				tx=null;
			}
		}
	}
}
