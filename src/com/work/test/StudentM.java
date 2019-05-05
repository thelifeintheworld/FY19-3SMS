package com.work.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import com.work.entiy.Student;
/**
 * 学生管理
 * @author lenovo
 *
 */

public class StudentM {
	private static  Student student = null;
	Set<Student> set = new HashSet<Student>();
	static Scanner scanner = new Scanner(System.in); 
	private static Properties properties;
	static {
		properties = new Properties();
		try {
			properties.load(StudentM.class.getResourceAsStream("/Sqldress"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		StudentM studentM = new StudentM();
		studentM.menu();
	}
		public void menu(){
		System.out.println("**********************************************************");
		System.out.println("请选择要进行的操作：");
		System.out.println("1.增加学生  2.修改学生  3.删除学生  4.查询学生  5.打印学生  6.课程管理  7.系统退出");
		System.out.println("**********************************************************");
		System.out.println("请输入您要进行的操作（请输入数字）：");
		int num =scanner.nextInt();
		switch (num) {
		case 1:
			System.out.println("您选择了“增加学生”");
			
			System.out.println("请输入添加的学生信息：");
			System.out.println("学生id为：");
			String id = scanner.next();
			System.out.println("学生姓名为：");
			String sname = scanner.next();
			System.out.println("性别为：");
			String ssex = scanner.next();
			System.out.println("年龄为：");
			Integer sage = scanner.nextInt();
			Student student = new Student(id,sname,ssex,sage);
			addS(student);
			System.out.println("添加成功，系统将自动返回上层目录……");
			menu();
			break;
		case 2:
			System.out.println("您选择了“修改学生”");
			System.out.println("请输入要修改的学生id：");
			int id1 = scanner.nextInt();
		//	updateS(id1);
			System.out.println("修改成功，系统将自动返回上层目录……");
			menu();
			break;
		case 3:
			System.out.println("您选择了“删除学生”");
			System.out.println("请输入您要删除的学生ID：");
			int id2 = scanner.nextInt();
			deletlS(id2);
			System.out.println("删除成功，系统将自动返回上层目录……");
			menu();
			break;
		case 4:
			System.out.println("您选择了“查询学生”");
			int id11 = scanner.nextInt();
	//		selectS(id11);
			System.out.println("查询成功，系统将自动返回上层目录……");
			menu();
			break;
		case 5:
			System.out.println("您选择了“打印学生”");	
			printS();
			System.out.println("打印成功，系统将自动返回上层目录……");
			break;
		case 6:
			CrouseM.menuc();
			break;
		case 7:
			System.out.println("您选择了“退出系统”");	
			exitS();
			break;
		default:
			System.out.println("输入有误，请重新输入！");
			
			menu();
			break;
		}
		
		System.out.println("**********************************************************");
		
	}
	
	
String str1 = "CREATE DATABASE school;";


public Set<Student> deletlS(int id) {
	//连接数据库
	System.out.println("请输入要删除的学生ID：");
	String id1 = scanner.next();
	for (Student student : set) {
		if (student.getStudentid() == id1) {
			set.remove(student);
		}
	}
	return set;	
	
}
public Set<Student> addS(Student s) {
	String string2="INSERT INTO student VALUES(?,?,?,?)";
	try(	Connection connection =	DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("pwd"));
			PreparedStatement preparedStatement =connection.prepareStatement(string2);
			) {
		preparedStatement.setString(1, s.getStudentid());
		preparedStatement.setString(2, s.getSname());
} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	for (Student student : set) {
		if (student.getStudentid() == s.getStudentid()) {
			System.out.println("该学生已存在，请重新输入……");
		}else {
			set.add(s);
			System.out.println("添加成功……");
		}
	}
	
	return set;
}
public Set<Student> updateS(String id) {
	for (Student student : set) {
		if (student.getStudentid() == id) {
			System.out.println("请输入要修改的属性（学号、姓名）：");
			String str = scanner.next();
			switch (str) {
			case "学号":
				String id1 = scanner.next();
				student.setStudentid(id1);
				break;
				case "姓名":
				String string = scanner.next();
				student.setSname(string);
					break;
			default:
				System.out.println("输入有误，请重新输入……");
				int id2 = scanner.nextInt();
	//			updateS(id2);
				break;
			}
		}
	}
	return set;
}
public Student selectS(String id) {
	for (Student student : set) {
		if(student.getStudentid() == id) {
			System.out.println(student);
		}
	}
	return student;
}
public void printS() {
	for (Student student : set) {
		System.out.println(student);
	}
}

public void exitS() {
	System.exit(0);
}
}