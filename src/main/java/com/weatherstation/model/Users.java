package com.weatherstation.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Users")


public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 150899717865025942L;
	@Id @GeneratedValue 
	private String RecordIndex;
	private String UserName;
	private String Password;
	private String Organization;
	private String Role;
	private String Email;
	
	public Users()
	{
		
	}

	public Users(String userName, String password,
			String organization, String role, String email) {
		super();
		UserName = userName;
		Password = password;
		Organization = organization;
		Role = role;
		Email = email;
	}

	public String getRecordIndex() {
		return RecordIndex;
	}

	public void setRecordIndex(String recordIndex) {
		RecordIndex = recordIndex;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getOrganization() {
		return Organization;
	}

	public void setOrganization(String organization) {
		Organization = organization;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
	

}
