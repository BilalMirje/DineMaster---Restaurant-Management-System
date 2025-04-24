package com.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.dao.ContactDaoImpl;
import com.model.ContactPojo;
import com.validation.ContactValidationImpl;

public class ContactServiceImpl implements ContactService {
	private String result;
	@Override
	public String contactService1(String name, String email, String subject, String message) {

		try {
			ContactValidationImpl contactValidationImpl=new ContactValidationImpl();
			result =contactValidationImpl.contactValidation(name, email, subject, message); 
		} 
		catch (Exception e) {
			result="Service Error";
			e.printStackTrace();
		}
		
		return result;
	}
	@Override
	public String contactService2(String name, String email, String subject, String message) {
		
		try {
			
			String dateTime = LocalDateTime.now().toString();
			ContactDaoImpl contactDaoImpl=new ContactDaoImpl();
			result=contactDaoImpl.saveContact(name, email, subject, message, dateTime);
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return result;
		
		
	}
	@Override
	public ArrayList<ContactPojo> readContactService() {

		ArrayList<ContactPojo> arrayList=null;
		
		try {
			
			ContactDaoImpl contactDaoImpl=new ContactDaoImpl();
			arrayList=contactDaoImpl.readContact();
		} 
		catch (Exception e) {
			result="Service Error";
			e.printStackTrace();
		}
		
		return arrayList;
	}
	@Override
	public String deleteService(String id) {
		// TODO Auto-generated method stub
		try {
			
			int sn=Integer.parseInt(id);
			ContactDaoImpl contactDaoImpl=new ContactDaoImpl();
			result=contactDaoImpl.deleteContact(sn);
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		return result;
	}

}
