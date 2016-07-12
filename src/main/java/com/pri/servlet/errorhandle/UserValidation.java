package com.pri.servlet.errorhandle;

public class UserValidation {
public boolean isUserValid(String user, String password){
		
		if(user.equals("prmed") && password.equals("password"))
			return true;
		return false;
	}
}
