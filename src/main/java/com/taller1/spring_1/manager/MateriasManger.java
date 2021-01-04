
package com.taller1.spring_1.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.taller1.spring_1.model.Materias;

@Service
public class MateriasManger {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource datasourse2){
		jdbcTemplate = new JdbcTemplate(datasourse2); 
	}
//>>>>>>>Listar_Materias  GET	
	public List<Materias> listaMaterias(int xest1){
		
		String xsql = " select sigla, nombre, nivel, estado  "
				+"  from materias   "
				+"  where estado=?"
				+"  order by nombre";
		List mat1 = this.jdbcTemplate.query(
				xsql,
				new RowMapper() {
					public Object mapRow(ResultSet rs, int rowNum)throws SQLException{
						Materias ma = new Materias();
						ma.setSigla(rs.getString("sigla"));
						ma.setNombre(rs.getString("nombre"));
						ma.setNivel(rs.getString("nivel"));
						ma.setEstado(rs.getInt("estado"));		
						return ma;
					}	
				}, new Object[] {xest1});
				
			return mat1;
	}
////>>>>>>>Listar_MateriasTODO  GET	
	public List<Materias> listaMateriasTodo(){
		
		String xsql = " select sigla, nombre, nivel, estado  "
				+"  from materias "
				+"  where estado=1 or estado=0"
				+"  order by sigla";
		
		List mat1 = this.jdbcTemplate.query(
				xsql,
				new RowMapper() {
					public Object mapRow(ResultSet rs, int rowNum)throws SQLException{
						Materias ma = new Materias();
						ma.setSigla(rs.getString("sigla"));
						ma.setNombre(rs.getString("nombre"));
						ma.setNivel(rs.getString("nivel"));
						ma.setEstado(rs.getInt("estado"));		
						return ma;
					}	
				}, new Object[] {});
				
			return mat1;
	}	
//>>>>>>>>>>METODO ADICIONAR MATERIA
	public int setAddMaterias(String xsigla, String xnombre, String xnivel, int xestado) {
		String xsql = " insert into materias(sigla, nombre, nivel, estado) values (?, ?, ?,?)";
		return this.jdbcTemplate.update(xsql, xsigla, xnombre, xnivel, xestado);
	//utilizaremos update para insertar
	}
	


//>>>>>>>>>>METODO DE MODIFICACION

	public int setModMaterias(String xsigla, String xnombre, String xnivel) {
		String xsql = "update materias "
				+"set nombre =?, nivel=? "
				+" where sigla=?";
	return this.jdbcTemplate.update(xsql, xnombre, xnivel, xsigla);
	}
//METODO DE ELIMINACION	
	public int setDelMaterias(String xsigla) {
		String xsql = " delete from materias where sigla=? ";
		return this.jdbcTemplate.update(xsql, xsigla);
		//utilizaremos update para insertar
	}		
//>>>>>>>>>>METODO DE ELIMINACION LOGICA	
	
	public int setEliminacionLogicaMat1(String xsigla) {
		String xsql = " update materias "
				+"set estado =0 "
				+" where sigla=? ";
		return this.jdbcTemplate.update(xsql, xsigla);
}
	public int setEliminacionLogicaMat2(String xsigla) {
		String xsql = " update materias "
				+"set estado =1 "
				+" where sigla=? ";
		return this.jdbcTemplate.update(xsql, xsigla);
}
	
}