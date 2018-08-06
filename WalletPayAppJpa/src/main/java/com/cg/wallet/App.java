package com.cg.wallet;

import com.cg.wallet.bean.Wallet;
import com.cg.wallet.walletException.WalletException;
import com.cg.wallet.walletService.IWalletService;
import com.cg.wallet.walletService.WalletServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       IWalletService service=new WalletServiceImpl();
       Wallet w=new Wallet();
       w.setName("Narmatha");
       w.setMobileNo("1234567890");
       w.setEmailId("dee@gmail.com");
       w.setBalance(23000);
       try {
		String m=service.createAccount(w);
		System.out.println(m);
	} catch (WalletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
}
