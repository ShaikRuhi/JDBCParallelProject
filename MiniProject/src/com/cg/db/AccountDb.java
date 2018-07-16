package com.cg.db;



import java.time.LocalDateTime;
import java.util.HashMap;




import com.cg.beans.Account;



public class AccountDb {
	private static HashMap<String,Account> accountdb=new HashMap<String,Account>();

	public static HashMap<String, Account> getAccountdb() {
		return accountdb;
	}
	static{
		accountdb.put("9999999999",new Account("Rehana","9999999999" ,"rehana.shaik123@gmail.com", 2000,LocalDateTime.now()));
		accountdb.put("7777777777",new Account("Rehan","7777777777" ,"rehan.shaik12@gmail.com", 25000,LocalDateTime.now()));
		accountdb.put("8888888888",new Account("Hameed","8888888888" ,"hameed.shaik3@gmail.com", 5000,LocalDateTime.now()));
		accountdb.put("6666666666",new Account("Arshad","6666666666" ,"arshad.shaik@gmail.com", 34000,LocalDateTime.now()));
	}
}
