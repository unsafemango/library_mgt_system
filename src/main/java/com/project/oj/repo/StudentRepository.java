package com.project.oj.repo;

import org.springframework.data.repository.CrudRepository;

import com.project.oj.student.Student;

public interface StudentRepository extends CrudRepository<Student,Long> {

}
