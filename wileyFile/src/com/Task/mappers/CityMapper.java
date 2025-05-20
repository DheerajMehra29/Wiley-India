package com.Task.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;

import com.Task.models.City;
import com.Task.services.CountryJDBCTemplate;

public class CityMapper implements RowMapper<City>{
	AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	CountryJDBCTemplate countryJDBCTemplate =  (CountryJDBCTemplate) context.getBean("countryJDBCTemplate");
	@Override
	public City mapRow(ResultSet result, int rowNum) throws SQLException {
		City city = new City();
		city.setId(result.getInt(1));
		city.setName(result.getString(2));
		city.setCountryCode(result.getString(3));
		city.setDistrict(result.getString(4));
		city.setPopulation(result.getInt(5));
		city.setCountry(countryJDBCTemplate.getCountryDetailsByCode(city.getCountryCode()));
		return city;
	}

}
