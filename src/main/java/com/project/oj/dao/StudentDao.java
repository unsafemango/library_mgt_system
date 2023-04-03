package com.project.oj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.project.oj.beans.Student;

public class StudentDao {
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(Student s) {
		String sql = "insert into student (name, gender, dept, phone) values("+ s.getName() + ", " + s.getGender() + ", " + s.getDept() + ", " + s.getPhone() +  ");";
		return template.update(sql);
	}
	
	public int update(Student s) {
		String sql = "update student set name = " + s.getName() + ", gender = " + s.getGender() + ", dept = " + s.getDept() + ", phone = " + s.getPhone() + " where id = " + s.getId() + ";";
		return template.update(sql);
	}
	
	public int delete(int id) {
		String sql = "delete from student where id = " + id + ";";
		return template.update(sql);
	}
	
	public Student getStudentById(int id) {
		String sql = "select * from student where id = " + id + ";";
		return template.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Student>(Student.class));
	}
	
	public List<Student> getBorrowers(){
		return template.query("select * from student", new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int row) throws SQLException {
				Student s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setGender(rs.getString(3));
				s.setDept(rs.getString(4));
				s.setPhone(rs.getString(5));
				return s;
			}
		});
	}
}
