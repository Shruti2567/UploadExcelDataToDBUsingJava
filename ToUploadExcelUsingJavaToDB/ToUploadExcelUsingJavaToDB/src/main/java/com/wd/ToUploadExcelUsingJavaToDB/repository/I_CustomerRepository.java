package com.wd.ToUploadExcelUsingJavaToDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wd.ToUploadExcelUsingJavaToDB.domain.Customer;

public interface I_CustomerRepository extends JpaRepository<Customer,Integer>{

}
