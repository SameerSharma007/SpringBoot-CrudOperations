package com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.entity.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {

}
