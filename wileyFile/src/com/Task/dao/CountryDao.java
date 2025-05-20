package com.Task.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import com.Task.models.Country;

public interface CountryDao {
	
	public void setDataSource(DataSource dataSource);
	public void insertCountry(Country country);
	public Country getCountryDetailsByCode(String code);
	public List<Country> getAllCountries(); 
	public void updateCountryName(String code, String name);
	public void deleteCountryByCountryCode(String code);
	public String getContinentWithMaxCountries();
	public Map<String, List<Country>> getAllCountiresInContinent();
	public List<Country> getCountryListByContinentName(String continent);
}
