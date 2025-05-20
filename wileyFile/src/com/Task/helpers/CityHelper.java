package com.Task.helpers;

import java.util.List;

import com.Task.models.City;


public class CityHelper {
	public static void printAllCities(List<City> cities) {
		for(City city: cities) {
			System.out.println("Id: " + city.getId());
			System.out.println("Name: " + city.getName());
			System.out.println("Country Code: " + city.getCountryCode());
			System.out.println("District: " + city.getDistrict());
			System.out.println("Population: " + city.getPopulation());
			System.out.println("Country: " + city.getCountry());
			System.out.println();
		}
	}
}
