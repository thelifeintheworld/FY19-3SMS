package com.work.test;

import java.awt.List;
import java.sql.Connection;

import com.work.entiy.Student;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection =Studentutil.getConnection();
		StudentDAO sDAO =new StudentDaoTemp(connection);
		//��Ӳ���
//		Student s =new Student("stu1203","С��","��",22);
//		sDAO.addStudent(s);
//		System.out.println("��ӳɹ�����");
		//��ѯ����
//		System.out.println(sDAO.getAllStudents());
		//id��ѯ����
//		Student student = sDAO.selectStudentbyid("stu1202");
//		student.toString();
//		System.out.println("��ѯ�ɹ�����");
		//ɾ������
	//	sDAO.deleteStudent("stu1202");
	//	System.out.println("ɾ���ɹ�����");
		java.util.List<String> list=sDAO.selectCrousenamebyid("stu1108");
	System.out.println(list);
	}

}
