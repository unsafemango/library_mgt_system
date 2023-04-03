package com.project.oj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.project.oj.beans.Book;

public class BookDao {
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(Book s) {
		String sql = "insert into book (isbn, title, year) values("+ s.getIsbn() + ", " + s.getTitle() + ", " + s.getYear() + ");";
		return template.update(sql);
	}
	
	public int update(Book s) {
		String sql = "update book set isbn = " + s.getIsbn() + ", title = " + s.getTitle() + ", year = " + s.getYear() + " where id = " + s.getId() + ";";
		return template.update(sql);
	}
	
	public int delete(int id) {
		String sql = "delete from book where id = " + id + ";";
		return template.update(sql);
	}
	
	public Book getBookById(int id) {
		String sql = "select * from book where id = " + id + ";";
		return template.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Book>(Book.class));
	}
	
	public List<Book> getBooks(){
		return template.query("select * from book", new RowMapper<Book>() {
			public Book mapRow(ResultSet rs, int row) throws SQLException {
				Book b = new Book();
				b.setId(rs.getInt(1));
				b.setIsbn(rs.getString(2));
				b.setTitle(rs.getString(3));
				b.setYear(rs.getString(4));
				return b;
			}
		});
	}
}
