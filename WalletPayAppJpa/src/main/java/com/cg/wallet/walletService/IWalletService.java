package com.cg.wallet.walletService;

import com.cg.wallet.bean.Wallet;
import com.cg.wallet.walletException.WalletException;

public interface IWalletService {
	
	String createAccount(Wallet wallet) throws WalletException;
	double showBalance(String mobileNo) throws WalletException;
	Wallet deposit(String mobileNo,double dep)throws WalletException;
	Wallet withdrawAmount(String mobileNo,double withdraw)throws WalletException;
	boolean fundTransfer(String srcMobile,String DestMobile,double amount)throws WalletException;
	boolean validateAccount(Wallet wallet)throws WalletException;
	Wallet printTransaction(String mobile)throws WalletException;
	

}
