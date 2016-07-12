package com.pri.servlet.util;

import java.io.Serializable;
public class Pet  implements Serializable{
	private static final long serialVersionUID = 6297385302078200511L;
	
	private String petname;
	private String breed;
	private String color;
	private int petid;
   
	
	public Pet()
	{
		
	}
	public Pet(String petname, String breed, String color, int petid )
	{
	  this.petname= petname;
	  this.breed= breed;
	  this.color=color;
	  this.petid= petid;
	  
	
	}
	
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
	this.breed= breed;
	}
	public String getColor() {
		return color;
	}
	public int getPetid() {
		return petid;
	}
	public String getPetname() {
		return petname;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	public void setPetid(int petid) {
		this.petid = petid;
	}
	public void setPetname(String petname) {
		this.petname = petname;
	}
}