package com.Task.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.Task.dao.CountryDao;
import com.Task.mappers.CountryMapper;
import com.Task.models.Country;

public class CountryJDBCTemplate implements CountryDao {

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public Country getCountryDetailsByCode(String code) {
        String sql = "SELECT * FROM country where code = ?";
        Country country = jdbcTemplateObject.queryForObject(sql, new Object[] {code}, new CountryMapper());
        return country;
    }

	@Override
	public List<Country> getAllCountries() {
		String sql = "SELECT * FROM country";
        List<Country> countries = jdbcTemplateObject.query(sql, new CountryMapper());
        return countries;
	}
	
	@Override
	public void insertCountry(Country country) {
		String sql = "INSERT INTO country VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplateObject.update(sql, new Object[] {
				country.getCode(),
				country.getName(),
				country.getContinent(),
				country.getRegion(),
				country.getSurfaceArea(),
				country.getIndepYear(),
				country.getPopulation(),
				country.getLifeExpectancy(),
				country.getGnp(),
         		country.getGnpOld(),
         		country.getLocalName(),
         		country.getGovernmentForm(),
         		country.getHeadOfState(),
         		country.getCapital(),
         		country.getCode2()}
		);
		System.out.println("Country " + country.getName() + "'s Record inserted successfully");
		return;
	}

	@Override
	public void updateCountryName(String code, String name) {
		Country country = getCountryDetailsByCode(code);
        country.setName(name);
        String sql = "UPDATE country SET Name = ? WHERE Code = ?";
		jdbcTemplateObject.update(sql, name);
		System.out.println("Record #" + code + "'s name updated to " + name);
		return;
	}

	@Override
	public void deleteCountryByCountryCode(String code) {
		String sql = "DELETE FROM country WHERE code = ?";
		jdbcTemplateObject.update(sql, new Object[] {code});
		System.out.println("Record #" + code + " deleted");
		return;
	}

	@Override
	public String getContinentWithMaxCountries() {
		String sql = "SELECT CONTINENT FROM (SELECT COUNT(*) AS COUNT, CONTINENT FROM country GROUP BY continent ORDER BY COUNT DESC LIMIT 1) AS RESULT";
		String continent = jdbcTemplateObject.queryForObject(sql, String.class);
		return continent;
	}

	@Override
	public Map<String, List<Country>> getAllCountiresInContinent() {
		HashMap<String, List<Country>> map = new HashMap<String, List<Country>>();
        String sql = "SELECT Distinct continent FROM country";
        List<String> continents = jdbcTemplateObject.queryForList(sql, String.class);
        for(int i = 0; i < continents.size(); i++) {
        	List<Country> countries = getCountryListByContinentName(continents.get(i));
        	map.put(continents.get(i), countries);
        }
		return map;
	}

	@Override
	public List<Country> getCountryListByContinentName(String continent) {
		String sql = "SELECT * FROM country Where continent = ?";
		List<Country> countries = jdbcTemplateObject.query(sql, new Object[] {continent}, new CountryMapper());
		return countries;
	}

	
}
