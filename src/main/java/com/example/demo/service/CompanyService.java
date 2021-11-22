package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Company;
import com.example.demo.repository.CompanyRepository;

@Service
public class CompanyService{
	
	private CompanyRepository companyRepository;
	
	public CompanyService(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}
	
	public Optional<Company> findById(Long id){
		return this.companyRepository.findById(id);
	}

	public Optional<Company> findByName(String name){
		return this.companyRepository.findByName(name);
	}
	
	public List<Company> findAll(){
		return this.companyRepository.findAll();
	}
	
	public Company save(Company company) {
		if(company == null) {
			return null;
		}
		else {
		return this.companyRepository.save(company);
		}
	}
	
	public boolean deleteById(Long id) {
		if (id == null || id <= 0) {
			return false;
		}
		try {
			this.companyRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			System.out.println("La empresa con id " + id + " no existe.");
			return false;
		}
	}
	
	public boolean deleteAll() {
		this.companyRepository.deleteAll();
		return true;
	}
}