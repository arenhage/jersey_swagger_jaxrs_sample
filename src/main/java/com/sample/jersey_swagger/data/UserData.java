package com.sample.jersey_swagger.data;
import java.util.HashMap;
import java.util.Map;

import com.sample.jersey_swagger.model.User;

public class UserData {
	static Map<Long,User> users = new HashMap<Long,User>();
	
	static {
		users.put((long) 1,createUser(1,"jd","qwerty","John","Doe","john.doe@gmail.com"));
	}
	
	public static User getUserById(long id) {
		return users.get(id);
	}

	public static User createUser(long id, String username, String password, String firstName, String lastName, String email) {
		User user = new User(id, username, firstName, lastName, email, password);
		return user;
	}
}
