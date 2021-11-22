package com.example.demo.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Company;
import com.example.demo.service.CompanyService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class CompanyController {
	
	private CompanyService companyService;
	
	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}

	/**
	 * http://localhost:8080/api/company/1
	 */
	@GetMapping("/company/{id}")
	@ApiOperation("Muestra una compañía a través de su id")
	public ResponseEntity<Company> findById(@ApiParam("Company id") @PathVariable Long id) {
		
		Optional<Company> companyOpt = this.companyService.findById(id);
		
		if (companyOpt.isPresent()) {
			return ResponseEntity.ok(companyOpt.get());
		}else {
		return ResponseEntity.notFound().build();
		}
	}
	
	/**
	 * http://localhost:8080/api/companies
	 */
	@GetMapping("/companies")
	@ApiOperation("Muestra un listado de todas las compañías")
	public List<Company> findAll(){
		return this.companyService.findAll();
	}
	
	/**
	 * http://localhost:8080/api/savecompany
	 */
	@PutMapping("/savecompany")
	@ApiOperation("Guarda o actualiza una compañía según si su id existe o no")
	public ResponseEntity<Company> update(@RequestBody Company company) {
		if (company.getId() == null) {
			return ResponseEntity.badRequest().build();
		}else{
			return ResponseEntity.ok(this.companyService.save(company));
		}
	}
	
	/**
	 * http://localhost:8080/api/comapny/1
	 */
	@DeleteMapping("/delete/company/{id}")
	@ApiOperation("Elimina una copañía a través de su id")
	public ResponseEntity<Void> delete(@ApiParam("Company id") @PathVariable Long id){			
		this.companyService.deleteById(id);
		return ResponseEntity.noContent().build();			
	}
	
	/**
	 * http://localhost:8080/api/billing/1
	 */
	@GetMapping("/billing/{id}")
	@ApiOperation("Muestra la facturación global de la compañía en su tiempo de existencia")
	public ResponseEntity<String> calculateBilling(@ApiParam("Company id") @PathVariable Long id) {
		
		Optional<Company> companyOpt = this.companyService.findById(id);
		
		if (companyOpt.isPresent()) {
			return ResponseEntity.ok(companyOpt.get().calculateBilling());
		}else {
		return ResponseEntity.notFound().build();
		}
	}
	
	/**
	 * http://localhost:8080/api/name/Jaguar
	 */
	@GetMapping("/company/name/{name}")
	@ApiOperation("Muestra una compañía a través de su nombre")
	public ResponseEntity<Company> findByName(@ApiParam("Company name") @PathVariable String name) {

		Optional<Company> companyOpt = this.companyService.findByName(name);
		
		if (companyOpt.isPresent()) {
			return ResponseEntity.ok(companyOpt.get());
		}else {
		return ResponseEntity.notFound().build();
		}
	}	
}