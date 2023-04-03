package com.project.oj.repo;

import org.springframework.data.repository.CrudRepository;

import com.project.oj.book.Book;

public interface BookRepository extends CrudRepository<Book,Long> {

}
