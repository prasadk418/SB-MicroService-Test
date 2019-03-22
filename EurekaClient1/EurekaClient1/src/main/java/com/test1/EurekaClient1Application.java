package com.test1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClient1Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClient1Application.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	
}

@RestController
class TestController{
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
	private RestTemplate template;
	
	@GetMapping(value="getall")
	public List<String> getdetails(){
		InstanceInfo info=eurekaClient.getNextServerFromEureka("eureka-client2", false);
		//template.getForEntity(info.getHomePageUrl()+"/details");
		ResponseEntity<List> en=template.getForEntity(info.getHomePageUrl()+"/details", List.class);
		return en.getBody();
	}
}

