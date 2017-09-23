/*
        Created by IntelliJ IDEA.
        User: rogiel
        Date: 15/09/17
        Time: 08:17
        To change this template use File | Settings | File Templates.*/

package com.journaldev.spring;

import com.journaldev.spring.model.Person;
import com.journaldev.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RequestMapping("/")
@Controller
public class PersonController {

    @Autowired
    private PersonService personService;


    //@Autowired(required = true)
//    public void setPersonService(PersonService ps) {
//        this.personService = ps;
//    }

    @RequestMapping(method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("person", new Person());
        //model.addAttribute("listPersons", this.personService.listPersons()); //this not necessary anymore
        return "person";
    }
    //For add
    @RequestMapping(method = RequestMethod.POST) // this method is called when user click in add person
    public String addPerson(@ModelAttribute("person") Person p) {

        if (p.getId() == 0 && p.getName() !="") {
            this.personService.addPerson(p);
        }
        return "redirect:/";
    }
    @RequestMapping(value = "/{id}",  method = RequestMethod.POST)
    public String removePerson(@PathVariable("id") int id, Model model) {

        System.out.println("Excluindo o usuario...");
        this.personService.removePerson(id);
        model.addAttribute("list", new Person());
        model.addAttribute("listOfPersons", this.personService.listPersons());
        return "list";

    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPerson(@PathVariable("id") int id, Model model) {

       model.addAttribute("person", this.personService.getPersonById(id));
        return "editUser";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST) // the correct is PUT
    public String editPerson(@ModelAttribute("person") Person p) {
            this.personService.updatePerson(p);
        return "redirect:/";
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listOfPerson(Model model) {
        model.addAttribute("list", new Person());
        model.addAttribute("listOfPersons", this.personService.listPersons());
        return "list";
    }
    @RequestMapping(value = "/*", method = RequestMethod.GET)
    public String ErroPage() {
        return "pageNotFound";
    }
}
