package com.muzi.action;

import java.util.List;

import com.muzi.entity.Students;
import com.muzi.service.StudentsDao;
import com.muzi.serviceImpl.StudentsDaoImp;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 *学生action
 */
public class StudentsAction extends SupperAction implements ModelDriven<Students>{
	
	private Students s=new Students();
	
	public String query(){
		StudentsDao sDao=new StudentsDaoImp();
		List<Students> list=sDao.showStudentsList();

		if(list!=null&&list.size()>0){
			session.setAttribute("students_list", list);
		}
		return "query_success";
	}
	
	//删除
	public String delete(){
		StudentsDao sDao=new StudentsDaoImp();
		String sid=request.getParameter("sid");
		sDao.deleteStudent(sid);
		return "delete_success";
	}
	//添加
	public String add(){
		StudentsDao sDao=new StudentsDaoImp();
//System.out.println(s.getSname()+","+s.getGender());
		sDao.addStudent(s);
		return "add_success";
	}

	//通过sid值查找
	public String find(){
		StudentsDao sDao=new StudentsDaoImp();
		session.setAttribute("find", sDao.showStudent(s.getSid()));
		return "find_success";
	}
	
	//显示资料
	public String show(){
		String sidString=request.getParameter("sid");
		StudentsDao sDao=new StudentsDaoImp();
		session.setAttribute("modify_students", sDao.showStudent(sidString));
		return "show_success";
	}
	//修改
	public String modify(){
		StudentsDao sDao=new StudentsDaoImp();
		sDao.updateStudent(s);
		return "modify_success";
	}

	@Override
	public Students getModel() {
		// TODO Auto-generated method stub
		return this.s=s;
	}
}
