package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.Person;
import org.hibernate.SessionFactory;


//metodos que serão implementado

public interface PersonDAO {

	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPersons();
	public Person getPersonById(int id);
	public void removePerson(int id);
	//public List<Person> listPersonsJson();
	public void setSessionFactory(SessionFactory sf);
}
