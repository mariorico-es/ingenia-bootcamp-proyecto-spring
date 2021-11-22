package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;

@Service
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByName(String name);
}