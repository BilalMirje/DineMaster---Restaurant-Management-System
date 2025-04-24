package com.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.dao.ServiceDaoImpl;
import com.model.ServiceModulePojo;
import com.validation.ServiceModuleValidationImpl;

public class ServiceModuleServiceImpl implements ServiceModuleService {
	private String result;
	@Override
	public String validateService(String iconname, String title, String description) {
		

		try {
		   ServiceModuleValidationImpl serviceModuleValidationImpl=new ServiceModuleValidationImpl();
		   result=serviceModuleValidationImpl.serviceModuleValidation(iconname, title, description);
		} 
		catch (Exception e) {
			result="Service Error";
			e.printStackTrace();
		}
		
		return result;
	}
	@Override
	public String addService(String iconname, String title, String description) {
		try {
			   ServiceDaoImpl serviceDaoImpl=new ServiceDaoImpl();
			   String dateTime=LocalDateTime.now().toString();
			   result=serviceDaoImpl.saveService(iconname, title, description, dateTime);
			} 
			catch (Exception e) {
				result="Service Error";
				e.printStackTrace();
			}
			
			return result;
	}
	@Override
	public ArrayList<ServiceModulePojo> readService() {
		ArrayList<ServiceModulePojo> arrayList=null;
		
		try {
			
			ServiceDaoImpl serviceDaoImpl=new ServiceDaoImpl();
			arrayList=serviceDaoImpl.readAllServices();
		} 
		catch (Exception e) {
			result="Service Error";
			e.printStackTrace();
		}
		
		return arrayList;
	}
	@Override
	public ArrayList<ServiceModulePojo> readFourService() {
ArrayList<ServiceModulePojo> arrayList=null;
		
		try {
			
			ServiceDaoImpl serviceDaoImpl=new ServiceDaoImpl();
			arrayList=serviceDaoImpl.readFourServices();
		} 
		catch (Exception e) {
			result="Service Error";
			e.printStackTrace();
		}
		
		return arrayList;
	}
	@Override
	public String deleteService(String id) {
		try {
			
			int sn=Integer.parseInt(id);
			ServiceDaoImpl serviceDaoImpl=new ServiceDaoImpl();
			result=serviceDaoImpl.deleteService(sn);
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		return result;
	}
	private ServiceDaoImpl serviceDao = new ServiceDaoImpl();
	@Override
	public String updateService(ServiceModulePojo service) {
		 
		return serviceDao.updateService(service);
	}

}
