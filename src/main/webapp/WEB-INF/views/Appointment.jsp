<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- Appointment -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Appointmnet visit details</title>
</head>
<body>
<table>
<tr>
 <!-- Visit details fields -->
<th>VisitId</th>           
<th>OwnerId</th>
<th>PetId</th>
<th>OwnerName</th>
<th>PetName</th>
<th>PetBreed</th>
</tr>
<c:forEach items="${aArray}" var="item">           
<tr>
<td>${item.visitid}</td>
<td>${item.ownerid}</td>
<td>${item.petid}</td>
<td>${item.ownername}</td>
<td>${item.petname}</td>
<td>${item.petbreed}</td>
</tr>
</c:forEach>
</table>
<h3 style="background-color:blue;color:blue;">c</h3>
<!-- Logout -->
<form action="Logout" method="post">               
<input type="submit" value="Logout" >
</form>
</body>
</html>
