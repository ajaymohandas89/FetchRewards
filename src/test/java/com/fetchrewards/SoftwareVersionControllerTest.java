package com.fetchrewards;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fetchrewards.model.SoftwareVersionNumber;
import com.fetchrewards.validations.SoftwareVersionNumberValidation;

@RunWith(SpringRunner.class)
@SpringBootTest
class SoftwareVersionControllerTest {
	
	SoftwareVersionNumber v1;
	SoftwareVersionNumber v2;
	
	@Autowired
	SoftwareVersionNumberValidation sw;
	
	String result = "equal";

	@Test
	void validInputParameterBeforeResult() {
		v1 = new SoftwareVersionNumber("1.0");
		v2 = new SoftwareVersionNumber("2.0");
		
		 while (!v1.isEmpty() || !v2.isEmpty()) {
	            int d1 = v1.next();
	            int d2 = v2.next();
	            if (d1 < d2) result = "before";
	            if (d1 > d2) result = "after";
	        }
		 assertEquals(result,"before");
	}
	
	@Test
	void validInputParameterAfterResult() {
		v1 = new SoftwareVersionNumber("2.0");
		v2 = new SoftwareVersionNumber("1.0");
		
		 while (!v1.isEmpty() || !v2.isEmpty()) {
	            int d1 = v1.next();
	            int d2 = v2.next();
	            if (d1 < d2) result = "before";
	            if (d1 > d2) result = "after";
	        }
		 assertEquals(result,"after");
	}
	
	@Test
	void invalidInputExtraDots() {
		boolean flag = sw.invalid("1..0");
		assertEquals(flag,true);
	}
	
	@Test
	void invalidInputNotDigit() {
		boolean flag = sw.invalid("1.a");
		assertEquals(flag,true);
	}
	
	@Test
	void invalidInputNull() {
		boolean flag = sw.invalid("");
		assertEquals(flag,true);
	}
	
	@Test
	void validInputParameterEqualsResult() {
		v1 = new SoftwareVersionNumber("1.0");
		v2 = new SoftwareVersionNumber("1.0");
		
		 while (!v1.isEmpty() || !v2.isEmpty()) {
	            int d1 = v1.next();
	            int d2 = v2.next();
	            if (d1 < d2) result = "before";
	            if (d1 > d2) result = "after";
	        }
		 assertEquals(result,"equal");
	}

}
