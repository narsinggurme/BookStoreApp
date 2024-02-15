package com.bs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bs.entity.Book;
import com.bs.entity.MyBookList;
import com.bs.service.BookService;
import com.bs.service.MyBookListService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	@Autowired
	private MyBookListService bookListService;

	@GetMapping("/")
	public String home() {
		return "Home";
	}

	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}

	@GetMapping("/available_book")
	public ModelAndView getAllBook() {
		List<Book> list = bookService.getAllBook();
		return new  ModelAndView("bookList", "book", list);
	}

	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		bookService.save(b);
		return "redirect:/available_book";
	}
	
	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBookList> list = bookListService.getAllMyBooks();
		model.addAttribute("book", list);
		return "myBooks";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b = bookService.getBookById(id);
		MyBookList mb = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
		bookListService.saveMyBook(mb);
		return "redirect:/my_books";
	}

	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id" ) int id, Model model) {
		Book b = bookService.getBookById(id);
		model.addAttribute("book", b);
		return "bookEdit";
	}
	
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		
		bookService.deleteById(id);
		return "redirect:/available_book";
		
	}
	

}
