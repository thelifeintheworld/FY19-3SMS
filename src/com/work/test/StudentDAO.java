package com.work.test;

import java.util.List;

import com.work.entiy.Student;
/**
 * ѧ���ӿ�
 * @author lenovo
 *
 */
public interface StudentDAO  {
	//����ѧ��
void addStudent(Student s);
//�޸�ѧ��
void updateStudent(Student s);
//ɾ��ѧ��
void deleteStudent(String id);
//��ѯ����ѧ��
List<Student> getAllStudents();
//����id��ѯѧ����Ϣ
Student selectStudentbyid(String id);
//����id��ѯѧ��ѡ�����
List<String> selectCrousenamebyid(String id);
//�γ̹���

//ϵͳ�˳�
void exitStudent();
}
