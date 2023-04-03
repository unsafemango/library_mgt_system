package com.project.oj.repo;

import org.springframework.data.repository.CrudRepository;

import com.project.oj.borrower.Borrower;

public interface BorrowerRepository extends CrudRepository<Borrower,Long> {

}
