package com.bs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.DAO.MyBookRepository;
import com.bs.entity.MyBookList;

@Service
public class MyBookListService {
	
	@Autowired
	MyBookRepository bookRepository;
	
	
	public void saveMyBook(MyBookList book) {
		bookRepository.save(book);
	}
	
	public List<MyBookList> getAllMyBooks(){
		return bookRepository.findAll();
	}
	public void deleteById(int id) {
		
		bookRepository.deleteById(id);
	}

}
