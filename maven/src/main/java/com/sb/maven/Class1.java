package com.sb.maven;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import class1.Customer;
import class1.Employee;
import class1.Student;

public class Class1 
{
    public static void main( String[] args )
    {
    	
       ApplicationContext context = new ClassPathXmlApplicationContext("class1_config.xml");
       
       // Exercise 1
//       Student student = (Student) context.getBean("student1");
       // Exercise 2
//       Student student = (Student) context.getBean("student2");
//       Student student = (Student) context.getBean("student3");
//       System.out.println(student);
       // Exercise 3
//       	Employee employee = context.getBean("employee1", Employee.class);
//       	System.out.println(employee);
       // Exercise 4
//       Customer customer = context.getBean("customer1", Customer.class);
//       System.out.println(customer);
    }
}
