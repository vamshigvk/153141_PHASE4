
package com.cg.mypaymentapp.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transaction;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.exception.InsufficientBalanceException;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaymentapp.repo.WalletRepo;
import com.cg.mypaymentapp.repo.WalletRepo1;

@Component(value = "service")
public class WalletServiceImpl implements WalletService {
	long millis = System.currentTimeMillis();
	@Autowired
	private WalletRepo repo;
	private WalletRepo1 repo1;

	public Customer createAccount(Customer customer) {
		return repo.save(customer);
	}

	public Customer showBalance(String mobileNo) {

		if (!isValidMobile(mobileNo)) {
			throw new InvalidInputException("Invalid Mobile number");
		} else {
			Customer customer = repo.findOne(mobileNo);
			if (customer != null) {
				return customer;
			} else
				throw new InvalidInputException("account with mobile number not found ");
		}
	}

	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) {
		if (!isValidMobile(sourceMobileNo) ) {
			throw new InvalidInputException("Source Mobile number not found");
		}
		if( !isValidMobile(targetMobileNo))
		{
			throw new InvalidInputException("Target Mobile number not found");
		}
		if( !isValidAmount(amount))
		{
			throw new InvalidInputException("Please enter valid amount!!");
		}
		Customer sourceCustomer = repo.findOne(sourceMobileNo);
		Customer destCustomer = repo.findOne(targetMobileNo);

		if (sourceCustomer != null && destCustomer != null) {
			Wallet balance1 = sourceCustomer.getWallet();
			Wallet balance2 = destCustomer.getWallet();
			if (balance1.getBalance().compareTo(amount) > 0) {
				BigDecimal remainBalance = balance1.getBalance().subtract(amount);
				BigDecimal addedBalance = balance2.getBalance().add(amount);
				balance1.setBalance(remainBalance);
				balance2.setBalance(addedBalance);

				String transactionType = "Debit";
				Date date = new java.sql.Date(millis);
				//Transaction transaction1 = new Transaction(sourceMobileNo, transactionType, amount, date);
				//Transaction transaction2 = new Transaction(targetMobileNo, transactionType, amount, date);
				repo.save(sourceCustomer);
				//repo1.save(transaction1);
				//repo1.save(transaction2);
				repo.save(destCustomer);
				return sourceCustomer;
			} else {
				throw new InsufficientBalanceException("insufficient balance");

			}
		} else {
			throw new InvalidInputException("account with mobile number not found ");
		}

	}

	public Customer depositAmount(String mobileNo, BigDecimal amount) {
		if (!isValidMobile(mobileNo) ) {
			throw new InvalidInputException("mobile number not found");
		}
		if( !isValidAmount(amount))
		{
			throw new InvalidInputException("Please enter valid amount!!");
		}
		Customer cus = repo.findOne(mobileNo);
		if (cus != null) {
			Wallet balance = cus.getWallet();
			balance.setBalance(balance.getBalance().add(amount));

			String transactionType = "Debit";
			Date date = new java.sql.Date(millis);
			Transaction transaction = new Transaction(mobileNo, transactionType, amount, date);
			repo.save(cus);
			//repo1.save(transaction);
			return cus;
		} else {
			throw new InvalidInputException("account with mobile number not found ");
		}
	}

	public Customer withdrawAmount(String mobileNo, BigDecimal amount) {
		if (!isValidMobile(mobileNo) ) {
			throw new InvalidInputException(" mobile number not found");
		}
		if( !isValidAmount(amount))
		{
			throw new InvalidInputException("Please enter valid amount!!");
		}
		Customer cus = repo.findOne(mobileNo);
		if (cus != null) {
			Wallet balance = cus.getWallet();
			if (balance.getBalance().compareTo(amount) > 0) {
				BigDecimal withdrawedBalance = balance.getBalance().subtract(amount);
				balance.setBalance(withdrawedBalance);
				//BigDecimal total = cus.getWallet().getBalance();

				String transactionType = "Debit";
				Date date = new java.sql.Date(millis);
				//Transaction transaction = new Transaction(mobileNo, transactionType, amount, date);
				repo.save(cus);
				//repo1.save(transaction);
				return cus;
			} else {
				throw new InsufficientBalanceException("Insufficient balance ");
			}
		} else {
			throw new InvalidInputException("account with mobile number not found ");
		}
	}

	private boolean isValidMobile(String mobileNo) {
		if (String.valueOf(mobileNo).matches("[1-9][0-9]{9}")) {
			return true;
		} else {
			return false;
		}

	}

	private boolean isValidAmount(BigDecimal amount) {
		BigDecimal val = new BigDecimal("0");
		if (amount.compareTo(val) > 0) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isValidName(String name) {
		if (name.isEmpty()) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public ArrayList<Transaction> miniStatement(String mobileno) {
		// ArrayList<Transaction> transaction=repo.miniStatement(mobileno);
		return null;
	}

	@Override
	public ArrayList<Customer> filterAccounts(BigDecimal amount) {
		if(isValidAmount(amount))
		{
		
		return repo.filterAccounts(amount);
		}
		else throw new InvalidInputException("Amount is not valid");
		
	}

	@Override
	public ArrayList<Customer> getAllCustomers() {
		ArrayList<Customer> myList;
		myList=(ArrayList<Customer>) repo.findAll();
		return myList;
	}
	
	

}
