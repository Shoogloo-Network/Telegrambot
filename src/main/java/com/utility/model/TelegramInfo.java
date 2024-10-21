package com.utility.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Entity

//@Table()

public class TelegramInfo {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private String email;
	private String password;
	private String networkUrl;

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNetworkUrl() {
		return networkUrl;
	}

	public void setNetworkUrl(String networkUrl) {
		this.networkUrl = networkUrl;
	}

}