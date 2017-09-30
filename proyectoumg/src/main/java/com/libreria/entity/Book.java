package com.libreria.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@GeneratedValue
	@Column(name="idbook")
	private int idbook;
	
	@Column(name="name")
	private String name;
	
	@Column(name="idcategory")
	private int idcategory;
	
	@Column(name="description")
	private String description;
	
	@Column(name="status")
	private int status;
	
	@Column(name="active")
	private int active;

	/*Constructor por defecto para que hibernate lo gestione*/
	public Book() {

	}

	public Book(int idbook, String name, int idcategory, String description, int status, int active) {
		super();
		this.idbook = idbook;
		this.name = name;
		this.idcategory = idcategory;
		this.description = description;
		this.status = status;
		this.active = active;
	}

	public int getIdBook() {
		return idbook;
	}

	public void setIdBook(int idbook) {
		this.idbook = idbook;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdCategory() {
		return idcategory;
	}

	public void setIdCategory(int idcategory) {
		this.idcategory = idcategory;
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

	@Override
	public String toString() {
		return "Book [idbook=" + idbook + ", name=" + name + ", idcategory=" + idcategory + ", description=" + description
				+ ", status=" + status + ", active=" + active + "]";
	}
	

}
