package com.pri.servlet.util;

import java.io.Serializable;

public class DogOwner implements Serializable{       // Owner Class
private static final long serialVersionUID = 6297385302078200511L;
	private String oname;
	private String address;
	private int numpets;
	private String phone;
	private String breed;
	private int ownerid;
	private String uname;
	private String password;
	
	public DogOwner()
	{
		
	}
	
	public DogOwner(String n, String address,int numpets, String ph, String breed,int ownerid,String uname, String password)
	{
		this.oname = n;
		this.address= address;
		this.numpets= numpets;
		this.phone= ph;
		this.breed= breed;
		this.ownerid=ownerid;
		this.uname = uname;
		this.password= password;
		
	}
	
	public void setOwnerName(String oname) {
		this.oname= oname;
	}
	public void setUserName(String uname) {
		this.uname= uname;
	}
	public void setPassword(String password) {
		this.password= password;
	}
	public void setAddress(String address) {
		this.address= address;
	}
	public void setNumPets(int numpets) {
		this.numpets= numpets;
	}
	public void setPhone(String phone) {
		this.phone= phone;
	}
	
	public void setBreed(String breed) {
		this.breed= breed;
	}
	public void setOwnerId(int ownerid) {
		this.ownerid= ownerid;
	}
	public String getUserName() {
		return uname;
	}
	public String getPassword() {
		return password;
	}
	public String getOwnerName() {
		return oname;
	}
	public String getAddress() {
		return address;
	}
	public int getNumPets() {
		return numpets;
	}
	public String getPhone() {
		return phone;
	}
	public String getBreed() {
		return breed;
	}
	public int getOwnerId() {
		return ownerid;
	}
}
