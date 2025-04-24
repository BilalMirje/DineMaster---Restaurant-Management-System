package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.ContactPojo;

public class ContactDaoImpl implements ContactDao {
	
	private String result;
	@Override
	public String saveContact(String name, String email, String subject, String message, String dateTime) {
		Connection connection=null;
		try {
			connection=ConnectionFactory.getConnection();
			String sql="insert into contact(name,email,subject,message,dateTime) values(?,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString( 1, name);
			preparedStatement.setString( 2, email);
			preparedStatement.setString( 3, subject);
			preparedStatement.setString( 4, message);
			preparedStatement.setString( 5, dateTime);
			
			int x=preparedStatement.executeUpdate();
			if (x==1) {
				result="Mesaage Sent Successfully";
			}
			else {
				result="Something Went Wrong!Try Again";
			}
			

			
		} 
		
		catch (Exception e) {
			e.printStackTrace();
			result="Failed";

		}
		finally {
			try {
				connection.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return result;
	}
	@Override
	public ArrayList<ContactPojo> readContact() {
		ArrayList<ContactPojo> arrayList=new ArrayList<ContactPojo>();
		Connection connection=null;
		try {
			connection=ConnectionFactory.getConnection();
			String sql="select * from contact";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			 ResultSet resultSet=preparedStatement.executeQuery();
			 
			if (!resultSet.next()) {
			arrayList.add(new ContactPojo(0, "NA", "NA", "NA", "NA", "NA"))	;
			}
			else {
				do {
					arrayList.add(new ContactPojo(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"), 
							resultSet.getString("subject"), resultSet.getString("message"), resultSet.getString("dateTime")));
				} while (resultSet.next());
				 
			}
			
		} 
		
		catch (Exception e) {
			e.printStackTrace();
			arrayList.clear();
		}
		finally {
			try {
				connection.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return arrayList;
	}
	@Override
	public String deleteContact(int id) {
		Connection connection=null;
		try {
			connection=ConnectionFactory.getConnection();
			String sql="delete from contact where id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt( 1, id);
			
			
			int x=preparedStatement.executeUpdate();
			if (x==1) {
				result="Mesaage Deleted Successfully";
			}
			else {
				result="Something Went Wrong!Try Again";
			}
			

			
		} 
		
		catch (Exception e) {
			e.printStackTrace();
			result="Failed";

		}
		finally {
			try {
				connection.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return result;
	}

}
