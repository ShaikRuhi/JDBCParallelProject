package com.cg.dao;



import com.cg.beans.Account;
import com.cg.exception.AccountException;

public interface AccountDao {
	String createAccount(Account account)throws AccountException;
	double showBalance(String mobile) throws AccountException;
 Account deposit(String mobile,double balance)throws AccountException;
Account withdraw(String mobile,double balance)throws AccountException;
Account transfer(String m1,String m2,double transamt)throws AccountException;
 Account printDetails(String mobile)throws AccountException;
}
