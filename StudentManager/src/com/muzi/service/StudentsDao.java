package com.muzi.service;

import java.util.List;

import com.muzi.entity.Students;

/**
 * 
 * 学生业务逻辑接口
 *
 */
public interface StudentsDao {

	//显示学生资料
	public List<Students> showStudentsList();
	
	//根据编号查询一个学生的资料
	public Students showStudent(String sid);
	
	//添加学生
	public boolean addStudent(Students s);
	
	//删除学生
	public boolean deleteStudent(String sid);
	
	//修改学生资料
	public boolean updateStudent(Students s);
}
