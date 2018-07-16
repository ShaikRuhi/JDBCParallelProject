package com.cg.beans;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Account {
private  String cutomername;
public String getCutomername() {
	return cutomername;
}

public Account(String cutomername, String mobile, String emailID,
		double balance, LocalDateTime date) {
	super();
	this.cutomername = cutomername;
	this.mobile = mobile;
	this.emailID = emailID;
	this.balance = balance;
	Date = date;
}

public Account() {
	// TODO Auto-generated constructor stub
}
public void setCutomername(String cutomername) {
	this.cutomername = cutomername;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getEmailID() {
	return emailID;
}
public void setEmailID(String emailID) {
	this.emailID = emailID;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
private String mobile;
private String emailID;
private double balance;
LocalDateTime Date;
public LocalDateTime getDate() {
	return Date;
}
public void setDate(LocalDateTime date) {
	Date = date;
}

}
