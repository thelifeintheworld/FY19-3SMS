package com.work.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class Studentutil {
	
	//���ݿ������ļ�

		private static Properties properties;
		static {
			properties = new Properties();
			try {
				properties.load(Studentutil.class.getResourceAsStream("/Sqldress"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//�����ļ��е�URL���û���������
		private static final String URL = properties.getProperty("url");
		private static final String USERNAME = properties.getProperty("username");
		private static final String PASSWORD = properties.getProperty("pwd");

	//��ȡ����
		public static Connection getConnection() {
			Connection connection = null;
			try{
				 connection=DriverManager.getConnection(URL, USERNAME, PASSWORD);
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return connection;
		}
	
}
