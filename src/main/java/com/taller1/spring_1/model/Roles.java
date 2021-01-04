package com.taller1.spring_1.model;

import java.util.ArrayList;
import java.util.List;

import com.taller1.spring_1.model.Roles;
//import com.taller1.spring_1.manager.MenusManager;
//import java.awt.List;
//import java.util.*;

public class Roles {
	public int codr;
	public String nombre;
	public int estado;
	
	public List<Menus> opciones = new ArrayList<Menus>();

	public int getCodr() {
		return codr;
	}

	public void setCodr(int codr) {
		this.codr = codr;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public List<Menus> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<Menus> lis2) {
		this.opciones = lis2;
	}



	
	
	
}
