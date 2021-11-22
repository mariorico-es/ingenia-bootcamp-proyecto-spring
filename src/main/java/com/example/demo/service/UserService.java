package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Optional<User> findById(Long id){
		return this.userRepository.findById(id);
	}

	public Optional<User> findByName(String name){
		return this.userRepository.findByName(name);
	}
	
	public List<User> findAll(){
		return this.userRepository.findAll();
	}
	
	public User save(User user) {
		if(user == null) {
			return null;
		}
		else {
		return this.userRepository.save(user);
		}
	}
	
	public boolean deleteById(Long id) {
		if (id == null || id <= 0) {
			return false;
		}
		try {
			this.userRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			System.out.println("El usuario con id " + id + " no existe.");
			return false;
		}
	}
	
	public boolean deleteAll() {
		this.userRepository.deleteAll();
		return true;
	}
}