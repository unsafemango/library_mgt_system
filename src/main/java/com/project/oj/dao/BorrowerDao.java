package com.project.oj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.project.oj.beans.Borrower;

public class BorrowerDao {
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(Borrower b) {
		String sql = "insert into borrower (name, date) values("+ b.getName() + ", " + b.getDate() + ");";
		return template.update(sql);
	}
	
	public int update(Borrower b) {
		String sql = "update borrower set name = " + b.getName() + ", date = " + b.getDate() + " where id = " + b.getId() + ";";
		return template.update(sql);
	}
	
	public int delete(int id) {
		String sql = "delete from borrower where id = " + id + ";";
		return template.update(sql);
	}
	
	public Borrower getBorrowerById(int id) {
		String sql = "select * from borrower where id = " + id + ";";
		return template.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Borrower>(Borrower.class));
	}
	
	public List<Borrower> getBorrowers(){
		return template.query("select * from borrower", new RowMapper<Borrower>() {
			public Borrower mapRow(ResultSet rs, int row) throws SQLException {
				Borrower n = new Borrower();
				n.setId(rs.getInt(1));
				n.setName(rs.getString(2));
				n.setDate(rs.getDate(3));
				return n;
			}
		});
	}
}

