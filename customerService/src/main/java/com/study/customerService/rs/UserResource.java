package com.study.customerService.rs;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.study.customerService.bean.User;
import com.study.customerService.dao.UserDao;

@Component
@Path("/users")
public class UserResource {

	@Autowired
	private UserDao userDao;

	@GET
	@Path("/getTextByName/{userName}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getTextByName(@PathParam("userName") String userName) {
		System.out.println("User Resource get text by name: " + userName);

		List<User> users = null;
		try {
			users = userDao.findByName(userName);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

		if (users == null || users.size() == 0) {
			return null;
		} else {
			return users.get(0).toString();
		}
	}

	@POST
	@Path("/addUser")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
	public User addUser(User user) {
		System.out.println("addUser: " + user);

		return user;
	}

}