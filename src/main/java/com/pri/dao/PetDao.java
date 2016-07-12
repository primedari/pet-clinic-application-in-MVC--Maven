package com.pri.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pri.servlet.util.DBConnectionManager;

public class PetDao {
	Connection con;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	DBConnectionManager connection = new DBConnectionManager();
	
	

	public PetDao() {
		con = connection.getConnection();
	}

}
