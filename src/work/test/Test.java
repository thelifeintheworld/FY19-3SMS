package com.work.test;

import java.sql.Connection;
import java.util.List;

import com.work.entiy.Course;
import com.work.entiy.Student;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection =Studentutil.getConnection();
//		StudentDAO sDAO =new StudentDaoTemp(connection);
		//��Ӳ���
//		Student s =new Student("stu1203","С��","��",22);
//		sDAO.addStudent(s);
//		System.out.println("��ӳɹ�����");
		//��ѯ����
//		System.out.println(sDAO.getAllStudents());
		//id��ѯ����
//		Student student = sDAO.selectStudentbyid("4");
//		System.out.println(student.toString());
//		System.out.println("��ѯ�ɹ�����");
		//ɾ������
//		sDAO.deleteStudent("1");
//		System.out.println("ɾ���ɹ�����");
	//��ѯ�γ���
		//	List<String> list=sDAO.selectCrousenamebyid("stu1108");
	//	System.out.println(list);
		//�޸Ĳ���
//		Student s = new Student("4","С��","��",8);
//		sDAO.updateStudent(s);
//		System.out.println(sDAO.getAllStudents());
	//�޸ĳɹ�
	CrouseM crouseM =new CrouseM(connection);
//	Course c = new  Course(10,"���������ѧ����");
//	crouseM.addCrouses(c);
//	System.out.println("��ӳɹ�����");
//	crouseM.deleteCourse(11);
//	crouseM.selectcourse(11);
//	List<Student> list = crouseM.selectstudentbyid(2);
	 List< Course> list =crouseM.selectallCourses();
	System.err.println(list);
	}

}
