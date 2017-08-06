package com.muzi.service;

import java.util.List;

import com.muzi.entity.Students;

/**
 * 
 * ѧ��ҵ���߼��ӿ�
 *
 */
public interface StudentsDao {

	//��ʾѧ������
	public List<Students> showStudentsList();
	
	//���ݱ�Ų�ѯһ��ѧ��������
	public Students showStudent(String sid);
	
	//���ѧ��
	public boolean addStudent(Students s);
	
	//ɾ��ѧ��
	public boolean deleteStudent(String sid);
	
	//�޸�ѧ������
	public boolean updateStudent(Students s);
}
