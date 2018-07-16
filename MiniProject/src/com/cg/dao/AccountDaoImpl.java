package com.cg.dao;

import java.util.HashMap;

import com.cg.beans.Account;
import com.cg.db.AccountDb;
import com.cg.exception.AccountException;
public class AccountDaoImpl implements AccountDao{
	static HashMap<String,Account> accountMap=AccountDb.getAccountdb();
	@Override
	public String createAccount(Account account) throws AccountException {
		// TODO Auto-generated method stub
		if(accountMap.containsKey(account.getMobile())){
			throw new AccountException("account with mobile no already exists in db");
		}
		accountMap.put(account.getMobile(), account);
		return account.getMobile();
	}
	@Override
	public double showBalance(String mobile) throws AccountException {
		// TODO Auto-generated method stub
		Account account=accountMap.get(mobile);
		if(account==null){
			throw new AccountException("account with mobile does not exist");
		}else
		{
		return account.getBalance();
	}

	}
	@Override
	public Account deposit(String mobile,double balance) throws AccountException {
		// TODO Auto-generated method stub
		Account account=accountMap.get(mobile);
		if(account==null){
			throw new AccountException("account with mobile does not exist");
		}if(balance<=0){
			throw new AccountException("deposit balance should not be <=0");
		}
		double d=account.getBalance()+balance;
			account.setBalance(d);	
		return account;
	}
	@Override
	public Account withdraw(String mobile,double balance) throws AccountException {
		// TODO Auto-generated method stub
		Account account=accountMap.get(mobile);
		double d;
		if(account==null){
			throw new AccountException("account with mobile does not exist");
		}if((balance>account.getBalance())||(balance<=0)){
			throw new AccountException("withdraw balance should be less than account balance and >0");
		}
		d=account.getBalance()-balance;
		account.setBalance(d);
		return account;
	}
	@Override
	public Account transfer(String m1,String m2,double transamt)
			throws AccountException {
		// TODO Auto-generated method stub
AccountDao dao=new AccountDaoImpl();
		Account account=accountMap.get(m1);
		Account account1=accountMap.get(m2);
		double d;
		if(account==null){
			throw new AccountException("account with source mobile does not exist");
		}	if(account1==null){
			throw new AccountException("account with dest mobile does not exist");
		}
		if(m1==m2){
			throw new AccountException("transfer should be done to another account");
		}
		Account ac1=dao.withdraw(m1,transamt);
		Account ac2=dao.deposit(m1,transamt);
		return ac2 ;
	}
	@Override
	public Account printDetails(String mobile) throws AccountException {
		// TODO Auto-generated method stub
		Account account=accountMap.get(mobile);
		if(account==null){
			throw new AccountException("account with mobile does not exist");
		}
		return account;
	}
	}
