package com.cg.wallet.walletService;


import java.time.LocalDateTime;



import com.cg.wallet.bean.Wallet;
import com.cg.wallet.walletDao.IWalletDao;
import com.cg.wallet.walletDao.WalletDao;
import com.cg.wallet.walletException.WalletException;

/**
 * 
 * Class name : WalletServiceImpl
 * No. of Methods : 10
 * Purpose :To implement the Service of Wallet
 * 
 * Author : Narmatha
 * Date of Creation : 04-August-2018
 * 
 * Last Modification Date : 04-August-2018
 *
 */

public class WalletServiceImpl implements IWalletService {
	
	
	IWalletDao walletDao=new WalletDao();

	Wallet wallet1=new Wallet();

	@Override
	public String createAccount(Wallet wallet) throws WalletException {
		if (!wallet.getMobileNo().matches("\\d{10}")) {
			throw new WalletException("Mobile number should contain 10 digits");
			}
			if (wallet.getName().isEmpty() || wallet.getName() == null) {
			throw new WalletException("Name cannot be empty");
			} else {
			if (!wallet.getName().matches("[A-Z][A-Za-z]{3,}")) {
			throw new WalletException(
			"Name should start with capital letter and should contain only alphabets");
			}
			}
			if (wallet.getBalance() < 0) {
			throw new WalletException("Balance should be greater than zero");
			}
			if (!wallet.getEmailId().matches("[a-z]+@[a-z]+\\.com")) {
			throw new WalletException("Enter valid emailid");
			}

			return walletDao.createAccount(wallet);
			}

	@Override
	public double showBalance(String mobileNo) throws WalletException {
		validateMoblieNo(mobileNo);
		return  walletDao.showBalance(mobileNo);
	}

	@Override
	public Wallet deposit(String mobileNo,double dep) throws WalletException {
		validateMoblieNo(mobileNo);
		if(dep<=0){
			throw new WalletException("Invalid amount");
		}
		
		return walletDao.deposit(mobileNo,dep);
	}
	
	@Override
	public Wallet withdrawAmount(String mobileNo, double withdraw)
			throws WalletException {
		validateMoblieNo(mobileNo);
		if(!(wallet1.getBalance()<withdraw && withdraw<=0)){
			
			return walletDao.withdrawAmount(mobileNo, withdraw);
			
		}else {
			throw new WalletException("Withdraw amount is invalid");
		}
		
	}
	
	@Override
	public boolean fundTransfer(String srcMobile, String DestMobile,
			double amount) throws WalletException {
		validateMoblieNo(srcMobile);
		validateMoblieNo(DestMobile);
		IWalletService service = new WalletServiceImpl();
		if(amount>0) {
		Wallet withdrawWallet = service.withdrawAmount(srcMobile, amount);
		Wallet depoWallet = service.deposit(DestMobile, amount);
		return true;
		}else
		return false;

	}
	
	
	private boolean validateCustomerName(String name) throws WalletException{
		
			if(!name.matches("[A-Z][A-Za-z]{3,}")){
				throw new WalletException("Name should start with a "
						+ "capital letter and should be only of alphabets");
			}else {
		
		return true;
			}
	}
	
	
	private boolean validateMoblieNo(String mobileNo) throws WalletException{
		if(!mobileNo.matches("\\d{10}")){
			throw new WalletException("Mobile number should contain 10 digits");
		}
		return true;
	}
	
	private boolean validateEmailId(String emailId)throws WalletException{
		
		if(!emailId.matches("[a-z0-9]{8,}[@][a-z]{5}\\.{1}[com]")){
			throw new WalletException("Invalid Email Id");
		}
		
		return true;
	}

	@Override
	public boolean validateAccount(Wallet wallet) throws WalletException {
		if(validateCustomerName(wallet.getName())&& validateMoblieNo(wallet.getMobileNo())
				&& validateEmailId(wallet.getEmailId())){
			return true;
		}else{
			throw new WalletException("Invalid Data");
			
		}
		
	}

	@Override
	public Wallet printTransaction(String mobile) throws WalletException {
		
		return walletDao.printTransaction(mobile);
	}

	

	

}
