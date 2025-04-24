package com.service;

import java.util.ArrayList;

import com.model.ContactPojo;

public interface ContactService {
	public String contactService1(String name,String email,String subject,String message);
	public String contactService2(String name,String email,String subject,String message);
	public ArrayList<ContactPojo> readContactService();
	public String deleteService(String id);

}
