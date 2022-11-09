package com.revature.controller;

import io.javalin.Javalin;

public class RequestMapping {
	
	private static AuthenticateController auth= new AuthenticateController();
	private static PlanetController pc = new PlanetController();
	private static MoonController mc = new MoonController();
	
	public static void setupEndpoints(Javalin app) {
		
		//Authenticate user and create a session for the user
		app.post("/login", ctx -> auth.authenticate(ctx));
		
		
		
		//Get all Planets associate with the user
		app.get("/planets", ctx -> pc.getAllPlanets(ctx));
		
		//Get a planet with matching name
		app.get("/planet/{name}", ctx -> pc.getPlanetByName(ctx));
		
		//Get a planet with matching ID
		app.get("/planet/{id}", ctx -> pc.getPlanetByID(ctx));
		
		//Get moons associated with a planet
		app.get("/planet/{id}/moons", ctx -> pc.getPlanetMoons(ctx));
		
		//Get all moons
		app.get("/moons", ctx -> mc.getAllMoons(ctx));
		
		//Get a moon with matching name
		app.get("/moon/{name}", ctx -> mc.getMoonByName(ctx));
		
		//Get a moon with matching ID
		app.get("/moon/{id}", ctx -> mc.getMoonById(ctx));
		
		
		
		//Create a new planet
		app.post("/planet", ctx -> pc.createPlanet(ctx));
		
		//Create a new moon 
		app.post("/moon", ctx -> mc.createMoon(ctx));
		
		
		
		//Delete a planet and all of its moons
		app.delete("/planet/{id}", ctx -> pc.deletePlanet(ctx));
		
		//Delete a moon 
		app.delete("/moon/{id}", ctx -> mc.deleteMoon(ctx));
		
		
		
		
	}

}
