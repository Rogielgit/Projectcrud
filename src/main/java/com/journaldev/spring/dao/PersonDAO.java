package com.journaldev.spring.dao;

import com.journaldev.spring.model.Person;
import org.hibernate.SessionFactory;

import java.util.List;


//metodos que serão implementado

public interface PersonDAO {

	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPersons();
	public Person getPersonById(int id);
	public void removePerson(int id);
	public void setSessionFactory(SessionFactory sf);
}
