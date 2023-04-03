package com.project.oj.staff;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.oj.repo.StaffRepository;


@Service
@Transactional
public class StaffDao {
	@Autowired StaffRepository repo;

	
	public void save(Staff s) {
		repo.save(s);
	}
	
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public Staff getStaffById(Long id) {
		return repo.findById(id).get();
	}
	
	public List<Staff> getStaffs(){
		return (List<Staff>) repo.findAll();
	}
}
