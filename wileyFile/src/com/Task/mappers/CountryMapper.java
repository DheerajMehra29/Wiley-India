package com.Task.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.Task.models.Country;

public class CountryMapper implements RowMapper<Country>{

	@Override
	public Country mapRow(ResultSet result, int rowNum) throws SQLException {
		Country country = new Country();
		country.setCode(result.getString(1));
		country.setName(result.getString(2));
		country.setContinent(result.getString(3));
		country.setRegion(result.getString(4));
		country.setSurfaceArea(result.getFloat(5));
		country.setIndepYear(result.getInt(6));
		country.setPopulation(result.getInt(7));
		country.setLifeExpectancy(result.getFloat(8));
		country.setGnp(result.getFloat(9));
		country.setGnpOld(result.getFloat(10));
		country.setLocalName(result.getString(11));
		country.setGovernmentForm(result.getString(12));
		country.setHeadOfState(result.getString(13));
		country.setCapital(result.getInt(14));
		country.setCode2(result.getString(15));
		return country;
	}

}
