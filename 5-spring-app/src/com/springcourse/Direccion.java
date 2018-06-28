package com.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Direccion {
	
	private String calle;
	private String cp;
	
	public Direccion() {	
	}

	public Direccion(String calle, String cp) {
		this.calle = calle;
		this.cp = cp;
	}	
	
	@Autowired
	public void setCalle(@Value("El Bueno")String calle) {
		this.calle = calle;
	}

	@Autowired
	public void setCp(@Value("1993")String cp) {
		this.cp = cp;
	}

	
	@Override
	public String toString() {
		return "Direccion [calle= " + calle +", cp="+cp+"]";
	}
	
}
