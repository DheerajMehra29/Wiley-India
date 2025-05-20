package com.Task;

import java.util.List;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.Task.helpers.CityHelper;
import com.Task.models.City;
import com.Task.services.CityJDBCTemplate;
import com.Task.services.CountryJDBCTemplate;

public class MainApp{
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		CityJDBCTemplate cityJDBCTemplate =  (CityJDBCTemplate) context.getBean("cityJDBCTemplate");
		CountryJDBCTemplate countryJDBCTemplate =  (CountryJDBCTemplate) context.getBean("countryJDBCTemplate");
		
		List<City> cities = cityJDBCTemplate.getCityWithMaxPopulationInParticularCountry();
		CityHelper.printAllCities(cities);
		
		System.out.println(countryJDBCTemplate.getContinentWithMaxCountries());
		/*
		int max = 0;
        String s = "";
		Map<String, List<Country>> countryList = countryJDBCTemplate.getAllCountiresInContinent();
		for (HashMap.Entry<String, List<Country>> country : countryList.entrySet()) {
            String continent = country.getKey();
            List<Country> countries = country.getValue();
            for (int i = 0; i < 5; i++) {
                System.out.println(continent + "----" + countries.get(i));
            }
            if (max < countries.size()) {
                max = countries.size();
                s = continent;
            }
            System.out.println();

        }
        System.out.println(s);
        */
		context.close();
	}
}