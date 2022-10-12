package com.atguigu.spring5.collectionBean;

import java.util.List;

public class Library {
	private List<String> books;

	public void setBooks(List<String> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Library [books=" + books + "]";
	}
}
