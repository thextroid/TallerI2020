package com.taller1.spring_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
/*import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;*/
import org.springframework.web.bind.annotation.RestController;

import com.taller1.spring_1.manager.MateriasManger;
import com.taller1.spring_1.model.Materias;


@RestController
public class ControladorMaterias {
	
	@Autowired
	MateriasManger materiasManager;
	
	/*@RequestMapping("/ejemploTaller1")
	public String primerMetodo(){
		return "HOLA MUNDO - TALLER 1 - GESTION 2020";
	}
*/
	
	
	//>>>>>MetodoListar  GET
	@GetMapping("/api/listaMaterias/{xestado}")
	public List<Materias> listaAlumnos(Model model, @PathVariable("xestado") String xestado){
		int  xmat = Integer.parseInt(xestado);
		List<Materias> lisMat = this.materiasManager.listaMaterias(xmat);
		return lisMat;
	}
	//>>>>>MetodoListar  GET
	@GetMapping("/api/listaMateriasTodo")
	public List<Materias> listamat(Model model){
		
		List<Materias> lisMat = this.materiasManager.listaMateriasTodo();
		return lisMat;
	}
	
	//>>>>>MetodoAdicionanar POST
	@PostMapping("/api/addMaterias")
	public int guardandoMaterias(@RequestBody Materias ma){
		try {
			int  rest1 = this.materiasManager.setAddMaterias(ma.sigla,ma.nombre, ma.nivel,1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 2;
	}
	//>>>>>MetodoModificar PUT
	@PutMapping("/api/modMaterias")
	public Materias modificarAlumnos (@RequestBody Materias ma){
		System.out.println("Proceso de Modificacion de la materia........... -> "+ma.getNivel());
			int  rest1 = this.materiasManager.setModMaterias(ma.sigla, ma.nombre, ma.nivel);
		return ma;
	}
	
	
	//>>>>>MetodoEliminar  DELETE  (FISICAMENTE) 
	@DeleteMapping("/api/delMateria/{sigla}")
	public int eliminarMaterias(@PathVariable("sigla") String xsigla){
		int  rest = this.materiasManager.setDelMaterias(xsigla);
		return 3;
	}
	
	
	//>>>>>MetodoEliminar  DELETE  (logicamente) setEliminacionLogicaMat
	
	@PutMapping("/api/modEstadoMa11/{sigla}")
	public int modificarAlumnos11 (@PathVariable("sigla") String xsigla){
		System.out.println("Proceso de Eliminacion Logica............de  -> "+xsigla);
	
			int  rest1 = this.materiasManager.setEliminacionLogicaMat1(xsigla);
		return 5;
	}

	//_____________________________________________
	
	@DeleteMapping("/api/modEstadoMa1/{sigla}")
	public int modificarAlumnos1(@PathVariable("sigla") String xsigla){
		int  rest = this.materiasManager.setEliminacionLogicaMat1(xsigla);
		return 9;
	}
	
	@DeleteMapping("/api/modEstadoMa2/{sigla}")
	public int modificarAlumnos2(@PathVariable("sigla") String xsigla){
		int  rest = this.materiasManager.setEliminacionLogicaMat2(xsigla);
		return 9;
	}
	
	
	
}
