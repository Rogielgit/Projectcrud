package com.journaldev.spring;


import com.journaldev.spring.dao.ConvertJson;
import com.journaldev.spring.model.Person;
import com.journaldev.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/")
@RestController
public class ControllerJson {


    @Autowired(required = true)
    @Qualifier(value = "personService")
    public void setPersonService(PersonService ps) {
        this.personService = ps;
    }

    private PersonService personService;


    @RequestMapping(value = "/returnjson/{id}", method = RequestMethod.GET)
    public ConvertJson returnJson(@PathVariable("id") int id) {

        Person person = this.personService.getPersonById(id);
        ConvertJson json = new ConvertJson(person.getId(), person.getName(),person.getCountry());
        return json;
    }
}
