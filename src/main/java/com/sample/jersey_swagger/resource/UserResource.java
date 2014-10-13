package com.sample.jersey_swagger.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.sample.jersey_swagger.data.UserData;
import com.sample.jersey_swagger.model.User;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponses;
import com.wordnik.swagger.annotations.ApiResponse;

@Path("/user")
@Api(value = "/user", description = "API regarding Users")
@Produces({"application/json", "application/xml"})
public class UserResource {
	UserData userData = new UserData();

	@GET
	@Path("/{userId}")
	@ApiOperation(value = "Get user by Id", notes = "Get User By Id", response = User.class)
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Invalid Id supplied"),
			@ApiResponse(code = 404, message = "User not found") 
	})
	public Response getUserById(
			@ApiParam(value = "ID of user to fetch", required = true) 
			@PathParam("userId") Long userId) throws WebApplicationException {

		User user = UserData.getUserById(userId);
		if(user != null) return Response.ok(UserData.getUserById(userId)).build();
		else return Response.status(Status.BAD_REQUEST).build();
	}
}
