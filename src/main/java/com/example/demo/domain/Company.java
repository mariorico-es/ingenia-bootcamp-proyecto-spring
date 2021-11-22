package com.example.demo.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "companies")
public class Company {
	
	// Propiedades
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	private String name;
	private double age;
	private short numProducts;
	private short numEmployees;
	private int productPrice;
	
	// Constructor
	public Company() {};
	
	// Métodos
	@Override
	public String toString() {
		return "Empresa [id = " + id + ", name = " + name + ", age = " + age + ", numProducts = " + numProducts
				+ ", numEmployees = " + numEmployees + ", productPrice = " + productPrice + "]";
	}
	
	public String calculateBilling() {
		double billing = ((this.getNumEmployees() * this.getNumProducts()) * this.productPrice) * this.getAge();
		return "La empresa " + this.getName() + " ha facturado un total de " + (new BigDecimal(billing).longValue()) + " €.";
	}
	
	// Getters & Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public short getNumProducts() {
		return numProducts;
	}

	public void setNumProducts(short numProducts) {
		this.numProducts = numProducts;
	}

	public short getNumEmployees() {
		return numEmployees;
	}

	public void setNumEmployees(short numEmployees) {
		this.numEmployees = numEmployees;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
}