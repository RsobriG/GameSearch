package com.games.GameSearch;


import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import lombok.Data;


@Entity
@Table (name = "Users")
 public class User {

	@Id
	@Column(name = "nickName")
	private String nickName;

	@Column(name = "Name")
	private String name;

	@Column(name = "surName")
	private String surName;

	@Column(name = "mail")
	private String mail;

	@Column(name = "password")
	private String password;

	@Column(name = "address")
	private String address;

	@Column(name="homelat")
	private double homeLat;

	@Column(name="homelong")
	private double homeLong;

	@Column(name = "birthday")
	private String birthday;
	
	//Constructor
	
	public User() {
		super();
	}
	
	public User(String name) {
		super();
		this.name = name;
	}

	
	//Getters and Setters
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getHomeLat() {
		return homeLat;
	}

	public void setHomeLat(double homeLat) {
		this.homeLat = homeLat;
	}

	public double getHomeLong() {
		return homeLong;
	}

	public void setHomeLong(double homeLong) {
		this.homeLong = homeLong;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
}
