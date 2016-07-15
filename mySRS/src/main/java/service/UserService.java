package service;


import model.CourseCatalog;
import model.Professor;

public class UserService {
	public boolean login(String identity,String username,String password) {
		boolean a=false;
		if("admin".equals(identity)){
			if("123".equals(password)){
				a=true;
		}
		}else if ("student".equals(identity)){
			if(password=="student"){
				a=true;	
			}
		}else if ("professor".equals(identity)){
			if(password=="professor"){
				a=true;	
			}
		}
		return a;
	}
	
	
	public UserService(){
	
	}
	
	
	
}
