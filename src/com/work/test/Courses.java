package com.work.test;

import java.util.List;

import com.work.entiy.Course;
import com.work.entiy.Student;

public interface Courses {
 void addCrouses(Course c);
  void deleteCourse(int id);
 void selectcourse(int id);
 List<Student>  selectstudentbyid(int id);
 Course updataCourse(int id);
}
