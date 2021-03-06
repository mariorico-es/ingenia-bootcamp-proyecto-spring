package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.domain.Company;

public interface CompanyRepository  extends JpaRepository<Company, Long>{
	
	Optional<Company> findByName(String name);
}