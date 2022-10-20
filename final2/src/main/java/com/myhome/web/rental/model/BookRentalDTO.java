package com.myhome.web.rental.model;

import java.util.Objects;

public class BookRentalDTO {
	private String bookId;
	private String mbId;
	private String rtWh;
	private String rtStartTime;
	private String rtEndTime;
	
	public BookRentalDTO() {}
	
	public BookRentalDTO(String bookId, String mbId, String rtWh, String rtDdlEts, String rtStartTime, String rtEndTime) {
		this.bookId = bookId;
		this.mbId = mbId;
		this.rtWh = rtWh;
		this.rtStartTime = rtStartTime;
		this.rtEndTime = rtEndTime;
	}

	
	public String getBookId() {
		return bookId;
	}
	
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	public String getMbId() {
		return mbId;
	}
	
	public void setMbId(String mbId) {
		this.mbId = mbId;
	}
	
	public String getRtWh() {
		return rtWh;
	}
	
	public void setRtWh(String rtWh) {
		this.rtWh = rtWh;
	}
	
	public String getRtStartTime() {
		return rtStartTime;
	}
	
	public void setRtStartTime(String rtStartTime) {
		this.rtStartTime = rtStartTime;
	}
	
	public String getRtEndTime() {
		return rtEndTime;
	}
	
	public void setRtEndTime(String rtEndTime) {
		this.rtEndTime = rtEndTime;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(bookId, mbId, rtEndTime, rtStartTime, rtWh);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookRentalDTO other = (BookRentalDTO) obj;
		return Objects.equals(bookId, other.bookId) && Objects.equals(mbId, other.mbId)
				&& Objects.equals(rtEndTime, other.rtEndTime)
				&& Objects.equals(rtStartTime, other.rtStartTime) && Objects.equals(rtWh, other.rtWh);
	}

	@Override
	public String toString() {
		return "BookRentalDTO [bookId=" + bookId + ", mbId=" + mbId + ", rtWh=" + rtWh + ", rtStartTime=" + rtStartTime
				+ ", rtEndTime=" + rtEndTime + "]";
	}


}
