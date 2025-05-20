package com.springdemo3;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.BeansException;

public class PostProcessCountryPopulation  implements BeanPostProcessor{
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException{
		CountryPopulation obj = (CountryPopulation)bean;
		int population = obj.getPopulation();
		System.out.println("Before : " + beanName + ": " + population);
		population = ((population+500)/1000)*1000;
		obj.setPopulation(population);
		obj.setCountryName(beanName);
		//System.out.println("After Initialization : " + beanName + ": " + population);
		return bean;
	}
}
