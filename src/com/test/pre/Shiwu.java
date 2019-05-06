package com.test.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.work.test.Studentutil;

public class Shiwu {
public static void main(String[] args) {
	Connection connection =null;
	try {
		connection = Studentutil.getConnection();	
		connection.setAutoCommit(false);
		String sql = "update user set ";
		connection.prepareStatement(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
