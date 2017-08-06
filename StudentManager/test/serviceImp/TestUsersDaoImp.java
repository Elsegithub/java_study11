package serviceImp;



import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Assert;
import org.junit.Test;

import com.muzi.entity.Students;
import com.muzi.entity.Users;
import com.muzi.service.UsersDao;
import com.muzi.serviceImpl.UserDaoImp;

public class TestUsersDaoImp {

	@Test
	public void testUserlogin(){
		Users users=new Users(1,"muzi","123456");
		UsersDao userDaoImp=new UserDaoImp();
		Assert.assertEquals(true, userDaoImp.userlogin(users));
	}
	
	
	 @Test
	    public void test() {
	        //1.����һ��SessionFactory����
	        SessionFactory sessionFactory = null;
	        
	        //1).����configuration���󣺶�Ӧhibernate�Ļ���������Ϣ�Ͷ����ϵӳ����Ϣ
	        Configuration configuration = new Configuration().configure();
	        
	        //4.0֮ǰ��������
	        //sessionFactory = configuration.buildSessionFactory();
	        
	        //2).����һ��ServiceRegistry����hibernate4.x����ӵĶ���
	        //hibernate���κ����úͷ�����Ҫ�ڸö�����ע��������Ч
	        ServiceRegistry serviceRegistry =
	                new ServiceRegistryBuilder().applySettings(configuration.getProperties())
	                .buildServiceRegistry();
	        
	        //3).
	        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	                
	       //2.����һ��Session����
	        Session session = sessionFactory.openSession();    
	        
	       //3.��������
	        Transaction transaction = session.beginTransaction();
	        
	       //4.ִ�б������
	        Students  students1=new Students("001", "����1", "��",new Date(), "����1");
	        Students  students2=new Students("002", "����2", "��",new Date(), "����2");
	        Students  students3=new Students("003", "����3", "��",new Date(), "����3");
	        session.save(students1);
	        session.save(students2);
	        session.save(students3);
	    	        
	       //5.�ύ����
	        transaction.commit();
	        
	      //6.�ر�Session
	        session.close();
	        
	      //7.�ر�SessionFactory����
	        sessionFactory.close();
	    }

}
