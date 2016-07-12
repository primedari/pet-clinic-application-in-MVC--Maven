package com.pri.servlet.util;

public class Appointment {
	private int ownerid;
	private int petid;
	private int visitid;
	private String petname;
	private String ownername;
    
	
	public Appointment()
	{
		
	}
	 public Appointment(int ownerid, int petid, int visitid, String petname, String ownername,String ownerphone)
	 {
		 this.ownerid=ownerid;
		 this.petid=petid;
		 this.visitid=visitid;
		 this.petname=petname;
		 this.ownername=ownername;
		 
	 }
	 
	 public void setOwnerId(int ownerid) {
			this.ownerid=ownerid;
		}
	
	 public void setPetName(String petname) {
			this.petname= petname;
		}public void setPetId(int petid) {
			this.petid= petid;;
		}
		public void setOwnerName(String ownername) {
			this.ownername= ownername;
		
		}
		public void setVisitId(int visitid) {
			this.visitid= visitid;
		
		}


		public String getPetName() {
			return petname;
		}
		public String getOwnerName() {
			return ownername;
		}
		public int getPetId() {
			return petid;
		}
		public int getVisitId() {
			return visitid;
		}
		public int getOwnerId() {
			return ownerid;
		}

}
