package com.wd.ToUploadExcelUsingJavaToDB.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wd.ToUploadExcelUsingJavaToDB.domain.Customer;
import com.wd.ToUploadExcelUsingJavaToDB.repository.I_CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private I_CustomerRepository customerRepository ;
	
	public void saveCustomersToDB(MultipartFile file) {
		if(ExcelUploadService.isValidExcelFile(file)) {
			try {
				List<Customer> customers = ExcelUploadService.getCustomerDataFromExcel(file.getInputStream()) ;
				customerRepository.saveAll(customers) ;
				
			} catch (IOException e) {
				throw new IllegalArgumentException("A File is not a valid excel file...") ;
			}
		}
	}
	
	public List<Customer> getCustomers(){
		return customerRepository.findAll() ;
	}
}
