package com.test2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

@RestController
public class DetailsController {
	
	@Autowired
	private EurekaClient eurekaClient;

	public DetailsController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@GetMapping(value="/details")
	public List<String> getAllDetails(){
		 List<String> s=new ArrayList<String>();
				 s.add("one");
		 s.add("two");
		 s.add("three");
		 
		return s;
	}

}
