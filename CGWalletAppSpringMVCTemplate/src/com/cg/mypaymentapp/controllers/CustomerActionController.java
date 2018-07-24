package com.cg.mypaymentapp.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.service.WalletService;

@Controller
public class CustomerActionController {
	@Autowired
	WalletService walletService;
	
	@RequestMapping(value="/registerCustomer")
	public ModelAndView registerCustomer(@ModelAttribute("customer")Customer customer ,  BindingResult result) {
		try {
			if(result.hasErrors())
			{
				return new ModelAndView("registrationPage");
			}
			customer=walletService.createAccount(customer);
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("errorPage");
		}
		return new ModelAndView("registrationSuccessPage", "customer", customer);
	}
	
	@RequestMapping(value="/balanceSuccessPage")
	public ModelAndView getBalance(@Valid @RequestParam("mobileNo")String mobileNo) {
		try {
			Customer customer=walletService.showBalance(mobileNo);
			return new ModelAndView("balanceSuccessPage", "customer", customer);
		} catch (Exception e) {
			return new ModelAndView("balancePage", "errorMessage", e.getMessage());
		}
	}
	
	@RequestMapping(value="/depositSuccessPage")
	public ModelAndView getDeposit(@Valid @RequestParam("mobileNo")String mobileNo, @RequestParam("wallet.balance")BigDecimal amount) {
		
		try {
			Customer customer=walletService.depositAmount(mobileNo, amount);
			return new ModelAndView("depositSuccessPage", "customer", customer);
		} catch (Exception e) {
			return new ModelAndView("depositPage","errorMessage", e.getMessage());
		}
		 
	}
	
	@RequestMapping(value="/withdrawSuccessPage")
	public ModelAndView getWithdraw(@Valid @RequestParam("mobileNo")String mobileNo, @RequestParam("wallet.balance")BigDecimal amount) {
		try {
			Customer customer=walletService.withdrawAmount(mobileNo, amount);
			return new ModelAndView("withdrawSuccessPage", "customer", customer);
		} catch (Exception e) {
			return new ModelAndView("withdrawPage","errorMessage",e.getMessage());
		}
	}

	@RequestMapping(value="/fundTransferSuccessPage")
	public ModelAndView getFundTransfer(@Valid @RequestParam("sourceMobileNo")String sourceMobileNo,@Valid @RequestParam("destinationMobileNo")String destinationMobileNo, @RequestParam("wallet.balance")BigDecimal amount) {
		try {
			Customer customer=walletService.fundTransfer(sourceMobileNo, destinationMobileNo, amount);
			return new ModelAndView("fundTransferSuccessPage", "customer", customer);
		} catch (Exception e) {
			return new ModelAndView("fundTransferPage","errorMessage",e.getMessage());
		}
	}
	@RequestMapping(value="/filterSuccessPage")
	public ModelAndView getFilter(@RequestParam("amount")BigDecimal amount) {
		try {
			ArrayList<Customer> customer=walletService.filterAccounts(amount);
			return new ModelAndView("filterSuccessPage", "customer", customer);
		} catch (Exception e) {
			return new ModelAndView("filterPage","errorMessage",e.getMessage());
		}
	}
	@RequestMapping(value="/allCustomersSuccessPage")
	public ModelAndView getAllCustomers() {
		ArrayList<Customer> customer=walletService.getAllCustomers();
		return new ModelAndView("allCustomersSuccessPage", "customer", customer);
	}
	
}
