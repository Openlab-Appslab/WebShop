package com.example.webShop;

//import com.example.webShop.Security.UserRepository;
import com.example.webShop.Product.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class WebShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebShopApplication.class, args);
		List<String> dateArray = new ArrayList<String>();
		dateArray.add("2020-03-25");
		dateArray.add("2019-01-27");
		dateArray.add("2016-03-26");
		dateArray.add("2020-02-26");
		Collections.sort(dateArray);
		System.out.println("The Object after sorting is : "
				+ dateArray);
	}
	}


