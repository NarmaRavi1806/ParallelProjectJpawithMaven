package com.cg.wallet;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.cg.wallet.bean.Wallet;
import com.cg.wallet.walletException.WalletException;
import com.cg.wallet.walletService.WalletServiceImpl;

/**
 * 
 * Class name : WalletDaoTest
 * No. of Methods : 25
 * Purpose :Test cases to Check the Methods that are implemented
 * 
 * Author : Narmatha
 * Date of Creation : 04-August-2018
 * 
 * Last Modification Date : 04-August-2018
 *
 */
public class WalletDaoTest {
	
	@Before
	public void testException()throws WalletException{
		
	}
	
	@After
	public void testException1()throws WalletException{
		
	}
	
	
	WalletServiceImpl service= new WalletServiceImpl();
	/*@Before
	public void init() {
	service = new WalletServiceImpl();
	}
*/

	@Test
	public void testInvalidAccount(){
		Wallet wallet=new Wallet();
		wallet.setMobileNo("1238");
		wallet.setName("banu");
		wallet.setEmailId("abcd12345@gmail.com");
		wallet.setBalance(0);
		try {
			assertFalse(service.validateAccount(wallet));
			service.createAccount(wallet);
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	/*@Test
	public void testCreateAccount(){
		Wallet wallet=new Wallet();
		
		wallet.setMobileNo("6666666666");
		wallet.setName("Ravi");
		wallet.setEmailId("ravi@gmail.com");
		wallet.setBalance(5000.0);
			try {
				String s=service.createAccount(wallet);
				assertNotNull(s);
			} catch (WalletException e) {
						

			}
	
	}*/
	@Test
	public void testCreateAccountForInvalidCustomerName(){
		Wallet wallet=new Wallet();
		wallet.setMobileNo("7788665544");
		wallet.setName("banu234");
		wallet.setEmailId("abcd12345@gmail.com");
		wallet.setBalance(1000.0);
		try {
			assertFalse(service.validateAccount(wallet));
			service.createAccount(wallet);
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testCreateAccountForCustomerNameNull(){
		Wallet wallet=new Wallet();
		wallet.setMobileNo("7788665544");
		wallet.setName("");
		wallet.setEmailId("abcd12345@gmail.com");
		wallet.setBalance(1000.0);
		try {
			assertFalse(service.validateAccount(wallet));
			service.createAccount(wallet);
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testCreateAccountForInvalidMobileNo(){
		Wallet wallet=new Wallet();
		wallet.setMobileNo("778866");
		wallet.setName("Ramya");
		wallet.setEmailId("ramya12345@gmail.com");
		wallet.setBalance(1000.0);
		try {
			assertFalse(service.validateAccount(wallet));
			service.createAccount(wallet);
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testCreateAccountForValidMobileNo(){
		Wallet wallet=new Wallet();
		wallet.setMobileNo("8866557744");
		wallet.setName("Sushma");
		wallet.setEmailId("sushma@gmail.com");
		wallet.setBalance(1000.0);
		try {
			assertTrue(service.validateAccount(wallet));
			service.createAccount(wallet);
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testCreateAccountForInvalidEmailId(){
		Wallet wallet=new Wallet();
		wallet.setMobileNo("7788665533");
		wallet.setName("Ramya");
		wallet.setEmailId("ramya12345@1234gmail.com");
		wallet.setBalance(1000.0);
		try {
			assertFalse(service.validateAccount(wallet));
			service.createAccount(wallet);
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testCreateAccountForValidEmailId(){
		Wallet wallet=new Wallet();
		wallet.setMobileNo("7788665522");
		wallet.setName("Geetha");
		wallet.setEmailId("geetha@gmail.com");
		wallet.setBalance(2000.0);
		try {
			assertFalse(service.validateAccount(wallet));
			service.createAccount(wallet);
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testCreateAccountForInvalidBalance(){
		Wallet wallet=new Wallet();
		wallet.setMobileNo("7788665533");
		wallet.setName("Ramya");
		wallet.setEmailId("ramya12345@gmail.com");
		wallet.setBalance(0);
		try {
			assertFalse(service.validateAccount(wallet));
			service.createAccount(wallet);
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testCreateAccountForValidBalance(){
		Wallet wallet=new Wallet();
		wallet.setMobileNo("9876543210");
		wallet.setName("Hema");
		wallet.setEmailId("hema@gmail.com");
		wallet.setBalance(3000.0);
		try {
			assertFalse(service.validateAccount(wallet));
			service.createAccount(wallet);
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testShowBalanceForInvalidMobileNo(){
		Wallet wallet=new Wallet();
		wallet.setMobileNo("2345");
		try {
			service.showBalance(wallet.getMobileNo());
		} catch (WalletException e) {
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}
	
	
	@Test
	public void testShowBalanceForMobileNoExist(){
		Wallet wallet=new Wallet();
		wallet.setMobileNo("8888888888");
		try {
			service.showBalance(wallet.getMobileNo());
		} catch (WalletException e) {
			
			System.out.println(e.getMessage());
			
		}
	}
	
	@Test
	public void testDepositForInvalidMobileNo(){
		Wallet wallet=new Wallet();
		wallet.setMobileNo("2345");
		try {
			service.deposit("2345",0);
		} catch (WalletException e) {
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}
	
	
	@Test
	public void testDepositForMobileNoExist(){
		Wallet wallet=new Wallet();
		wallet.setMobileNo("8888888888");
		try {
			service.deposit(wallet.getMobileNo(),500.0);
			//assertSame(5000.0,service.deposit(wallet.getMobileNo(),500.0));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	
	@Test
	public void testDepositInvalidAmount(){
		Wallet wallet=new Wallet();
		wallet.setMobileNo("8888888888");
		try {
			service.deposit(wallet.getMobileNo(),-500.0);
		} catch (WalletException e) {
			assertEquals("Invalid amount",e.getMessage());
		}
	}
	
	@Test
	public void testDepositAmount(){
		Wallet wallet=new Wallet();
		wallet.setMobileNo("8888888888");
		try {
			wallet=service.deposit(wallet.getMobileNo(),500.0);
			assertNotNull(wallet);
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testWithdrawForInvalidMobileNo(){
		Wallet wallet=new Wallet();
		wallet.setMobileNo("2345");
		try {
			service.withdrawAmount("2345",0);
		} catch (WalletException e) {
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}
	
	@Test
	public void testWithdrawInvalidAmount(){
		Wallet wallet=new Wallet();
		wallet.setMobileNo("8888888888");
		try {
			service.withdrawAmount(wallet.getMobileNo(),-500.0);
		} catch (WalletException e) {
			assertEquals("Withdraw amount is invalid",e.getMessage());
		}
	}
	
	@Test
	public void testWithdrawValidAmount(){
		Wallet wallet=new Wallet();
		wallet.setMobileNo("8888888888");
		try {
			service.withdrawAmount(wallet.getMobileNo(),500.0);
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testWithdrawForMobileNoExist(){
		Wallet wallet=new Wallet();
		wallet.setMobileNo("8888888888");
		try {
			wallet=service.withdrawAmount(wallet.getMobileNo(),500.0);
			assertNotNull(wallet);
			
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}

	
	@Test
	public void testFundTransferForInvalidMobileNo(){
		Wallet wallet=new Wallet();
		wallet.setMobileNo("2345");
		Wallet wallet1=new Wallet();
		wallet1.setMobileNo("3456");
		try {
			service.fundTransfer(wallet.getMobileNo(),wallet1.getMobileNo(),0);
		} catch (WalletException e) {
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}
	
	@Test
	public void testFundTransferForMobileNoExist(){
		Wallet wallet=new Wallet();
		wallet.setMobileNo("6666666666");
		Wallet wallet1=new Wallet();
		wallet1.setMobileNo("8888888888");
		try {
			service.fundTransfer(wallet.getMobileNo(),wallet1.getMobileNo(),500.0);
			assertNotNull(wallet);
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testFundTransferInvalidAmount(){
		Wallet wallet=new Wallet();
		wallet.setMobileNo("6666666666");
		Wallet wallet1=new Wallet();
		wallet1.setMobileNo("8888888888");
		try {
			service.fundTransfer(wallet.getMobileNo(),wallet1.getMobileNo(),-500.0);
		} catch (WalletException e) {
			assertEquals("Invalid amount",e.getMessage());
		}
	}
	
	@Test
	public void testFundTransferValidAmount(){
		Wallet wallet=new Wallet();
		wallet.setMobileNo("6666666666");
		Wallet wallet1=new Wallet();
		wallet1.setMobileNo("8888888888");
		try {
			service.fundTransfer(wallet.getMobileNo(),wallet1.getMobileNo(),500.0);
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testPrintTransaction(){
		Wallet wallet=new Wallet();
		wallet.setMobileNo("8888888888");
		
		try {
			wallet=service.printTransaction(wallet.getMobileNo());
			System.out.println(wallet);
			assertNotNull(wallet);
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
		
	}

}
