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
		System.out.println("��ѡ���ˡ��γ̹���");		
		System.out.println("***************************************************************");
		System.out.println("*1.���ӿγ�  2.ɾ���γ� 3.�޸Ŀγ� *");
		System.out.println("***************************************************************");
		System.out.println("��ѡ����Ҫ���еĲ������������Ӧ�����֣���");
		int numm = scanner.nextInt();
		switch (numm) {
		case 1:
			System.out.println("��������Ҫ��ӵĿγ���Ϣ��");
			course.setC_id(scanner.nextInt());
			course.setCname(scanner.next());	
			addC(course);
			System.out.println("��ӳɹ���ϵͳ���Զ������ϲ�Ŀ¼����");
			menuc();
			break;
			
		case 2:
			System.out.println("������Ҫɾ���Ŀγ�id��");
			course.setC_id(scanner.nextInt());
			delC(course.getC_id());
			System.out.println("ɾ���ɹ���ϵͳ���Զ������ϲ�Ŀ¼����");
			menuc();
			break;
		case 3:
			System.out.println("������Ҫ�޸ĵĿγ�id��");
			updateC(course);
			System.out.println("�޸ĳɹ���ϵͳ���Զ������ϲ�Ŀ¼����");
			menuc();
				break;
		default:
			System.out.println("�����������������롭��");
			menuc();
			break;
		}
	}
	public static Set<Course> addC(Course c) {
		for (Course course : crouses) {
			if (c.getC_id() == course.getC_id()) {
				System.out.println("�ÿγ��Ѵ��ڣ����������롭��");
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
				System.out.println("ɾ���ɹ���");
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
		System.out.println("�޸ĳɹ���");
		return crouses;
	}
	
}
