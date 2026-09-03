package com.electricitybill.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.electricitybill.model.Person;

public class PersonDao {

	private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Person getPersonByName(String name) {

        String sql = "SELECT * FROM personsdetails WHERE name = ?";

        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(Person.class),
                name
        );
    }

    public Person getPersonByServiceNumber(String serviceNumber) {

        String sql = "SELECT * FROM personsdetails WHERE serviceNumber = ?";

        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(Person.class),
                serviceNumber
        );
    }

    public Person getPersonById(int id) {

        String sql = "SELECT * FROM personsdetails WHERE id = ?";

        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(Person.class),
                id
        );
    }

    public Person getPersonByConsumedUnits(int consumedUnits) {

        String sql = "SELECT * FROM personsdetails WHERE consumedUnits = ?";

        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(Person.class),
                consumedUnits
        );
    }
    
}
