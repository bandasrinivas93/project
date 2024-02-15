package com.kpmg.Exception;

public class EmployeeRelatedExceptions extends Exception {
	

	// no argumented constructor
	public EmployeeRelatedExceptions() {
		super();
	}
	
	// argumented constructor
	public EmployeeRelatedExceptions(String msg) {
		super(msg);
	}
	
	// argumented constructor
	public EmployeeRelatedExceptions(String msg, Throwable t) {
		super();
	}
	
	
}
