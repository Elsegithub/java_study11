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
	//�����ṹ��
	public void testSchemaExport(){
		//�������ö���
		Configuration configuration=new Configuration().configure();
		//�����������
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		//����sessionFactory
		SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		//����session
		Session session=sessionFactory.openSession();
//		//��������
//		org.hibernate.Transaction transaction=session.beginTransaction();
		//����SchemaExport����
		SchemaExport export=new SchemaExport(configuration);
		
		export.create(true, true);
		
	}*/
	
	
}
