package com.pri.servlet.util;

import java.io.Serializable;

public class VisitDao  implements Serializable {     //Visit Class

 private static final long serialVersionUID = 6297385302078200511L;
 private int visitid;
 private int ownerid;
 private int petid;
 private String ownername;
 private String petname;
 private String petbreed;
 
 public VisitDao()
 {
	 
 }
  public VisitDao( int visitid, int ownerid,int petid, String ownername, String petname, String petbreed)
  {
	  this.visitid= visitid;
	  this.ownerid=ownerid;
	  this.petid=petid;
	  this.ownername=ownername;
	  this.petname=petname;
	  this.petbreed= petbreed;
  }

 
  public int getOwnerid() {
	return ownerid;
}
  public String getOwnername() {
	return ownername;
}
  public String getPetbreed() {
	return petbreed;
}
  public int getPetid() {
	return petid;
}
  public String getPetname() {
	return petname;
}
  public int getVisitid() {
	return visitid;
  }
  public void setOwnerid(int ownerid) {
	this.ownerid = ownerid;
}
  public void setOwnername(String ownername) {
	this.ownername = ownername;
}
public void setPetbreed(String petbreed) {
	this.petbreed = petbreed;
}
public void setPetid(int petid) {
	this.petid = petid;
}
public void setPetname(String petname) {
	this.petname = petname;
}
public void setVisitid(int visitid) {
	this.visitid = visitid;
 }
}
