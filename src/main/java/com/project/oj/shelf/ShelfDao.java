package com.project.oj.shelf;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.oj.repo.ShelfRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class ShelfDao {
	@Autowired ShelfRepository repo;
	
	
	
	public void save(Shelf s) {
		repo.save(s);
	}
	
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public Shelf getShelfById(Long id) {
		return repo.findById(id).get();
	}
	
	public List<Shelf> getShelves(){
		return (List<Shelf>) repo.findAll();
	}
}
