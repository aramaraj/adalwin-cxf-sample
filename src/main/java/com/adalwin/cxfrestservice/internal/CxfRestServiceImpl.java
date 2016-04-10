package com.adalwin.cxfrestservice.internal;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.adalwin.cxfrestservice.CxfRestService;
import com.adalwin.cxfrestservice.dao.EmployeeDao;
import com.adalwin.cxfrestservice.dao.PersonDao;
import com.adalwin.cxfrestservice.model.Person;

public class CxfRestServiceImpl implements CxfRestService 
{
	@Autowired
	private EmployeeDao employeeDao; 
	@Autowired
	private PersonDao personDao;



	@Override
	public Response getEmployeeDetail(String employeeId) 
	{
		if(employeeId == null)
		{
			return Response.status(Response.Status.BAD_REQUEST).build();
		}		
		return Response.ok(employeeDao.getEmployeeDetails(employeeId)).build();
	}
	
	
	/*@Override
	public List<Person> getPersonDetails() 
	{
		return personDao.getPersonDetailsFromDB();
	}*/
}
