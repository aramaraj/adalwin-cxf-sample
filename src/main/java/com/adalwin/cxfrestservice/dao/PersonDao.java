package com.adalwin.cxfrestservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adalwin.cxfrestservice.model.Person;
import com.adalwin.repository.PersonRepository;

public class PersonDao 
{
	@Autowired
	PersonRepository personRepository ;
	
	
	
	public List<Person> getPersonDetailsFromDB()
	{
		
		List<Person> persons;
		personRepository.dropPersonCollection(); 
		//create person collection<br /> 
		personRepository.createPersonCollection(); 
		for(int i=0; i<20; i++) { 
			personRepository.insertPersonWithNameJohnAndRandomAge(); 
		} 
		persons=personRepository.getAllPersons(); 
		return persons;
	}
}
