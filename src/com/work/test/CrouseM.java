package com.work.test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import com.work.entiy.Course;

public class CrouseM {
	static Set<Course> crouses = new HashSet<>();
	static Course course = new Course();
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
		
		CrouseM.menuc();
	}
	public static void menuc()
	{
		System.out.println("您选择了“课程管理”");		
		System.out.println("***************************************************************");
		System.out.println("*1.增加课程  2.删除课程 3.修改课程 *");
		System.out.println("***************************************************************");
		System.out.println("请选择您要进行的操作（请输入对应的数字）：");
		int numm = scanner.nextInt();
		switch (numm) {
		case 1:
			System.out.println("请输入您要添加的课程信息：");
			course.setC_id(scanner.nextInt());
			course.setCname(scanner.next());	
			addC(course);
			System.out.println("添加成功，系统将自动返回上层目录……");
			menuc();
			break;
			
		case 2:
			System.out.println("请输入要删除的课程id：");
			course.setC_id(scanner.nextInt());
			delC(course.getC_id());
			System.out.println("删除成功，系统将自动返回上层目录……");
			menuc();
			break;
		case 3:
			System.out.println("请输入要修改的课程id：");
			updateC(course);
			System.out.println("修改成功，系统将自动返回上层目录……");
			menuc();
				break;
		default:
			System.out.println("输入有误，请重新输入……");
			menuc();
			break;
		}
	}
	public static Set<Course> addC(Course c) {
		for (Course course : crouses) {
			if (c.getC_id() == course.getC_id()) {
				System.out.println("该课程已存在，请重新输入……");
			}else {
				crouses.add(course);
			}
		}
		return crouses;
	}
	public static Set<Course> delC(int c_id) {
		for (Course course : crouses) {
			if (course.getC_id() == c_id) {
				crouses.remove(course);
				System.out.println("删除成功！");
			}
		}
		return crouses;
	}
	public static Set<Course> updateC(Course c) {
		
		for (Course course : crouses) {
			if (c.getC_id() == course.getC_id()) {
				course = c;
			}
		}
		System.out.println("修改成功！");
		return crouses;
	}
	
}
