package com.project.oj.borrower;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.oj.repo.BorrowerRepository;


@Service
@Transactional
public class BorrowerDao {
	@Autowired BorrowerRepository repo;
	
	
	public void save(Borrower b) {
		repo.save(b);
	}
	
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public Borrower getBorrowerById(Long id) {
		return repo.findById(id).get();
	}
	
	public List<Borrower> getBorrowers(){
		return (List<Borrower>) repo.findAll();
	}
}

