package com.libreria.model;

public class BookModel {
	private int idBook;
	private String name;
	private int idCategory;
	private String description;
	private int status;
	private int active;

	
	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	
	public BookModel(int idBook, String name, int idCategory, String description, int status, int active) {
		super();
		this.idBook = idBook;
		this.name = name;
		this.idCategory = idCategory;
		this.description = description;
		this.status = status;
		this.active = active;
	}

	public BookModel(){		
	}

	@Override
	public String toString() {
		return "BookModel [name=" + name + ", idCategory=" + idCategory + ", description=" + description + ", status="
				+ status + ", active=" + active + "]";
	}

}
