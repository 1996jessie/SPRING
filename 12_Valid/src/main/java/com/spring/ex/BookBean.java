package com.spring.ex;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class BookBean {
	@NotEmpty(message = "제목 누락")
	private String title;
	
	@NotBlank(message = "저자 누락")
	@Length(min = 5, message = "길이 5글자 이상")
	private String author;
	
	@Size(min = 3, max = 5, message = "3~5자리")
	@Pattern(regexp = "^[0-9]+$", message = "숫자만 입력")
	private String price;
	
	@NotEmpty(message = "출판사 누락")
	private String publisher;
	
	//@NotEmpty(message = "서점 누락")
	//@NotBlank(message = "서점 누락")
	@NotNull(message = "서점 누락")
	private String bookstore;
	
	//@NotEmpty(message = "배송비 누락")
	//@NotBlank(message = "배송비 누락")
	@NotNull(message = "배송비 누락")
	private String kind;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getBookstore() {
		return bookstore;
	}

	public void setBookstore(String bookstore) {
		this.bookstore = bookstore;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
}
