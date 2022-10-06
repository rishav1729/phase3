package com.JunitProject;

public class Authentication {
	public boolean authentication(String username,String password) {
		if(username=="rishav"& password=="rishav@!999") {
			return true;
		}
		else {
			return false;
		}
	}
}
