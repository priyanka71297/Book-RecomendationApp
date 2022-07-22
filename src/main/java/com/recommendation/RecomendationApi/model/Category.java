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
@Table(name = "categories")
public class Category{
	
	@Id
	@Column(name = "category_id")
	private int categoryId;
	
	

	@Column(name = "category")
	private String category;
	
	@OneToMany(mappedBy = "category")
	//@JsonBackReference
	@JsonIgnoreProperties("category")
	private List<Book> books;
	
	public Category() {
		
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", category=" + category + ", books=" + books + "]";
	}
	
	
	
	
}