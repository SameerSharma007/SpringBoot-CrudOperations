package com.example.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.entity.Books;
import com.example.crud.repository.BooksRepository;

@Service
public class BooksService {

	@Autowired
	private BooksRepository booksRepository;

	// Create Method
	public void addBook(Books books) {
		booksRepository.save(books);
	}

	// Read Method
	public List<Books> fetchAllBook() {
		List<Books> allBooks = booksRepository.findAll();
		return allBooks;
	}

	// Update Method
	public void updateBookById(int bookId, Books books) {
		Optional<Books> books1 = booksRepository.findById(bookId);
		Books book2 = books1.get();
		book2.setBookName(books.getBookName());
		book2.setAuthor(books.getAuthor());
		book2.setPrice(books.getPrice());
		booksRepository.save(book2);
	}

	// Delete Method
	public String deleteBookById(int bookId) {
		if (booksRepository.findById(bookId).isPresent()) {
			booksRepository.deleteById(bookId);
			return "Book has been deleted";
		} else {
			return "No such book in database";
		}
	}

}
