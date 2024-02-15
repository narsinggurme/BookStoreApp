package com.bs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.DAO.BookRepository;
import com.bs.entity.Book;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	
	public void save(Book book) {
		bookRepository.save(book);
	}
	
	public List<Book> getAllBook(){
		return bookRepository.findAll();
	}

	public Book getBookById(int id) {
		return bookRepository.findById(id).get();
	}
	
	public void deleteById(int id) {
		bookRepository.deleteById(id);
	}
}
