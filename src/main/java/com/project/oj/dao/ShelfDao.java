package com.project.oj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.project.oj.beans.Shelf;

public class ShelfDao {
	JdbcTemplate template;
	
	public List<Shelf> getShelf(){
		return template.query("select * from shelf", new RowMapper<Shelf>() {
			public Shelf mapRow(ResultSet rs, int row) throws SQLException {
				Shelf s = new Shelf();
				s.setId(rs.getInt(1));
				s.setBookCount(rs.getInt(2));
				s.setFloor(rs.getString(3));
				return s;
			}
		});
	}
}
