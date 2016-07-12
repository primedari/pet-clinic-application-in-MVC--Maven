<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Login Form</title>
 

  

</head>
<body style ="overflow:hidden; "  bgcolor= "#0099ff" >


    <div class="login" align ="center">
       
       <h1>Pet Store Login</h1>
      <form action="/login"  method ="post">
        <p><input type="text" name="name" value="" placeholder="Enter your username" size =35></p>
        <p><input type="password" name="password" value="" placeholder="Password" size =35></p>
        <p class="submit"><input type="submit" value="Login"></p>
     
      </form>
    </div>


<form action="/login" method = "post">

<p> <font color = "red"> ${errormessage} </font> </p>
</form>
<form  action="/Register" method="post">
<br>If your a new user click
<input type ="submit" value="Register"/>
If you are registered user, please login</form>
<div class="div-wrapper">
    <img src="images/2group_dogs.png" align =right width ="500" height ="500"/>
</div>
 


</body>
</html>