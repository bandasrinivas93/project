package com.kpmg.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import com.kpmg.ServiceImpl.CustomerServiceImpl;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class OurCustomException {
	
	private static final Logger logger=LoggerFactory.getLogger(OurCustomException.class);


	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> commonexception(Exception e){
		
		logger.warn("in OurCustomException class");
		logger.info("enterd into commonexception method");
		logger.error("error message is==="+e.getMessage());
		e.printStackTrace();
		return new ResponseEntity<String>(e.getMessage()+"--custom exception--", HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler(EmployeeRelatedExceptions.class)
	public ResponseEntity<String> empRelExcep(EmployeeRelatedExceptions e){
		
		logger.warn("--entered into OurCustomException class---");
		logger.info("enterd into empRelExcep method");
		System.out.println();
		logger.error("error message is==="+e.getMessage());
		//e.printStackTrace();
		return new ResponseEntity<String>(e.getMessage()+"--custom exception--", HttpStatus.BAD_REQUEST);	
	}
}
