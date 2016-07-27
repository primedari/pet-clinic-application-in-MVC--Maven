package com.pri.admin.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.pri.dao.PetDao;
import com.pri.servlet.util.Pet;

             /* Appointment Servlet*/
             
@WebServlet (urlPatterns = {"/Appointment"})
public class AppointmentServlet extends HttpServlet {
	
	PetDao dao;
	public AppointmentServlet()
	{
		dao= new PetDao();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String uri = request.getRequestURI();
		if(uri.endsWith("Appointment"))     // URI check is performed
		{
			Connection con = (Connection) getServletContext().getAttribute("DBConnection"); // Database Connection
			PreparedStatement ps = null;
			try {
				 ArrayList<Pet> aPet= new ArrayList<Pet>();
				 ps=con.prepareStatement("select * from Pet "); //  SQl query - Select everthing from Pet table
				  ResultSet resuet =ps.executeQuery();
	            	while(resuet.next())       
	            		{
	            		 Pet aMember= new Pet(resuet.getString("petname"),resuet.getString("breed"),resuet.getString("color"),resuet.getInt("petid"));
	        	    aPet.add(aMember);  // Adding to the arraylist
	           }
					 HttpSession session = request.getSession(); // Creating Http Session
	        	     session.setAttribute("aPet", aPet);
                     RequestDispatcher rdf = getServletContext().getRequestDispatcher("/WEB-INF/views/WelcomeAdmin.jsp");
					rdf.include(request, response);         // Redirecting to Welcome Admin page
			}
catch (SQLException e)      // Catch SQl Exception
{
e.printStackTrace();

throw new ServletException("DB Connection problem.");
}finally{
try {
ps.close();    // Close DB Connection
} catch (SQLException e) { 
    e.printStackTrace();
}
}
}
	}
}

