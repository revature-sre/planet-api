package com.revature.controller;

import com.revature.exceptions.NotLoggedInException;

import io.javalin.Javalin;

public class RequestMapping {
	
	private static AuthenticateController auth= new AuthenticateController();
	private static PlanetController pc = new PlanetController();
	private static MoonController mc = new MoonController();
	
	public static void setupEndpoints(Javalin app) {
		
		//Authenticate user and create a session for the user
		app.post("/login", ctx -> auth.authenticate(ctx));
		
		//Invalidate session
		app.post("/logout", ctx -> auth.invalidateSession(ctx));
		
		//checking for valid sessions
		app.before("/api/*", ctx -> {	
			if(!auth.verifySession(ctx)) {
				throw new NotLoggedInException();
			}});
		
		//handling the exception when a session doesn't exist
		app.exception(NotLoggedInException.class, (e,ctx) -> {
			ctx.json(e.getMessage()).status(401);
		});
		
		
		//Get all Planets associate with the user
		app.get("api/planets", ctx -> pc.getAllPlanets(ctx));
		
		//Get a planet with matching name
		app.get("api/planet/{name}", ctx -> pc.getPlanetByName(ctx));
		
		//Get a planet with matching ID
		app.get("api/planet/{id}", ctx -> pc.getPlanetByID(ctx));
		
		//Get moons associated with a planet
		app.get("api/planet/{id}/moons", ctx -> mc.getPlanetMoons(ctx));
		
		//Get all moons
		app.get("api/moons", ctx -> mc.getAllMoons(ctx));
		
		//Get a moon with matching name
		app.get("api/moon/{name}", ctx -> mc.getMoonByName(ctx));
		
		//Get a moon with matching ID
		app.get("api/moon/{id}", ctx -> mc.getMoonById(ctx));
		
		
		
		//Create a new planet, sending a JSON
		app.post("api/planet", ctx -> pc.createPlanet(ctx));
		
		//Create a new moon 
		app.post("api/moon", ctx -> mc.createMoon(ctx));
		
		
		
		//Delete a planet and all of its moons
		app.delete("api/planet/{id}", ctx -> pc.deletePlanet(ctx));
		
		//Delete a moon 
		app.delete("api/moon/{id}", ctx -> mc.deleteMoon(ctx));
		
		
		
		
	}

}
