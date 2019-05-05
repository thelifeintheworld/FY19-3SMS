package com.work.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.work.entiy.Student;
/**
 * 接口的实现类
 * @author lenovo
 *
 */
public class StudentDaoTemp implements StudentDAO {
 private Connection connection;
	public StudentDaoTemp(Connection connection) {
	// TODO Auto-generated constructor stub
		this.connection = connection;
	}
	@Override
	public void addStudent(Student s) {
		// TODO Auto-generated method stub
	//连接数据库
		String sql="INSERT INTO student VALUES(?,?,?,?)";
		try(PreparedStatement pSt=connection.prepareStatement(sql);
				) {
			pSt.setString(1, s.getStudentid());
			pSt.setString(2, s.getSname());
			pSt.setInt(3,s.getSage() );
			pSt.setString(4, s.getSsex());
			pSt.executeUpdate();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void exitStudent() {
		// TODO Auto-generated method stub
		System.exit(0);
	}
	@Override
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub
		String sqlString = "update student set sname ='?',sage='?',ssex ='?' where studentid = '?'";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
				){
			preparedStatement.setString(1, s.getStudentid());
			preparedStatement.setString(2, s.getSname());
			preparedStatement.setInt(3, s.getSage());
			preparedStatement.setString(4, s.getSsex());
			preparedStatement.executeUpdate();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void deleteStudent(String id) {
		// TODO Auto-generated method stub
		String sqlString = "DELETE FROM student WHERE studentid ='?'";
		try(PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
				
				) {
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public  List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		List<Student> alList =new ArrayList<Student>();
		String sql="SELECT * FROM student ";
		try(PreparedStatement pStatement =connection.prepareStatement(sql);) {
			ResultSet resultSet =pStatement.executeQuery();
			while (resultSet.next()) {
				String studentid = resultSet.getString("studentid");
				String sname = resultSet.getString("sname");
				Integer sage = resultSet.getInt("sage");
				String ssex = resultSet.getString("ssex");
				Student student = new Student(studentid,sname,ssex,sage);
				alList.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alList;
	}
	@Override
	public Student selectStudentbyid(String id) {
		// TODO Auto-generated method stub
		Student student = new Student();
		String sqlString = "SELECT * FROM student WHERE studentid ='?'";
		try (PreparedStatement preparedStatement =connection.prepareStatement(sqlString);	
				ResultSet resultSet = preparedStatement.executeQuery();
			){
			preparedStatement.setString(1, id);
			//这里有错查不出来
			while (resultSet.next()) {
				 String studentid = resultSet.getString("studentid");
				 String sname = resultSet.getString("sname");
					Integer sage = resultSet.getInt("sage");
					String ssex = resultSet.getString("ssex");
					 student = new Student(studentid,sname,ssex,sage);	 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}
	@Override
	public List<String> selectCrousenamebyid(String id) {
		// TODO Auto-generated method stub
		String sqlString  = "SELECT cNAME\r\n" + 
				"FROM course\r\n" + 
				"JOIN sc\r\n" + 
				"ON course.c_id=sc.c_id\r\n" + 
				"WHERE sc.s_id ='?'";
		List<String> list =new ArrayList<String>();
		try(PreparedStatement preparedStatement = connection.prepareCall(sqlString);
				) {
			preparedStatement.setString(1,id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String string = resultSet.getString("cname");
				list.add(string);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
