package com.dao;

import java.util.ArrayList;

import com.model.ServiceModulePojo;

public interface ServiceDao {
	public String saveService(String iconname,String title,String description,String dateTime);
	public ArrayList<ServiceModulePojo> readAllServices();
	public ArrayList<ServiceModulePojo> readFourServices();
	public String deleteService(int id);
	String updateService(ServiceModulePojo service);
	

}
