package com.fetchrewards.validations;

import org.springframework.stereotype.Service;

@Service
public class SoftwareVersionNumberValidation {
	
	public SoftwareVersionNumberValidation(){
		
	}
	
	//method to validate the input string
	public boolean invalid(String s) {
		boolean flag = false;
		if(s.length() == 0) {
			flag = true;
		}
		char c[] = s.toCharArray();
		for(int i=0; i<c.length;i++) {
			if(i==0 && c[i] == '.') {
				flag = true;
			}
			if(i == c.length-1 && c[i] == '.') {
				flag = true;
			}
			else if(c[i] == '.' && c[i+1] == '.') {
				flag = true;
			}
			else if(!Character.isDigit(c[i])) {
				if(c[i] == '.') {
					continue;
				}
				else
					flag = true;
			}
		}
		
		return flag;
	}
}
