package com.kpmg.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.kpmg.DTO.CustomerDTO;
import com.kpmg.Dao.CustomerRepository;
import com.kpmg.Entity.Customer;
import com.kpmg.Service.iCustomerService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements iCustomerService{
	
	@Autowired
	private CustomerRepository customerrepository;
	
	@Autowired
	private ModelMapper modelmapper;
	
	private static final Logger logger=LoggerFactory.getLogger(CustomerServiceImpl.class);


	@Override
	public ResponseEntity<CustomerDTO> save(CustomerDTO cdto) {
		logger.trace("entered into CustomerServiceImpl class save method");
		Customer cus=modelmapper.map(cdto, Customer.class);
		logger.info("converted DTO to Entity");
		try {
			logger.info("entered into try block");
			customerrepository.save(cus);
		}catch (DataAccessException e) {
			logger.info("entered into catch block");
		}
		
		return new ResponseEntity<CustomerDTO>(cdto, HttpStatus.OK);
	}


	@Override
	public ResponseEntity<CustomerDTO> getbyid( @PathVariable Integer id) {

		CustomerDTO customerdto = null;
		   Optional<Customer> customer =  customerrepository.findById(id);
		    if( customer.isPresent())
		     {
		        Customer cus =  customer.get();
		        customerdto	 =  	modelmapper.map(cus,CustomerDTO .class);
		     }
		return  new ResponseEntity<CustomerDTO>( customerdto,HttpStatus.OK);  	
	
	}


	@Override
	public ResponseEntity<CustomerDTO> getByall() {
		
		 List<CustomerDTO>customerdto = new ArrayList<>();
		 CustomerDTO customerdto1 = null;
	     List<Customer>cus =   customerrepository.findAll();
	     
	    	     for (Customer customer : cus) {
	    	    	 customerdto1  =  modelmapper.map(cus,CustomerDTO.class);
			
		}
	   
	    
		return  new ResponseEntity<CustomerDTO>( customerdto1,HttpStatus.OK);
		
		
				
	}


	@Override
	public ResponseEntity<CustomerDTO> deleteByall() {
	
		
		customerrepository.deleteById(2);
		
	return new ResponseEntity<CustomerDTO>(HttpStatus.OK);
	}


	@Override
	public ResponseEntity<CustomerDTO> update(@Valid CustomerDTO cdto) {
		
		return null;
	}




}
