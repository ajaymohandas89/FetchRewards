package com.fetchrewards.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fetchrewards.dto.CompareObjDto;
import com.fetchrewards.model.SoftwareVersionNumber;
import com.fetchrewards.validations.SoftwareVersionNumberValidation;

@RestController
public class SoftwareVersionController {
	
	@Autowired
	SoftwareVersionNumberValidation sw;
	
	@PostMapping("/cmpVersion")
	    public ResponseEntity<?> compareVersionNumber(@Valid @RequestBody CompareObjDto obj)
	    {
			
			String s1 = obj.getS1();
			String s2 = obj.getS2();
			if(sw.invalid(s1)) {
				return new ResponseEntity("Please provide valid input parameters to compare version numbers", HttpStatus.BAD_REQUEST);
			}
			if(sw.invalid(s2)) {
				return new ResponseEntity("Please provide valid input parameters to compare version numbers", HttpStatus.BAD_REQUEST);
			}
			
			SoftwareVersionNumber v1 = new SoftwareVersionNumber(s1);
			SoftwareVersionNumber v2 = new SoftwareVersionNumber(s2);
			 while (!v1.isEmpty() || !v2.isEmpty()) {
		            int d1 = v1.next();
		            int d2 = v2.next();
		            if (d1 < d2) return new ResponseEntity("First input string is before Second input string", HttpStatus.OK);
		            if (d1 > d2) return new ResponseEntity("First input string is after Second input string", HttpStatus.OK);
		        }
			 
			 
			 return new ResponseEntity("First input string is equal to Second input string", HttpStatus.OK);  
	    }
}
