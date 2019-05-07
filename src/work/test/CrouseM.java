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
		System.out.println("��ѡ���ˡ��γ̹���");		
		System.out.println("***************************************************************");
		System.out.println("*1.���ӿγ�  2.ɾ���γ� 3.�޸Ŀγ� 4.��ѯѡ���Ӧ�γ̵�ѧ����Ϣ 5.��ѯ���еĿγ� 6.�����ϲ�Ŀ¼ *");
		System.out.println("***************************************************************");
		System.out.println("��ѡ����Ҫ���еĲ������������Ӧ�����֣���");
		int numm = scanner.nextInt();
		switch (numm) {
		case 1:
			System.out.println("��������Ҫ��ӵĿγ���Ϣ��");
			System.out.println("������γ̺ţ����֣���");
			int C_id = scanner.nextInt();
			System.out.println("������γ�����");
			String Cname = scanner.next();	
			Course crouse = new Course(C_id,Cname);
			addCrouses(crouse);
			System.out.println("��ӳɹ���ϵͳ���Զ������ϲ�Ŀ¼����");
			menuc();
			break;
			
		case 2:
			System.out.println("������Ҫɾ���Ŀγ�id��");
			int C_id1 = scanner.nextInt();
			deleteCourse(C_id1);
			System.out.println("ɾ���ɹ���ϵͳ���Զ������ϲ�Ŀ¼����");
			menuc();
			break;
		case 3:
			System.out.println("������Ҫ�޸ĵĿγ�id��");
			int cid = scanner.nextInt();
			updataCourse(cid);
			System.out.println("�޸ĳɹ���ϵͳ���Զ������ϲ�Ŀ¼����");
			menuc();
				break;
		case 4:
			System.out.println("������Ҫ��ѯ�Ŀγ�id��");
			int c_id = scanner.nextInt();
			System.out.println(selectstudentbyid(c_id));
			System.out.println("��ѯ�ɹ���ϵͳ���Զ������ϲ�Ŀ¼����");
			menuc();
				break;
		case 5:
			System.out.println("��ѡ���˲�ѯ���пγ���Ϣ");
			System.out.println(selectallCourses());
			System.out.println("��ѯ�ɹ���ϵͳ���Զ������ϲ�Ŀ¼����");
			menuc();
			break;
		case 6:
			studentDaoTemp.menu();
			break;
		default:
			System.out.println("�����������������롭��");
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
			System.out.println("��ӳɹ�����");
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
			System.out.println("ɾ���ɹ�");
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
				System.err.println("��ѯ�ɹ�����");
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
			System.out.println("��ѯ�ɹ�����");
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
