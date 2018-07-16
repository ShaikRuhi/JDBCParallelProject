package com.cg.service;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import com.cg.beans.Account;
import com.cg.exception.AccountException;

public class AccountServiceImplTest {
	AccountService service1=new AccountServiceImpl();
	
		
	
	
	@Test
	public void testCreateAccount() {
		Account ac=new Account("Rehana", "9999966666", "rehana.ss123@gmail.com", 22000,LocalDateTime.now());
		try {
			
		String s=service1.createAccount(ac);
			Assert.assertNotNull(s);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void testCreateAccountName() {
	
		Account ac=new Account("rehana", "9999966666", "rehana.ss123@gmail.com", 22000,LocalDateTime.now());
		try {
			
			service1.createAccount(ac);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
		assertEquals("name should starts with capital letter and should contain only alphabets",e.getMessage());
		}
	}
	@Test
	public void testCreateAccountMobille() {
		Account ac=new Account("Rehana", "999996", "rehana.ss123@gmail.com", 22000,LocalDateTime.now());
		try {
			service1.createAccount(ac);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("mobile num contain 10 digits",e.getMessage());
		}
	}
	@Test
	public void testCreateAccountEmail() {
		Account ac=new Account("Rehana", "9999966666", "rehana123@yahoo1.com", 22000,LocalDateTime.now());
		try {
			service1.createAccount(ac);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("invalid email",e.getMessage());
		}
	}
	@Test
	public void testCreateAccountBalance() {
		Account ac=new Account("Rehana", "9999966666", "rehana.ss123@gmail.com", 0,LocalDateTime.now());
		try {
			service1.createAccount(ac);
		} catch (AccountException e) {
			assertEquals("balance should be greater than zero",e.getMessage());
		}
	}
	@Test
	public void testCreateAccountAll() {
		Account ac=new Account("Rehana", "9999999999", "rehana.ss123@gmail.com", 2000,LocalDateTime.now());
		try{
			service1.createAccount(ac);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("account with mobile no already exists in db",e.getMessage());
		}
	}
	@Test
	public void testCreateAccountNameEmpty() {
		Account ac=new Account("", "9999999999", "rehana.ss123@gmail.com", 2000,LocalDateTime.now());
		try{
			service1.createAccount(ac);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("Employee name can not be empty",e.getMessage());
		}
	}
	
		
		@Test
		public void testShowBalance()
		{
			try{
			
			Assert.assertEquals(34000.0, service1.showBalance("6666666666"),0.00);
			}catch(AccountException e){
				System.out.println(e.getMessage());
			}
		}
		@Test
		public void testShowBalanceMobileDigits()
		{
			try{
			service1.showBalance("777777");
			}catch(AccountException e){
				assertEquals("mobile num contain 10 digits",e.getMessage());
			}
		}
		
		
		@Test
		public void testShowBalanceMobile()
		{
			try{
			service1.showBalance("9502090455");
			}catch(AccountException e){
				assertEquals("account with mobile does not exist",e.getMessage());
			}
		}
		
		@Test
		public void testDepositMobile()
		{
			try {
				service1.deposit("7777",20000);
			} catch (AccountException e) {
				// TODO Auto-generated catch block
				assertEquals("mobile num contain 10 digits",e.getMessage());
			}
			
		}
		@Test
		public void testDeposit()
		{
			try {
			Account acc=service1.deposit("8888888888",500);
			Assert.assertNotNull(acc);
			} catch (AccountException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
		}
		@Test
		public void testDepositNegativeBalance()
		{
			try {
				service1.deposit("9999999999",-25000);
			} catch (AccountException e) {
				// TODO Auto-generated catch block
				assertEquals("deposit balance should not be <=0",e.getMessage());
			}
			
		}
		@Test
		public void testDepositMobile1()
		{
			try {
				service1.deposit("9502090455",25000);
			} catch (AccountException e) {
				// TODO Auto-generated catch block
				assertEquals("account with mobile does not exist",e.getMessage());
			}
			
		}
		@Test
		public void testDepositZeroBalance()
		{
			try {
				service1.deposit("9999999999",0);
			} catch (AccountException e) {
				// TODO Auto-generated catch block
				assertEquals("deposit balance should not be <=0",e.getMessage());
			}
			
		}
		
		@Test
		public void testWithdraw()
		{
			try {
				Account acc=service1.withdraw("6666666666", 30000);
				Assert.assertNotNull(acc);
			} catch (AccountException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
		}
		@Test
		public void testWithdrawMobileDigits()
		{
			try {
				service1.withdraw("77777", 5000);
			} catch (AccountException e) {
				// TODO Auto-generated catch block
				assertEquals("mobile num contain 10 digits",e.getMessage());
			}
			
		}
		@Test
		public void testWithdrawBalance()
		{
			try {
				service1.withdraw("8888888888", 10000);
			} catch (AccountException e) {
				// TODO Auto-generated catch block
				assertEquals("withdraw balance should be less than account balance and >0",e.getMessage());
			}
			
		}
		@Test
		public void testWithdrawNegativeBalance()
		{
			try {
				service1.withdraw("9999999999", -1000);
			} catch (AccountException e) {
				// TODO Auto-generated catch block
				assertEquals("withdraw balance should be less than account balance and >0",e.getMessage());
			}
			
		}
		@Test
		public void testWithdrawNotMobile()
		{
			try {
				service1.withdraw("1234567898", 1000);
			} catch (AccountException e) {
				// TODO Auto-generated catch block
				assertEquals("account with mobile does not exist",e.getMessage());
			}
			
		}
		@Test
		public void testWithdrawZeroBalance()
		{
			try {
				service1.withdraw("9999999999", 0);
			} catch (AccountException e) {
				// TODO Auto-generated catch block
				assertEquals("withdraw balance should be less than account balance and >0",e.getMessage());
			}
			
		}
		@Test
		public void testTransfer()
		{
			try {
				Account acc=service1.transfer("9999999999","6666666666", 1000);
				Assert.assertNotNull(acc);
			} catch (AccountException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
		}
		
		@Test
		public void testTransferSourceMobile()
		{
			try {
				service1.transfer("1234567898","9502090455", 1000);
			} catch (AccountException e) {
				// TODO Auto-generated catch block
				assertEquals("account with source mobile does not exist",e.getMessage());
			}
			
		}
		@Test
		public void testTransferSameMobile()
		{
			try {
				service1.transfer("6666666666","6666666666", 1000);
			} catch (AccountException e) {
				// TODO Auto-generated catch block
				assertEquals("transfer should be done to another account",e.getMessage());
			}
			
		}
		@Test
		public void testTransferMobileDigits1()
		{
			try {
				service1.transfer("6666666666","589", 1000);
			} catch (AccountException e) {
				// TODO Auto-generated catch block
				assertEquals("destination mobile num contain 10 digits",e.getMessage());
			}
			
		}
		@Test
		public void testTransferMobileDigits2()
		{
			try {
				service1.transfer("66666","5897865432", 1000);
			} catch (AccountException e) {
				// TODO Auto-generated catch block
				assertEquals("source mobile num contain 10 digits",e.getMessage());
			}
			
		}
		@Test
		public void testTransferZeroBalance()
		{
			try {
				service1.transfer("6666666666","9999999999", 0);
			} catch (AccountException e) {
				// TODO Auto-generated catch block
				assertEquals("transfer amount should be >0",e.getMessage());
			}
			
		}
		@Test
		public void testTransferNegativeBalance()
		{
			try {
				service1.transfer("6666666666","9999999999", -500);
			} catch (AccountException e) {
				// TODO Auto-generated catch block
				assertEquals("transfer amount should be >0",e.getMessage());
			}
			
		}
		@Test
		public void testTransferDestinationMobile()
		{
			try {
				service1.transfer("6666666666","5896785432", 1000);
			} catch (AccountException e) {
				// TODO Auto-generated catch block
				assertEquals("account with dest mobile does not exist",e.getMessage());
			}
			
		}
		@Test
		public void testPrintDetailsMobileDigits()
		{
			try {
				service1.printDetails("5646757");
			} catch (AccountException e) {
				// TODO Auto-generated catch block
				assertEquals("mobile num contain 10 digits",e.getMessage());
			}
			
		}
		@Test
		public void testPrintDetailsMobile()
		{
			try {
				service1.printDetails("5646757456");
			} catch (AccountException e) {
				// TODO Auto-generated catch block
				assertEquals("account with mobile does not exist",e.getMessage());
			}
			
		}
		@Test
		public void testPrintDetails()
		{
			try {
		Account acc=service1.printDetails("8888888888");
		Assert.assertNotNull(acc);
			} catch (AccountException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
		}
		
		}
		
		

	


