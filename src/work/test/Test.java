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
		//添加测试
//		Student s =new Student("stu1203","小王","男",22);
//		sDAO.addStudent(s);
//		System.out.println("添加成功……");
		//查询测试
//		System.out.println(sDAO.getAllStudents());
		//id查询测试
//		Student student = sDAO.selectStudentbyid("4");
//		System.out.println(student.toString());
//		System.out.println("查询成功……");
		//删除测试
//		sDAO.deleteStudent("1");
//		System.out.println("删除成功……");
	//查询课程名
		//	List<String> list=sDAO.selectCrousenamebyid("stu1108");
	//	System.out.println(list);
		//修改测试
//		Student s = new Student("4","小敏","男",8);
//		sDAO.updateStudent(s);
//		System.out.println(sDAO.getAllStudents());
	//修改成功
	CrouseM crouseM =new CrouseM(connection);
//	Course c = new  Course(10,"理科生的文学修养");
//	crouseM.addCrouses(c);
//	System.out.println("添加成功……");
//	crouseM.deleteCourse(11);
//	crouseM.selectcourse(11);
//	List<Student> list = crouseM.selectstudentbyid(2);
	 List< Course> list =crouseM.selectallCourses();
	System.err.println(list);
	}

}
