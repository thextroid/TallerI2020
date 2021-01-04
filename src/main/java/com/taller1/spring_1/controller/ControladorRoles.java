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
import org.springframework.web.bind.annotation.RestController;

import com.taller1.spring_1.manager.AlumnosManager;
import com.taller1.spring_1.manager.RolesManager;
import com.taller1.spring_1.model.Alumnos;
import com.taller1.spring_1.model.Menus;
import com.taller1.spring_1.model.Procesos;
import com.taller1.spring_1.model.Roles;


@RestController
public class ControladorRoles {
	
	@Autowired
RolesManager rolesManager;
	
	
	
	
	//Lista Roles Simple

	@GetMapping("/api/roles")
	public List<Roles> listaRoles(Model model){
		
		List<Roles> lis = this.rolesManager.listaRoles();
		return lis;
	}
	
	//Lista Roles con su Menu designado de Todos
	@GetMapping("/api/rolme")
	public List<Roles> listaMenuspro2(Model model){
		
		List<Roles> lisRol = this.rolesManager.listaRoles();
	
		for (Roles rol : lisRol) {
			List<Menus> lis2 = this.rolesManager.listaMenuDelRol(rol.codr);
			rol.setOpciones(lis2);
		}
		return lisRol;
	}
	//Lista Roles con su Menu designado Depende del CodRol
	@GetMapping("/api/rolme1/{codr}")
	public List<Menus> listaMenusrol(Model model, @PathVariable("codr") int xcodr){
		
		//List<Roles> lisRol = this.rolesManager.listaRoles();
	
		//for (Roles rol : lisRol) {
			List<Menus> lis2 = this.rolesManager.listaMenuDelRol(xcodr);
			
			for (Menus men : lis2) {
				List<Procesos> lis3 = this.rolesManager.listaProcesos(men.codm);
				men.setOpciones(lis3);
			}
			//rol.setOpciones(lis2);
		//}
		return lis2;
	}
	
	
	//Lista Roles Simple
	@GetMapping("/api/rolme/{nombre}")
	public List<Menus> listaMenusrolmenu(Model model, @PathVariable("nombre") String xnombre){
		
		//List<Roles> lisRol = this.rolesManager.listaRoles();
	
		//for (Roles rol : lisRol) {
			List<Menus> lis2 = this.rolesManager.listaMenuDelRol1(xnombre);
			//rol.setOpciones(lis2);
		//}
		return lis2;
	}
	
	
	

	
	
	
	
	
/*	@GetMapping("/api/menusopc")
	public List<Menus> listaMenuspro(Model model){
		
		List<Menus> lisMen = this.alumnosManager.listaMenus();
	
		for (Menus men : lisMen) {
			List<Procesos> lis2 = this.alumnosManager.listaProcesos(men.codm);
			men.setOpciones(lis2);
		}
		return lisMen;
	}
	*/
	
	
	/*
	 * 	
	 * 	@GetMapping("/api/listaAlumnos/{xestado}")
	public List<Alumnos> listaAlumnos(Model model, @PathVariable("xestado") String xestado){
		int  xest = Integer.parseInt(xestado);
		List<Alumnos> lisAlu = this.alumnosManager.listaAlumnos(xest);
		return lisAlu;
	}
	
	@DeleteMapping("/api/delete/{ru}")
	public int eliminarAlumnos(@PathVariable("ru") int xru){
		int  rest = this.alumnosManager.setDelAlumnos(xru);
		return 3;
	}
	 * 
	 * @GetMapping("/api/menus")
	public List<Menus> listaMenus(Model model){
		
		List<Menus> lis = this.alumnosManager.listaMenus();
		return lis;
	}*/
}
