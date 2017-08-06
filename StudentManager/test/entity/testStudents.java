package entity;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class testStudents {

/*	@Test
	//创建结构表
	public void testSchemaExport(){
		//创建配置对象
		Configuration configuration=new Configuration().configure();
		//创建服务对象
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		//创建sessionFactory
		SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		//创建session
		Session session=sessionFactory.openSession();
//		//开启事物
//		org.hibernate.Transaction transaction=session.beginTransaction();
		//创建SchemaExport对象
		SchemaExport export=new SchemaExport(configuration);
		
		export.create(true, true);
		
	}*/
	
	
}
