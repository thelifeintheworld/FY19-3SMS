package com.work.test;

import java.util.List;

import com.work.entiy.Student;
/**
 * 学生接口
 * @author lenovo
 *
 */
public interface StudentDAO  {
	//增加学生
void addStudent(Student s);
//修改学生
void updateStudent(Student s);
//删除学生
void deleteStudent(String id);
//查询所有学生
List<Student> getAllStudents();
//根据id查询学生信息
Student selectStudentbyid(String id);
//根据id查询学生选课情况
List<String> selectCrousenamebyid(String id);
//课程管理

//系统退出
void exitStudent();
}
