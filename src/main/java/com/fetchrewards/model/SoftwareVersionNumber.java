package com.fetchrewards.model;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

@Component
public class SoftwareVersionNumber {
	
	private String str;
    private int index;
    
    public SoftwareVersionNumber() {
    	
    }
    
    public SoftwareVersionNumber(String str) {
        this.str = str;
        this.index = 0;
    }
    
    //check if input is empty or not
    public boolean isEmpty() { 
    	return this.index >= this.str.length(); 
    }
    
    //calculate the digits till we get a dot(.)
    public int next() {
        int result = 0;
        while (this.index < this.str.length()) {
            if (this.str.charAt(this.index) == '.') {
                this.index += 1;
                break;
            }
            result *= 10;
            result += this.str.charAt(this.index)  - '0';
            this.index += 1;
        }
        return result;
    }
}
