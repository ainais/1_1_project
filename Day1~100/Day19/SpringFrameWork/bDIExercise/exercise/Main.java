package exercise;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import exercise.order.domain.Customer;
import exercise.order.service.CustomerService;

public class Main {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("exercise/beans.xml");

		Customer customer = (Customer) ctx.getBean("customer");
		System.out.println(customer);
		System.out.println("-----------------------------------------------------");

		
	    CustomerService customerService =
	    (CustomerService)ctx.getBean("customerServiceImpl"); // 앞글자가 소문자가 되어 적용되므로 CustomerServiceImpl => customerServiceImpl
	    customerService.saveCustomer(customer); 
	    customerService.deleteCustomer(1);
		 

	}

}
