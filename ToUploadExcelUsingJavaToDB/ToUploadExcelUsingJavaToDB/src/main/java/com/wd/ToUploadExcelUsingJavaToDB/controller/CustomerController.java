package com.wd.ToUploadExcelUsingJavaToDB.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wd.ToUploadExcelUsingJavaToDB.domain.Customer;
import com.wd.ToUploadExcelUsingJavaToDB.service.CustomerService;

@RestController
@RequestMapping("customers")
public class CustomerController {

	@Autowired	
	private CustomerService customerService ;
	
	@PostMapping("/upload-customer-data")
	public ResponseEntity<?> uploadCustomersData(@RequestParam("file") MultipartFile file){
		customerService.saveCustomersToDB(file);
		return ResponseEntity
				.ok(Map.of("Message", "Customers Data Uploaded and saved to database sucessfully")) ;
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> getCustomers(){
		return new ResponseEntity<>(customerService.getCustomers(),HttpStatus.FOUND) ;
	}
	
}
