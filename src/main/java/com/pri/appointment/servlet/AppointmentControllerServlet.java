package com.pri.appointment.servlet;

import java.io.IOException;

//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pri.dao.PetDao;
import com.pri.servlet.util.VisitDao;
@WebServlet (urlPatterns = {"/ViewAppointment","/AlterAppointment"})
public class AppointmentControllerServlet extends HttpServlet 
{
	PetDao dao;
	public AppointmentControllerServlet()
	{
		dao= new PetDao();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
        String uri = request.getRequestURI();

	    if(uri.endsWith("ViewAppointment"))
			{
				 System.out.println("fist time");
					String ownerid= request.getParameter("ownerid");
					
					String errorMsg = null;
					
					if(ownerid== null || ownerid.equals(""))
					{
						errorMsg ="Ownerid can't be null or empty";
						request.setAttribute("errormessage", errorMsg);
						request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
					}

					
					else 
					{
				PreparedStatement pst = null;
				Connection con = (Connection) getServletContext().getAttribute("DBConnection");
				try
				{
					 System.out.println("Hey priyan");

				 System.out.println(ownerid);
					
				 ArrayList<VisitDao> aArray= new ArrayList<VisitDao>();
				
				pst=con.prepareStatement("select * from Visit where ownerid=?");
				pst.setInt(1, Integer.parseInt(ownerid));
            ResultSet resuet =pst.executeQuery();
          
            	while(resuet.next())
            		{
            		 VisitDao aMember= new VisitDao(resuet.getInt("visitid"),resuet.getInt("ownerid"),resuet.getInt("petid"),resuet.getString("ownername"),resuet.getString("petname"),resuet.getString("petbreed"));
					
        	         aArray.add(aMember);
                     }
				
        	     HttpSession session = request.getSession();
               session.setAttribute("aArray", aArray);
          RequestDispatcher rdf = getServletContext().getRequestDispatcher("/WEB-INF/views/Appointment.jsp");
				rdf.include(request, response);
				}
        	    catch(SQLException se)
				{se.printStackTrace();}
					}
			}
	
			 
	
}
}

	
