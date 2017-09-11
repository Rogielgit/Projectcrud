package com.journaldev.spring;

import com.journaldev.spring.model.Person;
import com.journaldev.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/person")
@Controller
public class PersonController {

    private PersonService personService;

    @Autowired(required = true)
    @Qualifier(value = "personService")
    public void setPersonService(PersonService ps) {
        this.personService = ps;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }

    //For add and update person both
    @RequestMapping(method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person p) {

        if (p.getId() == 0) {
            //new person, add it
            this.personService.addPerson(p);
        } else {
            //existing person, call update
            this.personService.updatePerson(p);
        }
        return "redirect:/person";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String removePerson(@PathVariable("id") int id) {

        System.out.println("Excluindo o usuario...");
        this.personService.removePerson(id);
        return "redirect:/person";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String editPerson(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }


   @RequestMapping(value = "/returnjson/{id}", method = RequestMethod.GET, headers="Accept=*/*")
   @ResponseBody
    public ResponseEntity<Person> returnJson(@PathVariable("id") int id) {

       Person  person = this.personService.getPersonById(id);
       return new ResponseEntity<Person>(person, HttpStatus.OK);
   }

}
