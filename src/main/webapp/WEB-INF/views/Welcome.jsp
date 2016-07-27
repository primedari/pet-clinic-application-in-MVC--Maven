<%@page import="com.pri.servlet.util.DogOwner"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Home Page</title>
</head>
<body>
<%DogOwner aMember = (DogOwner) session.getAttribute("DogOwner"); %>    
Hi <%=aMember.getOwnerName() %> your details are :         <!-- User Welcome page -->
<table  id ="table1" border =1>
<tr><td>Address </td><td>: <%=aMember.getAddress() %></td></tr>
<tr><td>NumPets</td><td> : <%=aMember.getNumPets() %></td></tr>
<tr><td>Phone</td><td> : <%=aMember.getPhone() %> </td></tr>
<tr><td>Id</td><td>: <%=aMember.getOwnerId() %></td></tr>
<tr><td>UserName </td><td>: <%=aMember.getUserName() %></td></tr>
<tr><td>Password </td><td>: <%=aMember.getPassword() %></td></tr>
</table>

<h3 style="background-color:white;color:white;">c</h3>

<h2>Enter details to Update</h2>           <!-- User Update  -->
<form action="Update" method= "post">
<table id = "table2">
<tr><td>Owner ID * </td><td><input type="text" name="ownerid"></td></tr>
<tr><td>Address *:</td><td><input type="text" name="address"></td></tr>
<tr><td>Phone * :</td><td><input type="text" name="phone"></td></tr>
<tr><td>NumPets *:</td><td><input type="text" name="numpets"></td></tr>
</table>
<input type="submit" value="Update">
</form>

<h3 style="background-color:blue;color:blue;">c</h3>

<h2>Enter Owner Id to View Breed</h2>                    <!-- View Breed for Owner -->
<form action="ViewAppointment" method="post">
<table>
<tr><td>Owner ID </td><td><input type="text" name="ownerid"></td></tr>
<tr><td><input type ="submit" value="Visit"></td></tr>
</table>
</form>
<form action="Logout" method="post">
<input type="submit" value="Logout" >
</form>
<div class="div-wrapper">
<img src="images/2group_dogs.png" align =right width ="500" height ="500"/>
</div>
</body>
</html>
