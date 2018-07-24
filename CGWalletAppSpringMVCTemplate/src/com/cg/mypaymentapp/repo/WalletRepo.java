package com.cg.mypaymentapp.repo;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.mypaymentapp.beans.Transaction;
import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.exception.InvalidInputException;

public interface WalletRepo extends JpaRepository<Customer, String>{
@Query("select c from Customer c join c.wallet w where w.balance<:amount")	
ArrayList<Customer> filterAccounts(@Param("amount")BigDecimal amount);
}
