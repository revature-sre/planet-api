package com.revature.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1577192697981085198L;
	
	private String username;
	private String password; 
	private List<Planet> myPlanets;
	
	
	public User() {
		super();
	}
	
	public User(String username, String password, List<Planet> myPlanets) {
		super();
		this.username = username;
		this.password = password;
		this.myPlanets = myPlanets;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Planet> getMyPlanets() {
		return myPlanets;
	}
	public void setMyPlanets(List<Planet> myPlanets) {
		this.myPlanets = myPlanets;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", myPlanets=" + myPlanets + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(myPlanets, password, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(myPlanets, other.myPlanets) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}
	
	

}
