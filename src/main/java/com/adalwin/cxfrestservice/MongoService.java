package com.adalwin.cxfrestservice;


import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.adalwin.cxfrestservice.model.Person;

/**
 * 
 * @author adalwin
 * This is interface for the employee services
 *
 */
@Path("/")
public interface MongoService {
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/getPersonDetail")
	public List<Person> getPersonDetails();
		
		
	}
	


