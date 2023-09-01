package com.sb.maven;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import class3.Student;
import class3.beans.Employee;

public class Class3 {

	public static void main(String[] args) {
			ApplicationContext context = new ClassPathXmlApplicationContext("class3_config.xml");
			// Exercise 8 - 9
//			Student student = context.getBean("student1", Student.class);
//			System.out.println(student);
			// Exercise 10
//			Employee employee = context.getBean("employee1", Employee.class);
//			System.out.println(employee);
			// Exercise 11
			Employee employee1 = context.getBean("employee1", Employee.class);
			System.out.println(employee1.hashCode());
			
			Employee employee2 = context.getBean("employee1", Employee.class);
			System.out.println(employee2.hashCode());
	}

}
