package com.revature.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User{

	
	private String username;
	private String password; 
	private List<Planet> myPlanets;
	
	

}
