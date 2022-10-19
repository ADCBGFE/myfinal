package com.myhome.web.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.myhome.web.book.model.BookDAO;
import com.myhome.web.book.model.BookDTO;
import com.myhome.web.book.model.RentalDTO;
import com.myhome.web.book.model.RentalRes;
import com.myhome.web.login.model.MemberDAO;
import com.myhome.web.rental.model.BookRentalDTO;

@Service
public class BookService {
	@Autowired
	private BookDAO bookDao;

	// 전체 책 목록
	public List<BookDTO> getBookList() {
		return bookDao.selectBookList();
	}

	// 책 상세정보
	public List<BookDTO> getBook(BookDTO bookDto) {
		return bookDao.selectBook(bookDto);
	}

	// 대여
	public int rentalBook(BookRentalDTO bookRentalDto) {
		return bookDao.insertRentalBook(bookRentalDto);

	}

	// 대여한 책 목록
	public List<BookRentalDTO> getBookRentalList() {
		return bookDao.selectRentalBookList();
	}

	// 반납
	public int deleteRentalBook(BookRentalDTO bookRentalDto) {
		return bookDao.deleteRentalBook(bookRentalDto);
	}
}
