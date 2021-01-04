package com.taller1.spring_1.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.taller1.spring_1.model.Roles;
import com.taller1.spring_1.model.Menus;
import com.taller1.spring_1.model.Personas;

@Service
public class LoginManager {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource datasourse2){
		jdbcTemplate = new JdbcTemplate(datasourse2); 
	}
	
	
//Obtener  datos Personas 	
public Personas getDatosPersonas(String xuser, String xclave ){
	BeanPropertyRowMapper bprm = new BeanPropertyRowMapper(Personas.class);
	
	String xsql = 	"  select p.codp,p.nombre, "
					+" CASE WHEN p.am is null THEN ' 'Else p.ap END as ap, "
					+"CASE WHEN p.ap is null THEN ' 'Else p.am END as am, d.login "
					+"from cpersonas p, cdatos d   "
					+"where p.codp=d.codp " 
						+"and p.estado =1 "	
						+"and d.login =? "
						+ "and d.password=? ";
			return (Personas) jdbcTemplate.queryForObject(xsql,
					new Object[]{xuser,xclave},bprm);
	}
	


public List<Menus> listaMenuDelRol(int idrol){
		String xsql = "select p.codm, p.nombre,p.estado "
				+"   from  cmenus p, rolme m  "
				+"	 where p.codm=m.codm and m.codr=? ";
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
				}, new Object[] {idrol});
				
			return est;
	}

	public List<Menus> listaMenuDelRol1(String nombrerol){
		String xsql = "select p.codm, p.nombre,p.estado "
				+"   from  cmenus p, rolme m  "
				+"	 where p.codm=m.codm and m.nombre=? ";
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
				}, new Object[] {nombrerol});
				
			return est;
	}

	
}