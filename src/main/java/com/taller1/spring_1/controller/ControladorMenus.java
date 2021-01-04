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

//import com.taller1.spring_1.manager.AlumnosManager;
import com.taller1.spring_1.manager.MenusManager;

import com.taller1.spring_1.model.Alumnos;
import com.taller1.spring_1.model.Menus;
import com.taller1.spring_1.model.Procesos;
import com.taller1.spring_1.model.Roles;


@RestController
public class ControladorMenus {
	
	@Autowired
	MenusManager menusManager;
	
	@RequestMapping("/ejemploTaller1")
	public String primerMetodo(){
		return "HOLA MUNDO - TALLER 1 - GESTION 2020";
	}

	
	
//Lista Menus Simple (TODO)
	@GetMapping("/api/menus")
	public List<Menus> listaMenus(Model model){
		List<Menus> lis = this.menusManager.listaMenus();
		return lis;
	}
//Lista Menus con SubMenu   (TODO)
	@GetMapping("/api/menusopc")
	public List<Menus> listaMenuspro(Model model){
		
		List<Menus> lisMen = this.menusManager.listaMenus();
	
		for (Menus men : lisMen) {
			List<Procesos> lis2 = this.menusManager.listaProcesos(men.codm);
			men.setOpciones(lis2);
		}
		return lisMen;
	}
	
///DOCENTEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE-----------------	
	@GetMapping("/api/listaRoles/{login}")
	public List<Roles> listaDeRoles(Model model, @PathVariable("login") String login){
		
		List<Roles>  lisAlus = null;
		
	//	if (xsession !=null) {
			System.out.println("Entro Listar Los Roles--> "+login);

			lisAlus = this.menusManager.listaRoles(login);
		//} else {
			//System.out.println("La sesion fue cerrada");
			
		//}
		
		return lisAlus;
	}
	
	
	
	//Lista Roles Simple

	
	@GetMapping("/api/listaRolesD/{login}")
	public List<Roles> listaDeRolesD(Model model, @PathVariable("login") String login, HttpSession session){
		System.out.println();
		
		String xsession =(String) session.getAttribute("xusuario");
		List<Roles>  lisAlus = null;
		if (xsession !=null) {
			System.out.println("Entro -->");

			lisAlus = this.menusManager.listaRoles(login);
		} else {
			System.out.println("La sesion fue cerrada");
			
		}
		
		return lisAlus;
	}

	@GetMapping("/api/listaMenus/{codr}")
	public List<Menus> listaDeMenus(Model model, @PathVariable("codr") int id){
		System.out.println("leeeelego el idROLpara listar  Menu listar procesos : "+id);
		
		/*if (id==null) {
			id=0;
		}*/
		List<Menus>  lisAlus = this.menusManager.listaMenuDelRol1(id);

		for (Menus men:lisAlus) {
			List<Procesos> lisAlus2 =this.menusManager.listaProcesos(men.codm);
			men.setOpciones(lisAlus2);
		}
		return lisAlus;
	}
	
	///DOCENTEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE-----------------	
	/*@GetMapping("/api/listaRoles/{Id}")
	public List<Roles> listaDeMenus(Model model, @PathVariable("Id") String id){
		System.out.println("llego el ide : "+id);
		
		if (id==null) {
			id="0";
		}
		List<Menus>  lisAlus = this.menusManager.listaMenus(Integer.parseInt(id));

		for (Menus men:lisAlus) {
			List<Procesos> lisAlus2 =this.menusManager.listaProcesos(men.idmenu);
			men.setOpciones(lisAlus2);
		}
		return lisAlus;
	}*/
	
}
