package com.work.test;

import java.awt.List;
import java.sql.Connection;

import com.work.entiy.Student;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection =Studentutil.getConnection();
		StudentDAO sDAO =new StudentDaoTemp(connection);
		//添加测试
//		Student s =new Student("stu1203","小王","男",22);
//		sDAO.addStudent(s);
//		System.out.println("添加成功……");
		//查询测试
//		System.out.println(sDAO.getAllStudents());
		//id查询测试
//		Student student = sDAO.selectStudentbyid("stu1202");
//		student.toString();
//		System.out.println("查询成功……");
		//删除测试
	//	sDAO.deleteStudent("stu1202");
	//	System.out.println("删除成功……");
		java.util.List<String> list=sDAO.selectCrousenamebyid("stu1108");
	System.out.println(list);
	}

}
