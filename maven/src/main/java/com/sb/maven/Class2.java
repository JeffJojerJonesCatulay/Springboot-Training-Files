package com.sb.maven;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import class2.Calculator;
import class2.Product;
import class2.User;

public class Class2 {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("class2_config.xml");
		// Exercise 5
//		User user = context.getBean("user1", User.class);
//		System.out.println(user);
		// Exercise 6
//		Product product = context.getBean("product1", Product.class);
//		System.out.println(product);
		// Exercise 7
		Calculator calculator = context.getBean("calculator1", Calculator.class);
		calculator.sum();
	}

}
