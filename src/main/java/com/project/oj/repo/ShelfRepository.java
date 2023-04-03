package com.project.oj.repo;

import org.springframework.data.repository.CrudRepository;

import com.project.oj.shelf.Shelf;

public interface ShelfRepository extends CrudRepository<Shelf,Long> {

}
