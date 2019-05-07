package com.work.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.work.entiy.Student;
/**
 * 接口的实现类
 * @author lenovo
 *
 */
public class StudentDaoTemp implements StudentDAO {
 private Connection connection;
 Set<Student> set = new HashSet<Student>();
	static Scanner scanner = new Scanner(System.in); 
	static CrouseM crouseM = new CrouseM(Studentutil.getConnection());;
 public static void main(String[] args) {
	StudentDaoTemp studentDaoTemp = new StudentDaoTemp(Studentutil.getConnection());
	studentDaoTemp.menu();

}
 public void menu(){
		System.out.println("**********************************************************");
		System.out.println("请选择要进行的操作：");
		System.out.println("1.增加学生  2.修改学生  3.删除学生  4.查询学生  5.打印学生  6.课程管理  7.系统退出 8.查询学生所选课程");
		System.out.println("**********************************************************");
		System.out.println("请输入您要进行的操作（请输入数字）：");
		int num =scanner.nextInt();
		switch (num) {
		case 1:
			System.out.println("您选择了“增加学生”");
			System.out.println();
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
			addStudent(student);
			System.out.println("添加成功，系统将自动返回上层目录……");
			menu();
			break;
		case 2:
			System.out.println("您选择了“修改学生”");
			System.out.println("请输入要修改的学生id：");
			String id1 = scanner.next();
			System.out.println("修改后学生姓名为：");
			String sname1 = scanner.next();
			System.out.println("修改后性别为：");
			String ssex1 = scanner.next();
			System.out.println("修改后年龄为：");
			Integer sage1 = scanner.nextInt();
			Student s = new Student(id1,sname1,ssex1,sage1);
			updateStudent(s);
			System.out.println("修改成功，系统将自动返回上层目录……");
			menu();
			break;
		case 3:
			System.out.println("您选择了“删除学生”");
			System.out.println("请输入您要删除的学生ID：");
			String id2 = scanner.next();
			deleteStudent(id2);;
			System.out.println("删除成功，系统将自动返回上层目录……");
			menu();
			break;
		case 4:
			System.out.println("您选择了“查询学生”");
			System.out.println("请输入学生ID：");
			String id11 = scanner.next();
			System.out.println(selectStudentbyid(id11));
			System.out.println("查询成功，系统将自动返回上层目录……");
			menu();
			break;
		case 5:
			System.out.println("您选择了“打印学生”");	
			System.out.println("请输入学生ID：");
			String id12 =scanner.next() ;
			System.out.println(selectStudentbyid(id12));
			System.out.println("打印成功，系统将自动返回上层目录……");
			menu();
			break;
		case 6:
			crouseM.menuc();
			break;
		case 7:
			System.out.println("您选择了“退出系统”");	
			exitStudent();
			break;
		case 8:
				System.out.println("请输入学生ID：");
				String sidString = scanner.next();
				System.out.println(selectCrousenamebyid(sidString));
				System.out.println("打印成功，系统将自动返回上层目录……");
				menu();
				break;
		default:
			System.out.println("输入有误，请重新输入！");
			menu();
			break;
		}
		
		System.out.println("**********************************************************");
		
	}
	
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
			System.out.println("添加成功……");
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void exitStudent() {
		// TODO Auto-generated method stub
		System.exit(0);
		System.out.println("退出成功……");
	}
	@Override
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub
		String sqlString = "update student set sname =?,sage=?,ssex =? where studentid = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
				){
			preparedStatement.setString(4, s.getStudentid());
			preparedStatement.setString(1, s.getSname());
			preparedStatement.setInt(2, s.getSage());
			preparedStatement.setString(3, s.getSsex());
			preparedStatement.executeUpdate();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void deleteStudent(String id) {
		// TODO Auto-generated method stub
		String sqlString = "DELETE FROM student WHERE studentid = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
					) {
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
			System.out.println("删除成功");
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
		String sqlString = "SELECT * FROM student WHERE studentid = ?";
		try (
				PreparedStatement preparedStatement =connection.prepareStatement(sqlString);	
				){
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String studentid = id ;
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
				"WHERE sc.s_id = ?";
		List<String> list =new ArrayList<String>();
		try(PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
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
