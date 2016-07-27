<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>  <!-- Register page  -->
</head>
<body>
<h2>Provide information in all the fields </h2>
<form action="Register" method="post">
<table>
<tbody>
<tr><td><label>Owner Name :</label></td><td><input type="text" name="ownername"  size=35></td><td>
<tr><td><label>Address: </label></td><td><input type="text" name="address" size=35></td><td>
<tr><td><label>NumPets: </label></td><td><input type="text" name="numpets" size =35></td><td>
<tr><td><label>Phone: </label></td><td><input type="text" name="phone" size =35></td><td>
<tr><td><label>Breed (Husky / Mastiff) </label></td><td><input type="text" name="breed" size=35></td><td>
<tr><td><label>Id: </label></td><td><input type="text" name="ownerid"  size=35></td><td>
<tr><td><label>Username: </label></td><td><input type="text" name="UserName"  size=35></td><td>
<tr><td><label>Password: </label></td><td><input type="password" name="Password" size=35></td><td>
<input type="submit" value="Register" name ="Register">
</tbody>
</table>
 </form>
<h3 style="background-color:blue;color:blue;">c</h3>
<h2>Dear user to delete details please mention Owner Id</h2>   <!-- Delete Owner -->
<form action ="Delete" method ="post">
<table>
<tbody>
<tr><td><label>Owner ID :</label></td><td><input type ="text" name="ownerid" size=35></td><td>
<input type ="submit" value ="Delete" width="48" height="48">
</tbody>
</table>
</form>
If you are registered user, please <a href="login">login</a>.
<div class="div-wrapper">
<img src="images/2group_dogs.png" align =right width ="500" height ="500"/>
</div>
</body>
</html>

