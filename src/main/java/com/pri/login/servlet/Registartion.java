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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pri.dao.DogOwnerDao;

@WebServlet (urlPatterns = {"/Register","/Delete","/Update"})
public class Registartion extends HttpServlet {
	DogOwnerDao dao;
	public Registartion()
	{
		dao= new DogOwnerDao();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 /* Delete record in Owner Table */
		String uri = request.getRequestURI();
		if(uri.endsWith("Delete"))
		{
			int ownerid = Integer.parseInt(request.getParameter("ownerid"));
			String errorMsg = null;
			if(ownerid<0 || ownerid ==0)  // Validation check
			{
				errorMsg ="Ownerid can't be zero or less";
				request.setAttribute("errormessage", errorMsg);
				request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
			}
			
			Connection con = (Connection) getServletContext().getAttribute("DBConnection");
			PreparedStatement ps = null;
			try {
				
				ps = con.prepareStatement("delete from Owner where ownerid=?");   
				ps.setInt(1, ownerid);
				System.out.println(ownerid);
				ps.executeUpdate();
				RequestDispatcher view1 = request.getRequestDispatcher("/WEB-INF/views/Register.jsp");
				System.out.println(ps);
				PrintWriter out= response.getWriter();
				out.println("<font color=red>Deletion successful.</font>");
				view1.include(request, response);
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
			
		/* Update Owner Table */
		if(uri.endsWith("Update"))
		{
		    Connection con = (Connection) getServletContext().getAttribute("DBConnection");
			PreparedStatement ps = null;
			try {
			ps = con.prepareStatement("update Owner set address=?,phone=?,numpets =? where ownerid=?");
			    String address = request.getParameter("address");
				String phone = request.getParameter("phone");
				String numpets= request.getParameter("numpets");
				String id = request.getParameter("ownerid");
				
				ps.setInt(4,Integer.parseInt(id));
				ps.setString(1, address);
				ps.setString(2, phone);
				ps.setInt(3,Integer.parseInt(numpets));
				ps.executeUpdate();
				RequestDispatcher view1 = request.getRequestDispatcher("/WEB-INF/views/Updation.jsp");
				view1.include(request, response);
			}
			catch (SQLException e)
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
		
			
		/* Insert the record in Owner and Visit Table*/
		
		else if (uri.endsWith("Register")){ 
		String ownername = request.getParameter("ownername");
		String address = request.getParameter("address");
		String numpets= request.getParameter("numpets");
		String phone = request.getParameter("phone");
		String breed = request.getParameter("breed");
		String ownerid = request.getParameter("ownerid");
		String UserName= request.getParameter("UserName");
		String Password = request.getParameter("Password");
		String errorMsg = null;
		
		if(ownername  == null || ownername.equals("")){
			errorMsg = "Ownername can't be null or empty.";
		}
		if(address == null || address.equals("")){
			errorMsg = "Address can't be null or empty.";
		}
		if(numpets == null || numpets.equals("")){
			errorMsg = "NumPets can't be null or empty.";
		}
		if(phone == null || phone.equals("")){                     //Validation check 
			errorMsg = "Phone can't be null or empty.";
		}
		if(ownerid == null || ownerid.equals("")){
			errorMsg = "Id can't be null or empty.";
		}
		if(breed == null || breed.equals("")){
			errorMsg = "breed can't be null or empty.";
		}
		if(UserName == null || breed.equals("")){
			errorMsg = "username can't be null or empty.";
		}
		if(Password == null || breed.equals("")){
			errorMsg = "password can't be null or empty.";
		}
		
		if(errorMsg != null){
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/Register.jsp");
			PrintWriter out= response.getWriter();
			out.println("<font color=black>"+errorMsg+"</font>");
			rd.include(request, response);
		}
		else{
			
		Connection con = (Connection) getServletContext().getAttribute("DBConnection");
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into Owner(ownername,address,numpets,phone,breed,ownerid,UserName,Password) values (?,?,?,?,?,?,?,?)");
			ps.setString(1, ownername);
			ps.setString(2, address);
			ps.setInt(3, Integer.parseInt(numpets));
			ps.setString(4, phone);
			ps.setString(5, breed);
			ps.setInt(6, Integer.parseInt(ownerid));
			ps.setString(7, UserName);
			ps.setString(8, Password);
			ps.execute();
			
			Cookie[] cookie = request.getCookies();     // Cookie for user id
		    for(Cookie c:cookie)			
		    if((c.getName().equals("userid") ))
			UserName= c.getValue();
			ps=con.prepareStatement("Select * from Owner where UserName =?");
			ps.setString(1, UserName);
			ResultSet rs=ps.executeQuery();
			String ownernamee= rs.getString("ownername");
			System.out.println(ownernamee);
		    int ownerrid = rs.getInt("ownerid");
		    ps=con.prepareStatement("select * from Pet where breed =?");
	         ps.setString(1, breed);
	        ResultSet rswt   = ps.executeQuery();
	        
            if(rswt!=null){ 
            while(rswt.next()){  
        		   String petname= rswt.getString("petname");
        	       String petbreed= rswt.getString("breed");
        		   int pettid= rswt.getInt("petid");
        		   ps=con.prepareStatement("insert into Visit(ownerid,petid, ownername,petname, petbreed) values(?,?,?,?,?)");
       			   ps.setInt(1, ownerrid);
       			   ps.setInt(2, pettid);
       			   ps.setString(3, ownernamee);
       			   ps.setString(4, petname);
       		       ps.setString(5, petbreed);
       		       ps.execute();
       		   	        } 
        	        }
			 RequestDispatcher rdf = getServletContext().getRequestDispatcher("/WEB-INF/views/Login.jsp");
			 rdf.include(request, response);
		         }       
        	      catch(SQLException se){
	              se.printStackTrace();
              }
		  }
     }
  }
}
	





