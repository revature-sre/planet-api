package com.revature.controller;

import com.revature.models.LoginTemplate;
import com.revature.models.User;
import com.revature.service.UserService;

import io.javalin.http.Context;

public class AuthenticateController {
	
	private UserService userService;

	
	public void authenticate(Context ctx) {
		
		LoginTemplate lt = ctx.bodyAsClass(LoginTemplate.class);
		
		User u = userService.getUser(lt.getUsername());
	
		if(u != null && u.getPassword().equals(lt.getPassword())) {
			ctx.sessionAttribute("user", u);
			ctx.status(200);
		}else {
			ctx.status(400);
		}
	}

	public void invalidateSession(Context ctx) {
		ctx.req().getSession().invalidate();
	}
	
	public boolean verifySession(Context ctx) {	
		return ctx.sessionAttribute("user") != null;
	}

}
