package com.taller1.spring_1.model;

import java.util.ArrayList;
import java.util.List;

import com.taller1.spring_1.model.Menus;
//import com.taller1.spring_1.manager.MenusManager;
//import java.awt.List;
//import java.util.*;

public class Menus {
	public int codm;
	public String nombre;
	public int estado;
	
	public List<Procesos> opciones = new ArrayList<Procesos>();
	



	public List<Procesos> getOpciones() {
		return opciones;
	}
	public void setOpciones(List<Procesos> opciones) {
		this.opciones = opciones;
	}
	public int getCodm() {
		return codm;
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
	
	public void setCodm(int codm) {
		this.codm = codm;
	}
	
	
}
