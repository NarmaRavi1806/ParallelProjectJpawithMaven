package com.cg.wallet.walletDao;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.cg.wallet.bean.Wallet;
import com.cg.wallet.walletException.WalletException;

/**
 * 
 * Class name : WalletDao
 * Interface : IWalletDao
 * No. of Methods : 5
 * Purpose :To access the database and retrieve values from database
 * 
 * Author : Narmatha
 * Date of Creation : 04-August-2018
 * 
 * Last Modification Date : 04-August-2018
 *
 */

public class WalletDao implements IWalletDao {
	
	
	EntityManagerFactory fact=Persistence.createEntityManagerFactory("hello");
	EntityManager em=fact.createEntityManager(); 
	@Override
	public String createAccount(Wallet wallet) throws WalletException {
		em.getTransaction().begin();
		em.persist(wallet);
		em.getTransaction().commit();
		return wallet.getMobileNo();	 


	}
	@Override
	public double showBalance(String mobileNo)
			throws WalletException {
		String q1="select w from Wallet w where w.mobileNo=?";
		TypedQuery<Wallet> query=em.createQuery(q1,Wallet.class);
		query.setParameter(1,mobileNo);
		em.find(Wallet.class, 1);
		Wallet wallet=query.getSingleResult();
		wallet.setDate(Date.valueOf(LocalDate.now()));
		if(mobileNo.equals(wallet.getMobileNo())) {
		return wallet.getBalance();
		}else {
		throw new WalletException("number doesnot exists");
		}


	}

	@Override
	public Wallet deposit(String mobileNo,double dep)
			throws WalletException {
		em.getTransaction().begin();
		String q1="select w from Wallet w where w.mobileNo=?";
		TypedQuery<Wallet> query=em.createQuery(q1,Wallet.class);
		query.setParameter(1,mobileNo);
		Wallet wallet=query.getSingleResult();
		if(wallet==null) {
		throw new WalletException("does not exists");
		}
		double d=wallet.getBalance()+dep;
		wallet.setBalance(d);
		wallet.setDate(Date.valueOf(LocalDate.now()));
		em.merge(wallet);


		em.getTransaction().commit();
		return wallet;


	}
		
	@Override
	public Wallet withdrawAmount(String mobileNo,double withdraw)
			throws WalletException {
		em.getTransaction().begin();
		String q1="select w from Wallet w where w.mobileNo=?";
		TypedQuery<Wallet> query=em.createQuery(q1,Wallet.class);
		query.setParameter(1,mobileNo);
		Wallet wallet=query.getSingleResult();
		if(wallet==null) {
		throw new WalletException("does not exists");
		}
		double d=wallet.getBalance()-withdraw;
		wallet.setBalance(d);
		wallet.setDate(Date.valueOf(LocalDate.now()));
		em.merge(wallet);


		em.getTransaction().commit();
		return wallet;

	}

	
	@Override
	public Wallet printTransaction(String mobile) throws WalletException {
		String q1="select w from Wallet w where w.mobileNo=?";
		TypedQuery<Wallet> query=em.createQuery(q1,Wallet.class);
		query.setParameter(1,mobile);
		Wallet wallet=query.getSingleResult();
		if(wallet==null) {
		return wallet;
		}else {
		throw new WalletException("number doesnot exists");
		}
		}

	
	

}
