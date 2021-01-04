package com.taller1.spring_1.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//import es.softtek.jwtDemo.dto.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;

import com.taller1.spring_1.manager.AlumnosManager;
import com.taller1.spring_1.manager.LoginManager;

import com.taller1.spring_1.model.Personas;
import com.taller1.spring_1.model.Menus;
import com.taller1.spring_1.model.Procesos;
import com.taller1.spring_1.model.Roles;


@RestController
public class ControladorLogin {
	
	@Autowired
LoginManager loginManager;
	

	@PostMapping("/api/login")
	public Personas Login(@RequestParam("user") String username,@RequestParam("password") String clave, HttpSession session ){
		System.out.println("llego : "+username+" clave "+clave);
		
		Personas per=new Personas();
		try {
			per = this.loginManager.getDatosPersonas(username,clave);
			//String token = getJWTToken(username); 
			System.out.println("Este es  el toke ");
			
		//	per.setToke(token);
			
			//session.setAttribute("xusuario",token);
		} catch (Exception e) {
			per = null;	
		}
		
		return per;
	}
	
	private String getJWTToken(String username) {
		String secretKey="mySecretekey";
		//List<GrantedAuthority> grateauthorities = AuthorityUtils.
		
		return "";
	}
	
	@GetMapping("/api/listaPersona/{user}/{clave}")
	public Personas ListaUnaPersona(Model model, @PathVariable("user") String user,@PathVariable("clave") String clave ){
		System.out.println("llego : "+user+"  clave "+clave);
		Personas per=new Personas();
		try {
			per = this.loginManager.getDatosPersonas(user,clave);
		} catch (Exception e) {
			per = null;	
		}

		return per;
	}

}
