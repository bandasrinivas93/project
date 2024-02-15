package com.kpmg.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class CustomerDTO {
	
	
	private Integer cid;
	@NotBlank
	private String cname;
	private Double camount;
	@NotBlank
	private String clocation;
	
	

}
