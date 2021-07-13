package ex1_xml2_ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ex1_xml2_ref/applicationContext.xml");
		System.out.println(" =================================기본");
		MemberBean m = context.getBean("member",MemberBean.class);
		m.output();
		
		MemberBean m2 = context.getBean("member2",MemberBean.class);
		m2.output();
		
		System.out.println("=================================참조형을 받아서 정의");
		
		MemberDAO dao = context.getBean("dao",MemberDAO.class);
		dao.insert();
		
		MemberDAO dao2 = context.getBean("dao2",MemberDAO.class);
		dao2.insert();
	}

}
