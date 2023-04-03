package com.project.oj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.project.oj.beans.Staff;

public class StaffDao {
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(Staff s) {
		String sql = "insert into staff (name, position) values("+ s.getName() + ", " + s.getPosition() + ");";
		return template.update(sql);
	}
	
	public int update(Staff s) {
		String sql = "update staff set name = " + s.getName() + ", date = " + s.getPosition() + " where id = " + s.getId() + ";";
		return template.update(sql);
	}
	
	public int delete(int id) {
		String sql = "delete from staff where id = " + id + ";";
		return template.update(sql);
	}
	
	public Staff getStaffById(int id) {
		String sql = "select * from staff where id = " + id + ";";
		return template.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Staff>(Staff.class));
	}
	
	public List<Staff> getBorrowers(){
		return template.query("select * from staff", new RowMapper<Staff>() {
			public Staff mapRow(ResultSet rs, int row) throws SQLException {
				Staff s = new Staff();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setPosition(rs.getString(3));
				return s;
			}
		});
	}
}
