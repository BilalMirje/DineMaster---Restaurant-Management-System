package com.model;

public class ServiceModulePojo {
	private int id;
	private String iconname;
	private String title;
	private String description;
	private String dateTime;
	public ServiceModulePojo(int id, String iconname, String title, String description, String dateTime) {
		super();
		this.id = id;
		this.iconname = iconname;
		this.title = title;
		this.description = description;
		this.dateTime = dateTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIconname() {
		return iconname;
	}
	public void setIconname(String iconname) {
		this.iconname = iconname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	@Override
	public String toString() {
		return "ServiceModulePojo [id=" + id + ", iconname=" + iconname + ", title=" + title + ", description="
				+ description + ", dateTime=" + dateTime + "]";
	}
	
	
}
