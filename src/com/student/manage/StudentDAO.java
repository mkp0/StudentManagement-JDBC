package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;


public class StudentDAO {
	
	public static boolean insertStudenttoDB(Student st) {
		
		boolean isSuccess = false;
		
		try {
			Connection connection = CP.createC();
			String q = "insert into students(sname, sphone, scity) values(?,?,?)";
			
			PreparedStatement pStatement = connection.prepareStatement(q);
			
			pStatement.setString(1, st.getStudentName());
			pStatement.setString(2, st.getStudentPhone());
			pStatement.setString(3, st.getStudentCity());
			
			pStatement.executeUpdate();
			isSuccess = true;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return isSuccess;
		
	}
	
	public static boolean deleteStudenttoDB(Integer id) {
		
		boolean isSuccess = false;
		
		try {
			Connection connection = CP.createC();
			String q = "delete from students where id = ?";
			
			PreparedStatement pStatement = connection.prepareStatement(q);
			pStatement.setInt(1, id);
			
			pStatement.executeUpdate();
			isSuccess = true;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return isSuccess;
		
	}
	
	public static boolean showAllStudents() {
		
		boolean isSuccess = false;
		
		try {
			Connection connection = CP.createC();
			String q = "select * from students";
			
			PreparedStatement pStatement = connection.prepareStatement(q);
			
			ResultSet sResultset= pStatement.executeQuery();
			
			while(sResultset.next())
			{
				int id = sResultset.getInt("sid");
				String name = sResultset.getString("sname");
				String phone = sResultset.getString("sphone");
				String city = sResultset.getString("scity");
				
				System.out.println(id + " " + name + " " + phone + " " +city);
			}
			isSuccess = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return isSuccess;
		
	}
	
	public static boolean findStudentById(int id) {
		
		boolean isSuccess = false;
		
		try {
			Connection connection = CP.createC();
			String q = "select * from students where id = ?";
			
			PreparedStatement pStatement = connection.prepareStatement(q);
			
			pStatement.setInt(1, id);
			
			ResultSet sResultset= pStatement.executeQuery();
			
			while(sResultset.next())
			{
				int idx = sResultset.getInt("sid");
				String name = sResultset.getString("sname");
				String phone = sResultset.getString("sphone");
				String city = sResultset.getString("scity");
				
				System.out.println(idx + " " + name + " " + phone + " " +city);
			}
			isSuccess = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return isSuccess;
		
	}

}
