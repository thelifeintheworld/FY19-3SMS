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
 * �ӿڵ�ʵ����
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
		System.out.println("��ѡ��Ҫ���еĲ�����");
		System.out.println("1.����ѧ��  2.�޸�ѧ��  3.ɾ��ѧ��  4.��ѯѧ��  5.��ӡѧ��  6.�γ̹���  7.ϵͳ�˳� 8.��ѯѧ����ѡ�γ�");
		System.out.println("**********************************************************");
		System.out.println("��������Ҫ���еĲ��������������֣���");
		int num =scanner.nextInt();
		switch (num) {
		case 1:
			System.out.println("��ѡ���ˡ�����ѧ����");
			System.out.println();
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
			addStudent(student);
			System.out.println("��ӳɹ���ϵͳ���Զ������ϲ�Ŀ¼����");
			menu();
			break;
		case 2:
			System.out.println("��ѡ���ˡ��޸�ѧ����");
			System.out.println("������Ҫ�޸ĵ�ѧ��id��");
			String id1 = scanner.next();
			System.out.println("�޸ĺ�ѧ������Ϊ��");
			String sname1 = scanner.next();
			System.out.println("�޸ĺ��Ա�Ϊ��");
			String ssex1 = scanner.next();
			System.out.println("�޸ĺ�����Ϊ��");
			Integer sage1 = scanner.nextInt();
			Student s = new Student(id1,sname1,ssex1,sage1);
			updateStudent(s);
			System.out.println("�޸ĳɹ���ϵͳ���Զ������ϲ�Ŀ¼����");
			menu();
			break;
		case 3:
			System.out.println("��ѡ���ˡ�ɾ��ѧ����");
			System.out.println("��������Ҫɾ����ѧ��ID��");
			String id2 = scanner.next();
			deleteStudent(id2);;
			System.out.println("ɾ���ɹ���ϵͳ���Զ������ϲ�Ŀ¼����");
			menu();
			break;
		case 4:
			System.out.println("��ѡ���ˡ���ѯѧ����");
			System.out.println("������ѧ��ID��");
			String id11 = scanner.next();
			System.out.println(selectStudentbyid(id11));
			System.out.println("��ѯ�ɹ���ϵͳ���Զ������ϲ�Ŀ¼����");
			menu();
			break;
		case 5:
			System.out.println("��ѡ���ˡ���ӡѧ����");	
			System.out.println("������ѧ��ID��");
			String id12 =scanner.next() ;
			System.out.println(selectStudentbyid(id12));
			System.out.println("��ӡ�ɹ���ϵͳ���Զ������ϲ�Ŀ¼����");
			menu();
			break;
		case 6:
			crouseM.menuc();
			break;
		case 7:
			System.out.println("��ѡ���ˡ��˳�ϵͳ��");	
			exitStudent();
			break;
		case 8:
				System.out.println("������ѧ��ID��");
				String sidString = scanner.next();
				System.out.println(selectCrousenamebyid(sidString));
				System.out.println("��ӡ�ɹ���ϵͳ���Զ������ϲ�Ŀ¼����");
				menu();
				break;
		default:
			System.out.println("�����������������룡");
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
	//�������ݿ�
		String sql="INSERT INTO student VALUES(?,?,?,?)";
		try(PreparedStatement pSt=connection.prepareStatement(sql);
				) {
			pSt.setString(1, s.getStudentid());
			pSt.setString(2, s.getSname());
			pSt.setInt(3,s.getSage() );
			pSt.setString(4, s.getSsex());
			pSt.executeUpdate();
			System.out.println("��ӳɹ�����");
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void exitStudent() {
		// TODO Auto-generated method stub
		System.exit(0);
		System.out.println("�˳��ɹ�����");
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
			System.out.println("ɾ���ɹ�");
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
