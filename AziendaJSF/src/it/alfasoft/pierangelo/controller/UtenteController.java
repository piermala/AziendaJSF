package it.alfasoft.pierangelo.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="controller",eager=true)
@SessionScoped
public class UtenteController {


	
//	public String validaLogin(Dipendente u){
//		
//		String url = "";
//		
//		if(validaLogin(u.getUsername(), u.getPassword())){
//			
//			url = "HomepageAdmin";
//			return url;
//			
//		} else {
//			
//			return "ProvaLogin";
//			
//		}
//		
//
//	}
//	
//	
//	public boolean validaLogin(String username, String password){
//		
//		boolean valido = false;
//		
//		if (username.equals("Pier") && password.equals("Mala")){
//			valido = true;
//		}
//		
//		return valido;
//	}
	
}
