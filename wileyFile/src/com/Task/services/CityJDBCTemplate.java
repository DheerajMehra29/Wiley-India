package com.Task.services;

import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.Task.dao.CityDao;
import com.Task.mappers.CityMapper;
import com.Task.models.City;

public class CityJDBCTemplate implements CityDao{

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void create(City city) {
		String sql = "INSERT INTO city VALUES (?, ?, ?, ?, ?)";
		jdbcTemplateObject.update(sql, new Object[] {city.getId(), city.getName(), city.getCountryCode(), city.getDistrict(), city.getPopulation()});
		System.out.println("City " + city.getName() + "'s Record inserted successfully");
		return;
	}
	
	@Override
	public City getCityById(Integer id) {
		String sql = "SELECT * FROM city WHERE id = ?";
		City city = jdbcTemplateObject.queryForObject(sql, new Object[] {id}, new CityMapper());
		return city;
	}
	
	@Override
	public City getCityByCountryCode(String countryCode) {
		String sql = "SELECT * FROM city WHERE countryCode = ?";
		City city = jdbcTemplateObject.queryForObject(sql, new Object[] {countryCode}, new CityMapper());
		return city;
	}
	
	@Override
	public List<City> getAllCities() {
		String sql = "SELECT * FROM city LIMIT 5";
		List<City> cities = jdbcTemplateObject.query(sql, new CityMapper());
		return cities;
	}

	@Override
	public void updateCityName(Integer id, String name) {
		String sql = "UPDATE city SET name = ?";
		jdbcTemplateObject.update(sql, name);
		System.out.println("Record #" + id + "'s name updated to " + name);
		return;
	}
	
	@Override
	public void deleteCityById(Integer id) {
		String sql = "DELETE FROM city WHERE ID = ?";
		jdbcTemplateObject.update(sql, new Object[] {id});
		System.out.println("Record #" + id + " deleted");
		return;
	}

	
	@Override
	public List<City> getCityWithMaxPopulationInParticularCountry() {
        String sql = "select * from city where (countrycode, population) in (select countrycode, max(population) from city group by countrycode) limit 5";
        List<City> cities = jdbcTemplateObject.query(sql, new CityMapper());
        return cities;
	}
}
