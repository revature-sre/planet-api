package com.revature.controller;

import com.revature.models.User;
import com.revature.service.UserService;

import io.javalin.http.Context;

public class AuthenticateController {
	
	private UserService userService;

	public Object authenticate(Context ctx) {
		
		String username = ctx.formParam("username");
		String password = ctx.formParam("password");
		
		boolean success;
		
		User u = userService.getUser(username);
		if(u != null) {
			
			if(u.getPassword().equals(password)) {
				
			}
			
		} else {
			System.out.println("User does not exist!");
		}
		
		return null;
	}

}
