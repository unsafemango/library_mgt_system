package com.project.oj.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.oj.repo.StudentRepository;

@Service
@Transactional
public class StudentDao {
	@Autowired StudentRepository repo;
	
	
	
	public void save(Student s) {
		repo.save(s);
	}
	
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public Student getStudentById(Long id) {
		return repo.findById(id).get();
	}
	
	public List<Student> getStudents(){
		return (List<Student>) repo.findAll();
	}
}
