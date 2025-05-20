package com.Task.dao;

import java.util.List;

import javax.sql.DataSource;

import com.Task.models.City;

public interface CityDao {
	public void setDataSource(DataSource dataSource);
	public void create(City city);
	public City getCityById(Integer id);
	public City getCityByCountryCode(String countryCode);
	public List<City> getAllCities(); 
	public void updateCityName(Integer id, String name);
	public void deleteCityById(Integer id);
	public List<City> getCityWithMaxPopulationInParticularCountry();
}
