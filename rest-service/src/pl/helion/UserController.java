package pl.helion;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Path("users")
public class UserController {
	
	@Path("all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getUsers() throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		return mapper.writeValueAsString(UserDAO.getUsers());
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("post")
	public String post(@FormParam(value = "name") String name) {
		System.out.println(name);
		return "Server says hello " + name + "!";
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("add")
	public User addUser(@FormParam("id") int id, @FormParam("name") String name, @FormParam("password") String password, @FormParam("email") String email) {
		User user = new User(id, name, password, email);
		System.out.println(user.toString());
		UserDAO.addUser(user);
		return user;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("update/{id}")
	public String updateUserEmail(@PathParam("id") int id, @FormParam("email") String email) {
		UserDAO.updateUserEmail(id, email);
		
		return "email updated";
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("delete/{id}")
	public String deleteUser(@PathParam("id") int id) {
		UserDAO.deleteUser(id);
		return "user " + id + " deleted";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("all/hibernate")
	public List<User> getAllUsers(){
		return UserDAO.getAllUsers();
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("add/hibernate")
	public String addUserHibernate(@FormParam ("name") String name, @FormParam ("password") String password, @FormParam ("email") String email) {
		UserDAO.addUserHibernate(name, password, email);
		return "new User added to database";
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("update/hibernate/{id}")
	public String updateUserEmailHibernate(@PathParam("id") int id, @FormParam("email") String email) {
		UserDAO.updateUserEmailHibernate(id, email);
		
		return "email updated";
	}
}
