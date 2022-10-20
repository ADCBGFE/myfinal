package com.myhome.web.book.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myhome.web.rental.model.BookRentalDTO;

@Repository
public class BookDAO {

	@Autowired
	DataSource ds;

	final int FAIL = 0;

	// 전체 책 목록
	public List<BookDTO> selectBookList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<BookDTO> bookDtoList = new ArrayList<>();

		String sql = "select * from RANTALPJ.TB_BOOK_BASE ";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BookDTO bookDto = new BookDTO();
				bookDto.setBookId(rs.getString("BOOK_ID"));
				bookDto.setBookName(rs.getString("BOOK_NAME"));
				bookDto.setBookAt(rs.getString("BOOK_AT"));
				bookDto.setBookCatg(rs.getString("BOOK_CATG"));
				bookDto.setBookImgUrl(rs.getString("BOOK_IMAGE_URL"));
				bookDto.setBookPubl(rs.getString("BOOK_PUBL"));
				bookDto.setBookCt(rs.getString("BOOK_CT"));

				bookDtoList.add(bookDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			close(rs, pstmt, conn);
		}

		return bookDtoList;
	}

	// 책 상세정보
	public List<BookDTO> selectBook(BookDTO bookDto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BookDTO> bookDtoList = new ArrayList<>();

		String sql = "select * from RANTALPJ.TB_BOOK_BASE WHERE BOOK_ID = ? "; 

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookDto.getBookId());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				bookDto.setBookId(rs.getString("BOOK_ID"));
				bookDto.setBookName(rs.getString("BOOK_NAME"));
				bookDto.setBookAt(rs.getString("BOOK_AT"));
				bookDto.setBookCatg(rs.getString("BOOK_CATG"));
				bookDto.setBookImgUrl(rs.getString("BOOK_IMAGE_URL"));
				bookDto.setBookPubl(rs.getString("BOOK_PUBL"));
				bookDto.setBookCt(rs.getString("BOOK_CT"));

				bookDtoList.add(bookDto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			close(pstmt, conn);
		}
		return bookDtoList;
	}

	// 대여
	public int insertRentalBook(BookRentalDTO bookRentalDto) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into RANTALPJ.TR_RT_BASE (BOOK_ID, MB_ID, RT_WH, RT_START_TIME) values (?, ?, 'Y', SYSDATE) ";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookRentalDto.getBookId());
			pstmt.setString(2, bookRentalDto.getMbId());

			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return FAIL;
		} finally {
			close(pstmt, conn);
		}

	}

	// 대여한 책 목록
	public List<BookRentalDTO> selectRentalBookList() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<BookRentalDTO> BookRentalDtoList = new ArrayList<>();

		String sql = "select BOOK_ID, MB_ID, RT_WH, RT_START_TIME from RANTALPJ.TR_RT_BASE ";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BookRentalDTO bookrentalDto = new BookRentalDTO();
				bookrentalDto.setBookId(rs.getString("BOOK_ID"));
				bookrentalDto.setMbId(rs.getString("MB_ID"));
				bookrentalDto.setRtWh(rs.getString("RT_WH"));
				bookrentalDto.setRtStartTime(rs.getString("RT_START_TIME"));

				BookRentalDtoList.add(bookrentalDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			close(rs, pstmt, conn);
		}

		return BookRentalDtoList;
	}

	// 반납
	public int deleteRentalBook(BookRentalDTO bookRentalDto) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "DELETE FROM RANTALPJ.TR_RT_BASE WHERE BOOK_ID = ? ";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookRentalDto.getBookId());

			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return FAIL;
		} finally {
			close(pstmt, conn);
		}

	}

	private void close(AutoCloseable... acs) { 
		for (AutoCloseable ac : acs)
			try {
				if (ac != null)
					ac.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
