package com.sfy.client.client1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
public class Client1Application {

	public static void main(String[] args) {
		SpringApplication.run(Client1Application.class, args);
	}
}

@RestController
class ServiceInstanceRestController{

	@Autowired
	private DiscoveryClient discoveryClient;

	public List<ServiceInstance> serviceInstanceByApplicationName(@PathVariable String applicationName){
		return this.discoveryClient.getInstances(applicationName);
		}

    @RequestMapping("/")
    public String sayHello(){
		return "hello";
		}

		}