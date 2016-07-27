<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.pri.servlet.util.Pet" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Admin</title>
</head>
<body>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Appointmnet visit details</title>         <!-- Admin Welcome Page -->
</head>
<h2>Welcome Admin</h2>
<form action ="Appointment" method="post">
<input type="submit" value="View">
<table>
<tr>
<th>PetName</th>
<th>Breed</th>
<th>Color</th>
<th>PetId</th>
</tr>
<c:forEach items="${aPet}" var="item">
<tr>
<td>${item.petname}</td>
<td>${item.breed}</td>
<td>${item.color}</td>
<td>${item.petid}</td>
</tr>
</c:forEach>
</table>
</form>

<h3 style="background-color:blue;color:blue;">c</h3>

<h2>Please insert  new data for Pet </h2>       <!-- Add a new Pet  -->
<form action="Insert" method="post">
<table>
<tbody>
<tr><td><label>Pet Name* : </label></td><td><input type="text" name="petname" size=35></td><td>
<tr><td><label>Breed*: </label></td><td><input type="text" name="breed" size=35></td><td>
<tr><td><label>Color *: </label></td><td><input type="text" name="color" size =35></td><td>
<tr><td><label>Pet Id*: </label></td><td><input type="text" name="petid" size=35></td><td>
<input type="submit" value="Insert">
</tbody>
</table>
</form>

<h3 style="background-color:blue;color:blue;">c</h3>

<h1> Please enter the Pet id to delete</h1>       <!-- Delete a  Pet  -->
<form action="Hurry" method="post">
<table>
<tbody>
<tr><td><label>Pet Id*: </label></td><td><input type="text" name="petid" size=35></td><td>
<input type="submit" value="Hurry" name ="Delete">
</tbody>
</table>
</form>
<form action="Logout" method="post">              <!-- Admin Logout  -->
<input type="submit" value="Logout" >
</form>
</body>
</html>
