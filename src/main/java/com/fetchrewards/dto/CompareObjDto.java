package com.fetchrewards.dto;

import javax.validation.constraints.NotBlank;

public class CompareObjDto {
	
	@NotBlank(message = "First input parameter is mandatory")
	private String s1;
	@NotBlank(message = "Second input parameter is mandatory")
	private String s2;
	
	public CompareObjDto(String s1, String s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	public String getS1() {
		return s1;
	}

	public void setS1(String s1) {
		this.s1 = s1;
	}

	public String getS2() {
		return s2;
	}

	public void setS2(String s2) {
		this.s2 = s2;
	}
		
}
