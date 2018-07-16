package com.cg.service;

import com.cg.beans.Account;
import com.cg.dao.AccountDao;
import com.cg.dao.AccountDaoImpl;
import com.cg.exception.AccountException;


public class AccountServiceImpl implements AccountService {
	AccountDao accountDao=new AccountDaoImpl();
	
	@Override
	public String createAccount(Account account) throws AccountException {
		// TODO Auto-generated method stub
		AccountService service=new AccountServiceImpl();
		boolean b=service.validateAccount(account);
		if(b){
		return accountDao.createAccount(account);
		}else{
			throw new AccountException("invalid information");
		}
		
	}
	@Override
	public double showBalance(String mobile) throws AccountException {
		// TODO Auto-generated method stub
		if(!mobile.matches("\\d{10}")){
			throw new AccountException("mobile num contain 10 digits");
			
		}
	return accountDao.showBalance(mobile);
	}
	@Override
	public boolean validateAccount(Account account) throws AccountException {
		// TODO Auto-generated method stub
		if(validateName(account.getCutomername())
				&&validateMobile(account.getMobile())
				&&validateEmail(account.getEmailID())
				&&validateBalance(account.getBalance()))
		{
			return true;
		}
		return false;
	}
	private boolean validateName(String name) throws AccountException{
		if(name.isEmpty()||name==null){
			throw new AccountException("Employee name can not be empty");
		}else{
			if(!name.matches("[A-Z][A-za-z]{3,}")){
				throw new AccountException("name should starts with capital letter and should contain only alphabets");
			}
		}
		return true;
	}
	private boolean validateMobile(String mobile)throws AccountException{
		if(!mobile.matches("\\d{10}")){
			throw new AccountException("mobile num contain 10 digits");
			
		}
			return true;
		}
	private boolean validateEmail(String email)throws AccountException{
		if(!email.matches("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$")){
			throw new AccountException("invalid email");
			
		}
		return true;
		
	}
	private boolean validateBalance(double balance)throws AccountException{
		
		if(!(balance>0)){
			throw new AccountException("balance should be greater than zero");
		}
		return true;
		
	}
	@Override
	public Account deposit(String mobile,double balance) throws AccountException {
		// TODO Auto-generated method stub
		if(!mobile.matches("\\d{10}")){
			throw new AccountException("mobile num contain 10 digits");
			
		}
		return accountDao.deposit(mobile, balance);
	}
	@Override
	public Account withdraw(String mobile,double balance) throws AccountException {
		// TODO Auto-generated method stub
		if(!mobile.matches("\\d{10}")){
			throw new AccountException("mobile num contain 10 digits");
			
		}
		return accountDao.withdraw(mobile, balance);
	}
	@Override
	public Account transfer(String m1,String m2 ,double transamt)
			throws AccountException {
		// TODO Auto-generated method stub
		if(!m1.matches("\\d{10}")){
			throw new AccountException("source mobile num contain 10 digits");
			
		}if(!m2.matches("\\d{10}")){
			throw new AccountException("destination mobile num contain 10 digits");
			
		}if(transamt<=0){
			throw new AccountException("transfer amount should be >0");
		}
		return accountDao.transfer(m1, m2, transamt);
	}
	@Override
	public Account printDetails(String mobile) throws AccountException {
		// TODO Auto-generated method stub
		if(!mobile.matches("\\d{10}")){
			throw new AccountException("mobile num contain 10 digits");
			
		}
		return accountDao.printDetails(mobile);
	}
	
	}


