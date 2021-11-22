package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	// Propiedades
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@Column(name = "name") //Puedo cambiar nombre de columna y asignar propiedades a la misma.
	private String name;
	private String nickName;
	private String password;
	private String email;
	private byte rol;
	private short age;
	
	// Constructor
	public User() {}
	
	// Métodos
	@Override
	public String toString() {
		return "Usuario [name=" + name + ", nickName=" + nickName + ", password=" + password + ", email=" + email
				+ ", rol=" + rol + ", age=" + age + "]";
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getRol() {
		return rol;
	}

	public void setRol(byte rol) {
		this.rol = rol;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}	
}