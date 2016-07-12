package com.pri.dao;

import java.sql.Connection
;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;

import com.pri.servlet.util.DBConnectionManager;



public class DogOwnerDao {
	
	Connection con;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	DBConnectionManager connection = new DBConnectionManager();
	
	
	
	
	public DogOwnerDao() {
		con = connection.getConnection();
	}

	

	}

