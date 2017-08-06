package serviceImp;

import java.util.List;

import org.junit.Test;

import com.muzi.entity.Students;
import com.muzi.service.StudentsDao;
import com.muzi.serviceImpl.StudentsDaoImp;

/**
 * 
 *≤‚ ‘students“µŒÒ¬ﬂº≠≤„
 */
public class TestStudentDaoImp {

	
	@Test
	public void TestShow(){
		StudentsDao sDao=new StudentsDaoImp();
		List<Students> list=sDao.showStudentsList();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	
	
	@Test
	public void testNewID(){
		StudentsDaoImp sDao=new StudentsDaoImp();
		//String sid=sDao.getNewId();
		//System.out.println(sid);
	}
}
