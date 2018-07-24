package com.cg.mypaymentapp.controllers;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.mypaymentapp.beans.Customer;
@Controller
public class URIController {
	@RequestMapping(value="/")
	public String getIndexPage() {
		return "indexPage";
	}
	@RequestMapping(value="/loginPage")
	public String getLoginPage() {
		return "loginPage";
	}
	@RequestMapping(value="/registrationPage")
	public String getRegistrationPage() {
		return "registrationPage";
	}
	@RequestMapping(value="/balancePage")
	public String getBalancePage() {
		return "balancePage";
	}
	@RequestMapping(value="/depositPage")
	public String getDepositPage() {
		return "depositPage";
	}
	@RequestMapping(value="/withdrawPage")
	public String getWithdrawPage() {
		return "withdrawPage";
	}
	@RequestMapping(value="/fundTransferPage")
	public String getFundTransferPage() {
		return "fundTransferPage";
	}
	@RequestMapping(value="/filterPage")
	public String getFilterPage() {
		return "filterPage";
	}
	@RequestMapping(value="/allCustomersPage")
	public String getAllCustomersPage() {
		return "allCustomersPage";
	}
	@ModelAttribute("customer")
	public Customer customer(){
		return new Customer();
	}
	
}
