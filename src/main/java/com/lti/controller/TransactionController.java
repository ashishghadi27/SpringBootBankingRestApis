package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.RestTemplateModels.RestAccountSummaryTemplate;
import com.lti.RestTemplateModels.RestTransactionTemplate;
import com.lti.model.Transaction;
import com.lti.services.TransactionService;

@RestController
@RequestMapping(path="/transaction")
@CrossOrigin(origins="http://localhost:4200")
public class TransactionController {

	@Autowired
	private TransactionService tservice;

	public TransactionService getTservice() {
		return tservice;
	}

	public void setTservice(TransactionService tservice) {
		this.tservice = tservice;
	}

	public TransactionController(TransactionService tservice) {
		super();
		this.tservice = tservice;
	}

	public TransactionController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping(path="/createTransaction")
	private ResponseEntity<RestTransactionTemplate> createTransaction(@RequestBody Transaction transaction){
		return tservice.createTransaction(transaction);
	}
	
	@GetMapping(path="/successTransaction")
	private ResponseEntity<RestTransactionTemplate> displayTransaction(@RequestParam("transactionId") Integer transactionId ){
		return tservice.displayTransaction(transactionId);
	}
	
	@PutMapping(path="/updateBalance")
	private ResponseEntity<RestAccountSummaryTemplate> updateBalance(@RequestParam("balance") String balance, @RequestParam("accountNo") String accountNo){
		return tservice.updateBalance(balance, accountNo);
	}
	
}
