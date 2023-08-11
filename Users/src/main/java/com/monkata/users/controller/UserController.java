package com.monkata.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.monkata.users.Entity.Loans;
import com.monkata.users.Entity.Users;
import com.monkata.users.Feign.LoansFeignClient;
import com.monkata.users.services.IUserService;
import com.monkata.users.services.UserServiceConfig;

import dto.Config;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class UserController {
  
	@Autowired
	UserServiceConfig config;
	
	@Autowired
	IUserService userService;
	
	
	@Autowired
	LoansFeignClient loansFeignClient;
	
	
	 @GetMapping(path="properties")
	 public Config getProperties(){
		 Config c = new Config();
		 c.setConfig(config);
		 return c;
	 }
	 
	 @PostMapping(path="")
	 public Users save(@RequestBody Users l){
		 return userService.save(l);
	 }
	 
	 @GetMapping(path="")
	 public List<Users> getUsers(){
		 return userService.findAll();
	 }
	
	 @GetMapping(path="getLoansByIdUser/{id}")
	 public List<Loans> getCustomerLoans(@PathVariable Long id){
		 return loansFeignClient.getLoansDetails(id);
	 }
	 
	 @GetMapping(path="getLoansByIdUserCB/{id}")
	 @CircuitBreaker(name="detailsForCustomerSupportApp", fallbackMethod = "myCustomDetailsFallBack")
	 public List<Loans> getCustomerLoansCB(@PathVariable Long id){
		 return loansFeignClient.getLoansDetails(id);
	 }
	 
	private List<Loans> myCustomDetailsFallBack (Long id, Throwable t){
	 return loansFeignClient.getLoansDetails(id); 
    }
	
	
//	 
//	 @GetMapping(path="customerLoansRetry/{id}")
//	 @Retry(name="detailsForCustomerSupportAppRetry", fallbackMethod = "myCustomDetailsFallBack")
//	 public List<Loans> getCustomerLoansRetry(@PathVariable Long id){
//		 return loansFeignClient.getLoansDetails(id);
//	 }
//	 
//	 private List<Loans> myCustomDetailsFallBack (Long id, Throwable t){
//		 return loansFeignClient.getLoansDetails(id); 
//	 }
//	 
//	 @GetMapping(path="customerLoansRateLimiter/{id}")
//	 @RateLimiter(name="detailsForCustomerSupportAppRateLimiter", fallbackMethod = "myCustomDetailsFallBack")
//	 public List<Loans> getCustomerLoansRateLimiter(@PathVariable Long id){
//		 return loansFeignClient.getLoansDetails(id);
//	 }
//	 
//	 @GetMapping(path="customerLoansBulkhead/{id}")
//	 @Bulkhead(name="detailsForCustomerSupportAppBh", fallbackMethod = "myCustomDetailsFallBack")
//	 public List<Loans> customerLoansBulkhead(@PathVariable Long id){
//		 return loansFeignClient.getLoansDetails(id);
//	 }

}
