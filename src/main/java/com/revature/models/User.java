package com.revature.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1577192697981085198L;
	
	private String username;
	private String password; 
	private List<Planet> myPlanets;
	
	

}
