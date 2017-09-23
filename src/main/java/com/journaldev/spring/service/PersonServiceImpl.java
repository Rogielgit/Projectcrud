package com.journaldev.spring.service;

import com.journaldev.spring.dao.PersonDAO;
import com.journaldev.spring.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonDAO personDAO;

	//@Override
	@Transactional
	public void addPerson(Person p) {
		this.personDAO.addPerson(p);
	}

	//@Override
	@Transactional
	public void updatePerson(Person p) {
		this.personDAO.updatePerson(p);
	}

	//@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Person> listPersons() {
		return this.personDAO.listPersons();
	}

	//@Override
	@Transactional
	public Person getPersonById(int id) {
		return this.personDAO.getPersonById(id);
	}

	//@Override
	@Transactional
	public void removePerson(int id) {
		this.personDAO.removePerson(id);
	}

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}
}
