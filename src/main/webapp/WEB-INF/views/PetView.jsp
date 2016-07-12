<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Appointmnet visit details</title>

</head>
<body>

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


<form action="Logout" method="post">
<input type="submit" value="Logout" >
</form>
</body>
</html>