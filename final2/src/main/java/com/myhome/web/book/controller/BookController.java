package com.myhome.web.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myhome.web.book.model.BookDTO;
import com.myhome.web.book.service.BookService;
import com.myhome.web.rental.model.BookRentalDTO;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;

	// 전체 책 목록 	http://localhost:8080/web/book/list
	@GetMapping("/list")
	public List<BookDTO> getBookList() {
		return bookService.getBookList();
	}
	
	// 책 상세정보		http://localhost:8080/web/book/book?bookId=?
	@GetMapping("/book")
	public List<BookDTO> getBook(BookDTO bookDto) {
		return bookService.getBook(bookDto);
	}

	// 대여	http://localhost:8080/web/book/rental
	@PostMapping("/rental")
	public int rentalBook(@RequestBody BookRentalDTO bookRentalDto) {
		return bookService.rentalBook(bookRentalDto);
	}
		
	// 대여한 책 목록	http://localhost:8080/web/book/rentalList
	@GetMapping("/rentalList")
	public List<BookRentalDTO> getBookRentalList() {
		return bookService.getBookRentalList();
	}
	
	// 반납	http://localhost:8080/web/book/return
	@PostMapping("/return")
	public int deleteRentalBook(@RequestBody BookRentalDTO bookRentalDto) {
		return bookService.deleteRentalBook(bookRentalDto);
	}	
}
