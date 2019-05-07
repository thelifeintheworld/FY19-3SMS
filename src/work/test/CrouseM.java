package com.work.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.work.entiy.Course;
import com.work.entiy.Student;

public class CrouseM implements Courses {
	static StudentDaoTemp studentDaoTemp ;
	static Course course = new Course();
	static Scanner scanner = new Scanner(System.in);
	private Connection connection = Studentutil.getConnection();
	public CrouseM(Connection connection) {
	}
	public  void menuc()
	{
		System.out.println("您选择了“课程管理”");		
		System.out.println("***************************************************************");
		System.out.println("*1.增加课程  2.删除课程 3.修改课程 4.查询选择对应课程的学生信息 5.查询所有的课程 6.返回上层目录 *");
		System.out.println("***************************************************************");
		System.out.println("请选择您要进行的操作（请输入对应的数字）：");
		int numm = scanner.nextInt();
		switch (numm) {
		case 1:
			System.out.println("请输入您要添加的课程信息：");
			System.out.println("请输入课程号（数字）：");
			int C_id = scanner.nextInt();
			System.out.println("请输入课程名：");
			String Cname = scanner.next();	
			Course crouse = new Course(C_id,Cname);
			addCrouses(crouse);
			System.out.println("添加成功，系统将自动返回上层目录……");
			menuc();
			break;
			
		case 2:
			System.out.println("请输入要删除的课程id：");
			int C_id1 = scanner.nextInt();
			deleteCourse(C_id1);
			System.out.println("删除成功，系统将自动返回上层目录……");
			menuc();
			break;
		case 3:
			System.out.println("请输入要修改的课程id：");
			int cid = scanner.nextInt();
			updataCourse(cid);
			System.out.println("修改成功，系统将自动返回上层目录……");
			menuc();
				break;
		case 4:
			System.out.println("请输入要查询的课程id：");
			int c_id = scanner.nextInt();
			System.out.println(selectstudentbyid(c_id));
			System.out.println("查询成功，系统将自动返回上层目录……");
			menuc();
				break;
		case 5:
			System.out.println("您选择了查询所有课程信息");
			System.out.println(selectallCourses());
			System.out.println("查询成功，系统将自动返回上层目录……");
			menuc();
			break;
		case 6:
			studentDaoTemp.menu();
			break;
		default:
			System.out.println("输入有误，请重新输入……");
			menuc();
			break;
		}
	}

	@Override
	public  void addCrouses(Course c) {
		// TODO Auto-generated method stub
		String sqlString = "INSERT INTO course VALUES(?,?)";
		try (PreparedStatement op=connection.prepareStatement(sqlString);
			
				){
			op.setInt(1, c.getC_id());
			op.setString(2, c.getCname());
			op.executeUpdate();
			System.out.println("添加成功……");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void deleteCourse(int id) {
		// TODO Auto-generated method stub
		String sqString = "delete from course where c_id = ?";
		try(PreparedStatement pre =connection.prepareStatement(sqString);
				) {
			pre.setInt(1, id);
			pre.executeUpdate();
			System.out.println("删除成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void selectcourse(int id) {
		// TODO Auto-generated method stub
		
		String sqlString = "select * from course where c_id = ?";
		try(PreparedStatement prew =connection.prepareStatement(sqlString);
				
				) {
			prew.setInt(1, id);
			ResultSet res = prew.executeQuery();
			while (res.next()) {
				int c_id =id;
				String cnameString  =res.getString(2);
				course = new Course(c_id,cnameString);
				System.out.println(course.toString());
				System.err.println("查询成功……");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<Student> selectstudentbyid(int id) {
		// TODO Auto-generated method stub
		String sqlString = "SELECT student.*\r\n" + 
				"FROM student\r\n" + 
				"JOIN sc\r\n" + 
				"ON student.studentid = sc.s_id\r\n" + 
				"WHERE sc.c_id = ?";
		List<Student> list = new ArrayList<Student>();
		try (PreparedStatement predPreparedStatement = connection.prepareStatement(sqlString);
				){
			predPreparedStatement.setInt(1, id);
			ResultSet resultSet = predPreparedStatement.executeQuery();
			while (resultSet.next()) {
				String studentid = resultSet.getString("studentid");
				String sname = resultSet.getString("sname");
				Integer sage = resultSet.getInt("sage");
				String ssex = resultSet.getString("ssex");
				Student student = new Student(studentid,sname,ssex,sage);
				list.add(student);	
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public Course updataCourse(int id) {
		// TODO Auto-generated method stub
		String sql = "update course set cname = ? where c_id = ?";
		try(PreparedStatement prewwPreparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = prewwPreparedStatement.executeQuery();
				) {
			prewwPreparedStatement.setInt(2, id);
			String cString = scanner.next();
			course = new Course(id,cString);
			System.out.println("查询成功……");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return course;
	}
	@Override
	public List<Course> selectallCourses() {
		// TODO Auto-generated method stub
		List<Course> list = new ArrayList<Course>();
		String sqlString = "select * from course ";
		try (PreparedStatement preparedStatement =connection.prepareStatement(sqlString);
				ResultSet resultSet =preparedStatement.executeQuery();
				
				){
			while (resultSet.next()) {
				int ciid = resultSet.getInt("c_id");
				String cnaString = resultSet.getString("cname");
				course = new Course(ciid,cnaString);
				list.add(course);
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
