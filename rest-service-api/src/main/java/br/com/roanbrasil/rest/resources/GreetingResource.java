package br.com.roanbrasil.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
 
@Path("greetings")
public class GreetingResource {
 
	@GET
	@Path("hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String greet() {
		return "Hello World !!";
	}
}