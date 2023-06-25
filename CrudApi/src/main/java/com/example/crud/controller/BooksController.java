package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.entity.Books;
import com.example.crud.service.BooksService;

@RestController
public class BooksController {

	@Autowired
	private BooksService booksService;

	@PostMapping("/save")
	public void createBook(@RequestBody Books books) {
		booksService.addBook(books);
	}

	@GetMapping("/fetch")
	public List<Books> getAllBooks() {
		return booksService.fetchAllBook();
	}

	@DeleteMapping("/del/{bookid}")
	public String delBook(@PathVariable("bookid") int bookId) {
		return booksService.deleteBookById(bookId);
	}

	@PutMapping("/update/{bookId}")
	public String upBook(@PathVariable("bookId") int bookId, @RequestBody Books books) {
		booksService.updateBookById(bookId, books);
		return "Book has been updated";
	}

}
