package com.adalwin.cxfrestservice.internal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adalwin.cxfrestservice.MongoService;
import com.adalwin.cxfrestservice.dao.PersonDao;
import com.adalwin.cxfrestservice.model.Person;
public class MongoServiceImpl implements MongoService{
	@Autowired
	private PersonDao personDao;
	
	

	@Override
	public List<Person> getPersonDetails() 
	{
		return personDao.getPersonDetailsFromDB();
	}
	

}

