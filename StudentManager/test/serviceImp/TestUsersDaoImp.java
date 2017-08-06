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
	        //1.创建一个SessionFactory对象
	        SessionFactory sessionFactory = null;
	        
	        //1).创建configuration对象：对应hibernate的基本配置信息和对象关系映射信息
	        Configuration configuration = new Configuration().configure();
	        
	        //4.0之前这样创建
	        //sessionFactory = configuration.buildSessionFactory();
	        
	        //2).创建一个ServiceRegistry对象：hibernate4.x新添加的对象
	        //hibernate的任何配置和服务都需要在该对象中注册后才能有效
	        ServiceRegistry serviceRegistry =
	                new ServiceRegistryBuilder().applySettings(configuration.getProperties())
	                .buildServiceRegistry();
	        
	        //3).
	        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	                
	       //2.创建一个Session对象
	        Session session = sessionFactory.openSession();    
	        
	       //3.开启事务
	        Transaction transaction = session.beginTransaction();
	        
	       //4.执行保存操作
	        Students  students1=new Students("001", "张三1", "男",new Date(), "陕西1");
	        Students  students2=new Students("002", "张三2", "男",new Date(), "陕西2");
	        Students  students3=new Students("003", "张三3", "男",new Date(), "陕西3");
	        session.save(students1);
	        session.save(students2);
	        session.save(students3);
	    	        
	       //5.提交事务
	        transaction.commit();
	        
	      //6.关闭Session
	        session.close();
	        
	      //7.关闭SessionFactory对象
	        sessionFactory.close();
	    }

}
