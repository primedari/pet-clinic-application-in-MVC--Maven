package com.pri.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpSession;
import com.pri.servlet.util.DogOwner;

@WebServlet(urlPatterns = "/login")   //Login URI
public class LoginServlet extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	try {
    	     request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		}

    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String name = request.getParameter("name");		
		String password = request.getParameter("password");
		Cookie cook = new Cookie("userid", name);   // Cookie used for user id
		cook.setMaxAge(60);       
	    String errorMsg = null;
		
	   if(name == null || name.equals(""))   // Validation check for name
		{
			errorMsg ="User Name can't be null or empty";
			request.setAttribute("errormessage", errorMsg);
			request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
		}
		else if(password == null || password.equals(""))   // Validation check for password
		{
			errorMsg = "Password can't be null or empty";
			request.setAttribute("errormessage",errorMsg);
			request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
		}
			else	{
				if(name.equals("prmed") && password.equals("password")) 
		         {
				   request.getRequestDispatcher("/WEB-INF/views/WelcomeAdmin.jsp").forward(request, response);
				} 
			else
				{
				Connection con = (Connection) getServletContext().getAttribute("DBConnection");
				PreparedStatement ps = null;
				ResultSet rs = null;
				try{	
					ps = con.prepareStatement("select * from Owner where UserName=? and Password=?"); // User Login
					ps.setString(1, name);
					ps.setString(2, password);
					rs = ps.executeQuery();
						if(rs != null){
						rs.next();
						DogOwner aMember = new DogOwner(rs.getString("ownername"), rs.getString("address"),  rs.getInt("numpets"),rs.getString("phone"),rs.getString("breed"),rs.getInt("ownerid"),rs.getString("UserName"),rs.getString("Password"));
						HttpSession session = request.getSession();
						session.setAttribute("DogOwner", aMember);
						request.getRequestDispatcher("/WEB-INF/views/Welcome.jsp").forward(request, response);
						}
						
				else{
						RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/Login.jsp");
						PrintWriter out= response.getWriter();
						out.println("<font color=red>No user found with given email id, please register first.</font>");
						rd.include(request, response);
						} 
					} 
					catch (SQLException e) 
					{
						e.printStackTrace();
						throw new ServletException("DB Connection problem.");
					}finally{
						try {
							rs.close();
							ps.close();
						} 
						catch (SQLException e) {
							
						  } 
						
					    }
				    }
			    }
	     	}
         }
	



