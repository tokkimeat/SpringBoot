package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTest {
	
	private Coffee coffee = new Coffee();
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ioc1.xml");
		Coffee coffee = (Coffee)ac.getBean("coffee");
		System.out.println(coffee);
	}

}
