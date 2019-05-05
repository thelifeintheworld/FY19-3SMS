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
 * ѧ������
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
		System.out.println("��ѡ��Ҫ���еĲ�����");
		System.out.println("1.����ѧ��  2.�޸�ѧ��  3.ɾ��ѧ��  4.��ѯѧ��  5.��ӡѧ��  6.�γ̹���  7.ϵͳ�˳�");
		System.out.println("**********************************************************");
		System.out.println("��������Ҫ���еĲ��������������֣���");
		int num =scanner.nextInt();
		switch (num) {
		case 1:
			System.out.println("��ѡ���ˡ�����ѧ����");
			
			System.out.println("��������ӵ�ѧ����Ϣ��");
			System.out.println("ѧ��idΪ��");
			String id = scanner.next();
			System.out.println("ѧ������Ϊ��");
			String sname = scanner.next();
			System.out.println("�Ա�Ϊ��");
			String ssex = scanner.next();
			System.out.println("����Ϊ��");
			Integer sage = scanner.nextInt();
			Student student = new Student(id,sname,ssex,sage);
			addS(student);
			System.out.println("��ӳɹ���ϵͳ���Զ������ϲ�Ŀ¼����");
			menu();
			break;
		case 2:
			System.out.println("��ѡ���ˡ��޸�ѧ����");
			System.out.println("������Ҫ�޸ĵ�ѧ��id��");
			int id1 = scanner.nextInt();
		//	updateS(id1);
			System.out.println("�޸ĳɹ���ϵͳ���Զ������ϲ�Ŀ¼����");
			menu();
			break;
		case 3:
			System.out.println("��ѡ���ˡ�ɾ��ѧ����");
			System.out.println("��������Ҫɾ����ѧ��ID��");
			int id2 = scanner.nextInt();
			deletlS(id2);
			System.out.println("ɾ���ɹ���ϵͳ���Զ������ϲ�Ŀ¼����");
			menu();
			break;
		case 4:
			System.out.println("��ѡ���ˡ���ѯѧ����");
			int id11 = scanner.nextInt();
	//		selectS(id11);
			System.out.println("��ѯ�ɹ���ϵͳ���Զ������ϲ�Ŀ¼����");
			menu();
			break;
		case 5:
			System.out.println("��ѡ���ˡ���ӡѧ����");	
			printS();
			System.out.println("��ӡ�ɹ���ϵͳ���Զ������ϲ�Ŀ¼����");
			break;
		case 6:
			CrouseM.menuc();
			break;
		case 7:
			System.out.println("��ѡ���ˡ��˳�ϵͳ��");	
			exitS();
			break;
		default:
			System.out.println("�����������������룡");
			
			menu();
			break;
		}
		
		System.out.println("**********************************************************");
		
	}
	
	
String str1 = "CREATE DATABASE school;";


public Set<Student> deletlS(int id) {
	//�������ݿ�
	System.out.println("������Ҫɾ����ѧ��ID��");
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
			System.out.println("��ѧ���Ѵ��ڣ����������롭��");
		}else {
			set.add(s);
			System.out.println("��ӳɹ�����");
		}
	}
	
	return set;
}
public Set<Student> updateS(String id) {
	for (Student student : set) {
		if (student.getStudentid() == id) {
			System.out.println("������Ҫ�޸ĵ����ԣ�ѧ�š���������");
			String str = scanner.next();
			switch (str) {
			case "ѧ��":
				String id1 = scanner.next();
				student.setStudentid(id1);
				break;
				case "����":
				String string = scanner.next();
				student.setSname(string);
					break;
			default:
				System.out.println("�����������������롭��");
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