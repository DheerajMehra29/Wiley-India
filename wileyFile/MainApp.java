package com.springdemo3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		CountryPopulation obj = (CountryPopulation) context.getBean("India");
		CountryPopulation obj1 = (CountryPopulation) context.getBean("Japan");
		System.out.println(obj.getCountryName() +": "+ obj.getPopulation());
		System.out.println(obj1.getCountryName() + ": " + obj1.getPopulation());
		context.registerShutdownHook();
		context.close();
	}
}
