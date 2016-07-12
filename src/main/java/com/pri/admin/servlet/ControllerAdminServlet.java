package com.pri.admin.servlet;

import java.io.IOException

;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.pri.dao.PetDao;
//import com.pri.servlet.util.Pet;





@WebServlet (urlPatterns = {"/Insert","/Hurry"})
public class ControllerAdminServlet extends HttpServlet {
	PetDao dao;
	public ControllerAdminServlet()
	{
		dao= new PetDao();
	}
	
	
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		

	String uri = request.getRequestURI();

			
		
	
		 if(uri.endsWith("Insert"))
		{
			String petname = request.getParameter("petname");
			String breed = request.getParameter("breed");
			String color= request.getParameter("color");
			String petid = request.getParameter("petid");
			
			String errorMsg = null;
			
			if(petname  == null || petname.equals("")){
				errorMsg = "Petname can't be null or empty.";
			}
			if(breed == null || breed.equals("")){
				errorMsg = "Breed can't be null or empty.";
			}
			if(color == null || color.equals("")){
				errorMsg = "Color can't be null or empty.";
			}
			if(petid == null || petid.equals("")){
				errorMsg = "Petid can't be null or empty.";
			}
			
			
			if(errorMsg != null){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/Login.jsp");
				PrintWriter out= response.getWriter();
				out.println("<font color=red>"+errorMsg+"</font>");
				rd.include(request, response);
			}
			else{
				
			Connection con = (Connection) getServletContext().getAttribute("DBConnection");
			PreparedStatement ps = null;
			try {
				ps = con.prepareStatement("insert into Pet(petname,breed,color,petid) values (?,?,?,?)");
				ps.setString(1, petname);
				ps.setString(2, breed);
				ps.setString(3, color);
				ps.setInt(4, Integer.parseInt(petid));
				ps.execute();
				System.out.println("inserted");
				 
				
				
				
				//forward to login page to login
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/WelcomeAdmin.jsp");
				PrintWriter out= response.getWriter();
				out.println("<font color=green>Inserted in Pet successful, please login below.</font>");
				rd.include(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
				
				throw new ServletException("DB Connection problem.");
			}finally{
				try {
					ps.close();
				} catch (SQLException e) {
					
				}
			}
			
		}
	}
		
		else  if(uri.endsWith("Hurry"))
		{
			int petid = Integer.parseInt(request.getParameter("petid"));
			Connection con = (Connection) getServletContext().getAttribute("DBConnection");
			PreparedStatement ps = null;
			try {
				
				ps = con.prepareStatement("delete from Pet where petid=?");
				ps.setInt(1, petid);
				System.out.println(petid);
				ps.executeUpdate();
				System.out.println("Deleted !!!");
				RequestDispatcher view12 = request.getRequestDispatcher("/WEB-INF/views/WelcomeAdmin.jsp");
				
		         PrintWriter out= response.getWriter();
				out.println("<font color=red>Deletion successful.Please Click on View</font>");
				view12.include(request, response);
			}catch (SQLException e)
			{
				e.printStackTrace();
				
				throw new ServletException("DB Connection problem.");
			}finally{
				try {
					ps.close();
				} catch (SQLException e) { e.printStackTrace();
					
				}
			}
			
		}
	
	
}
}


