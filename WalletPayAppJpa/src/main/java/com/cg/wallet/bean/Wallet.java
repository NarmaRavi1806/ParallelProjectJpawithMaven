package com.cg.wallet.bean;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * Class name : Wallet
 * No. of Methods : 2
 * Purpose : Bean class to access the attributes
 * 
 * Author : Narmatha
 * Date of Creation : 04-August-2018
 * 
 * Last Modification Date : 04-August-2018
 *
 */
@Entity
public class Wallet {
	
	@Id
	@GeneratedValue
	private int id;
	String name;
	String mobileNo;
	String emailId;
	double balance;
	Date date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public Wallet(String name, String mobileNo, String emailId, double balance,
			Date date) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.balance = balance;
		this.date = date;
	}
	public Wallet(){
		super();
	}

}
