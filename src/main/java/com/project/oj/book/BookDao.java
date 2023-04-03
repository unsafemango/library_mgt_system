package com.project.oj.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.oj.repo.BookRepository;;

@Service
@Transactional
public class BookDao {
	@Autowired BookRepository repo;
	
	
	public void save(Book b) {
		repo.save(b);
	}
	
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public Book getBookById(Long id) {
		return repo.findById(id).get();
	}
	
	public List<Book> getBooks(){
		return (List<Book>) repo.findAll();
	}
}
