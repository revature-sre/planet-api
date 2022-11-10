package com.revature.models;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Planet implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3626192425679551583L;
	
	private int id;
	private String name;
	private List<Moon> moonList;

}
