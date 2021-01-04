package com.taller1.spring_1.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.taller1.spring_1.model.Alumnos;
import com.taller1.spring_1.model.Menus;
import com.taller1.spring_1.model.Procesos;

@Service
public class AlumnosManager {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource datasourse2){
		jdbcTemplate = new JdbcTemplate(datasourse2); 
	}
	
	public List<Alumnos> listaAlumnos(int xest1){
		String xsql = " select ru, nombre, ap, am, estado  "
				+"  from alumnos   "
				+"  where estado=?  "
				+"  order by ap,am,nombre   ";
	
		List est = this.jdbcTemplate.query(
				xsql,
				new RowMapper() {
					public Object mapRow(ResultSet rs, int rowNum)throws SQLException{
						Alumnos alu = new Alumnos();
						alu.setRu(rs.getInt("ru"));
						alu.setNombre(rs.getString("nombre"));
						alu.setAp(rs.getString("ap"));
						alu.setAm(rs.getString("am"));
						alu.setEstado(rs.getInt("estado"));
						return alu;
					}	
				}, new Object[] {xest1});
				
			return est;
	}
	
//lista menus	
	public List<Menus> listaMenus(){
		String xsql = " select codm,nombre,estado  "
				+"  from  cmenus"
				+"  where estado=1 or estado=0 "
				+"  order by codm,nombre   ";

	
		List est = this.jdbcTemplate.query(
				xsql,
				new RowMapper() {
					public Object mapRow(ResultSet rs, int rowNum)throws SQLException{
						Menus alu = new Menus();
						alu.setCodm(rs.getInt("codm"));
						alu.setNombre(rs.getString("nombre"));
						alu.setEstado(rs.getInt("estado"));
						
						return alu;
					}	
				}, new Object[] {});
				
			return est;
	}
	
	public List<Procesos> listaProcesos(int idmenu){
		String xsql = " select p.codp, p.nombre,p.enlace,p.ayuda  "
				+"  from  cprocesos p, mepro m  "
				+"  where p.codp=m.codp and m.codm=?  ";
	
		List est = this.jdbcTemplate.query(
				xsql,
				new RowMapper() {
					public Object mapRow(ResultSet rs, int rowNum)throws SQLException{
						Procesos alu = new Procesos();
						alu.setCodp(rs.getInt("codp"));
						alu.setNombre(rs.getString("nombre"));
						alu.setEnlace(rs.getString("enlace"));
						alu.setAyuda(rs.getString("ayuda"));
						return alu;
					}	
				}, new Object[] {idmenu});
				
			return est;
	}
	
//Metodo de Insercion
	public int setAddAlumnos(int xru, String xnombre, String xap, String xam, int xestado) {
		String xsql = " insert into alumnos(ru, nombre, ap, am, estado) values (?, ?, ?, ?,?)";
		return this.jdbcTemplate.update(xsql, xru, xnombre, xap, xam, xestado);
	//utilizaremos update para insertar
	}
//METODO DE ELIMINACION	
	public int setDelAlumnos(int xru) {
		String xsql = " delete from alumnos where ru=? ";
		return this.jdbcTemplate.update(xsql, xru);
	//utilizaremos update para insertar
	}
//Metodo de Insercion
	
	public int setModAlumnos(int xru, String xnombre, String xap, String xam) {
		String xsql = " update alumnos "
				+"set nombre =?, ap=?, am=? "
				+" where ru=? ";
		return this.jdbcTemplate.update(xsql, xnombre, xap, xam, xru);
//Eliminacion Logica
	}
		public int setEliminacionLogica(int xru) {
			String xsql = " update alumnos "
					+"set estado =0 "
					+" where ru=? ";
			return this.jdbcTemplate.update(xsql, xru);
	}
}