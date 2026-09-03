package com.electricitybill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.electricitybill.dao.PersonDao;
import com.electricitybill.model.Person;

@Controller
public class PersonController {

	private final PersonDao personDao;

    @Autowired
    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/personsearchform";
    }

    @GetMapping("/personsearchform")
    public String searchForm(Model model) {

        model.addAttribute("person", new Person());
        return "personsearchform";
        
    }

    @PostMapping("/calculateAmount")
    public String calculateAmount(
            @ModelAttribute("person") Person person,
            Model model) {

        Person consumer = null;

        try {

            if (person.getName() != null
                    && !person.getName().trim().isEmpty()) {

                consumer =
                        personDao.getPersonByName(
                                person.getName().trim());
            }

            else if (person.getServiceNumber() != null
                    && !person.getServiceNumber().trim().isEmpty()) {

                consumer =
                        personDao.getPersonByServiceNumber(
                                person.getServiceNumber().trim());
            }

            if (consumer != null) {

                int units = consumer.getConsumedUnits();

                int charges;

                if (units <= 100) {

                    charges = units * 10;

                } else if (units <= 200) {

                    charges =
                            (100 * 10)
                            + (units - 100) * 15;

                } else if (units <= 300) {

                    charges =
                            (100 * 10)
                            + (100 * 15)
                            + (units - 200) * 20;

                } else {

                    charges =
                            (100 * 10)
                            + (100 * 15)
                            + (100 * 20)
                            + (units - 300) * 25;
                }

                model.addAttribute("person", consumer);
                model.addAttribute("electricitycharges", charges);

            }

        } catch (EmptyResultDataAccessException e) {

            model.addAttribute(
                    "error",
                    "Consumer not found in the database."
            );
        }

        return "welcome";
    }
    
}
