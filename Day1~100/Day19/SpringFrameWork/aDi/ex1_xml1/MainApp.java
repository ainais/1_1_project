package ex1_xml1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		//================================================
		// 0. POJO
		/*
		MessageBean bean1 = new MessageBeanKoImpl();
		bean1.sayHello("홍길동");
		
		MessageBean bean2 = new MessageBeanEnImpl();
		bean2.sayHello("John");
		*/
		//================================================
		// 1. DI => default가 singleton
		ApplicationContext context = new ClassPathXmlApplicationContext("ex1_xml1/applicationContext.xml");
		System.out.println("-------------Start-------------");
		//MessageBean b1 = (MessageBean)context.getBean("ko");
		MessageBean b1 = context.getBean("ko",MessageBean.class);
		b1.sayHello("홍길자");
		System.out.println("-------------Start-------------");
		MessageBean b2 = context.getBean("en",MessageBean.class);
		b2.sayHello("John");
		MessageBean b3 = context.getBean("en",MessageBean.class);
		b3.sayHello("Ann");
	}// end of main

}
