package com.recommendation.RecomendationApi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "author")
public class Author {

	@Id
	@Column(name = "author_id")
	private int authorId;

	@Column(name = "author_name")
	private String authorName;

	@OneToMany(mappedBy = "author")
	// @JsonBackReference
	@JsonIgnoreProperties("author")
	private List<Book> books;

	public Author() {

	}

	public Author(int authorid, String authorName, String category, List<Book> books) {
		super();
		this.authorId = authorid;
		this.authorName = authorName;
		this.books = books;
	}

	public int getAuthorid() {
		return authorId;
	}

	public void setAuthorid(int authorid) {
		this.authorId = authorid;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		return "Author [authorid=" + authorId + ", authorName=" + authorName + ", books=" + books + "]";
	}

}
