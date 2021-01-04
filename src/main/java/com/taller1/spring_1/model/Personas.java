package com.taller1.spring_1.model;

import java.sql.Date;

public class Personas {
	public int codp;
	public String nombre;
	public String ap;
	public String am;
	public int estado;
	public Date fnac;
	public String genero;
	public String direc;
	public String celular;
	public String foto;
	public String ecivil;
	
	public String toke;
	public String login;

	public String getToke() {
		return toke;
	}
	public void setToke(String toke) {
		this.toke = toke;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public int getCodp() {
		return codp;
	}
	public void setCodp(int codp) {
		this.codp = codp;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAp() {
		return ap;
	}
	public void setAp(String ap) {
		this.ap = ap;
	}
	public String getAm() {
		return am;
	}
	public void setAm(String am) {
		this.am = am;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public Date getFnac() {
		return fnac;
	}
	public void setFnac(Date fnac) {
		this.fnac = fnac;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDirec() {
		return direc;
	}
	public void setDirec(String direc) {
		this.direc = direc;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getEcivil() {
		return ecivil;
	}
	public void setEcivil(String ecivil) {
		this.ecivil = ecivil;
	}
	
}
