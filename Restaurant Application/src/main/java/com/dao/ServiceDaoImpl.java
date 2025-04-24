package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.ServiceModulePojo;

public class ServiceDaoImpl implements ServiceDao {
	private String result; 
	@Override
	public String saveService(String iconname, String title, String description, String dateTime) {
		Connection connection=null;
		try {
			connection=ConnectionFactory.getConnection();
			String sql="insert into service(iconname,title,description,dateTime) values(?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString( 1, iconname);
			preparedStatement.setString( 2, title);
			preparedStatement.setString( 3, description);
			preparedStatement.setString( 4, dateTime);
			
			int x=preparedStatement.executeUpdate();
			if (x==1) {
				result="Service added Successfully";
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
	public ArrayList<ServiceModulePojo> readAllServices() {
		
		ArrayList<ServiceModulePojo> arrayList=new ArrayList<ServiceModulePojo>();
		Connection connection=null;
		try {
			connection=ConnectionFactory.getConnection();
			String sql="select * from service";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			 ResultSet resultSet=preparedStatement.executeQuery();
			 
			 if (!resultSet.next()) {
					arrayList.add(new ServiceModulePojo(0, "NA", "NA", "NA", "NA"))	;
				
		    }
			 else {
				do {
					ServiceModulePojo serviceModulePojo=new ServiceModulePojo(resultSet.getInt("id"), resultSet.getString("iconname"),
							resultSet.getString("title"), resultSet.getString("description"), resultSet.getString("dateTime"));
					arrayList.add(serviceModulePojo);
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
	public ArrayList<ServiceModulePojo> readFourServices() {
		ArrayList<ServiceModulePojo> arrayList=new ArrayList<ServiceModulePojo>();
		Connection connection=null;
		try {
			connection=ConnectionFactory.getConnection();
			String sql="select * from service LIMIT 4 ";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			 ResultSet resultSet=preparedStatement.executeQuery();
			 
			 if (!resultSet.next()) {
					arrayList.add(new ServiceModulePojo(0, "NA", "NA", "NA", "NA"))	;
				
		    }
			 else {
				do {
					ServiceModulePojo serviceModulePojo=new ServiceModulePojo(resultSet.getInt("id"), resultSet.getString("iconname"),
							resultSet.getString("title"), resultSet.getString("description"), resultSet.getString("dateTime"));
					arrayList.add(serviceModulePojo);
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
	public String deleteService(int id) {
		Connection connection=null;
		try {
			connection=ConnectionFactory.getConnection();
			String sql="delete from service where id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt( 1, id);
			
			
			int x=preparedStatement.executeUpdate();
			if (x==1) {
				result="Service Deleted Successfully";
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
	public String updateService(ServiceModulePojo service) {
		Connection connection = null;
        result = "Failed to update service";

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "UPDATE service SET iconname=?, title=?, description=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, service.getIconname());
            preparedStatement.setString(2, service.getTitle());
            preparedStatement.setString(3, service.getDescription());
            preparedStatement.setInt(4, service.getId());

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                result = "Service updated successfully";
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = "Error updating service: " + e.getMessage();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;

	}


}
