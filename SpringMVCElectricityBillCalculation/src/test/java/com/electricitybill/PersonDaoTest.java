package com.electricitybill;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.electricitybill.dao.PersonDao;
import com.electricitybill.model.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "file:src/main/webapp/WEB-INF/spring-servlet.xml"
})
public class PersonDaoTest {

    @Autowired
    private PersonDao dao;

    @Test
    public void testGetPersonByName() {

        Person person = dao.getPersonByName("personA");

        Assert.assertEquals(1, person.getId());
        Assert.assertEquals("123-456", person.getServiceNumber());
        Assert.assertEquals(250, person.getConsumedUnits());
    }

    @Test
    public void testGetPersonByConsumedUnits() {

        Person person = dao.getPersonByConsumedUnits(500);

        Assert.assertEquals(5, person.getId());
        Assert.assertEquals("146-189", person.getServiceNumber());
        Assert.assertEquals("personE", person.getName());
        Assert.assertEquals("Female", person.getGender());
    }

    @Test
    public void testGetPersonById() {

        Person person = dao.getPersonById(5);

        Assert.assertEquals(500, person.getConsumedUnits());
        Assert.assertEquals("personE", person.getName());
        Assert.assertEquals("146-189", person.getServiceNumber());
        Assert.assertEquals("Female", person.getGender());
    }
}