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

import com.example.demo.domain.User;
import com.example.demo.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * http://localhost:8080/api/user/1
	 */
	@GetMapping("/user/{id}")
	@ApiOperation("Muestra un usuario a través de su id")
	public ResponseEntity<User> findById(@ApiParam("User id") @PathVariable Long id) {
		
		Optional<User> userOpt = this.userService.findById(id);
		
		if (userOpt.isPresent()) {
			return ResponseEntity.ok(userOpt.get());
		}else {
		return ResponseEntity.notFound().build();
		}
	}
	
	/**
	 * http://localhost:8080/api/users
	 */
	@GetMapping("/users")
	@ApiOperation("Muestra un listado de todos los usuarios")
	public List<User> findAll(){
		return this.userService.findAll();
	}
	
	/**
	 * http://localhost:8080/api/saveuser
	 */
	@PutMapping("/saveuser")
	@ApiOperation("Guarda o actualiza un usuario según si su id existe o no")
	public ResponseEntity<User> update(@RequestBody User user) {
		if (user.getId() == null) {
			return ResponseEntity.badRequest().build();
		}else{
			return ResponseEntity.ok(this.userService.save(user));
		}
	}
	
	/**
	 * http://localhost:8080/api/user/1
	 */
	@DeleteMapping("/delete/user/{id}")
	@ApiOperation("Elimina un usuario a través de su id")
	public ResponseEntity<Void> delete(@ApiParam("User id") @PathVariable Long id){			
		this.userService.deleteById(id);
		return ResponseEntity.noContent().build();			
	}
	
	/**
	 * http://localhost:8080/api/name/Arantza
	 */
	@GetMapping("/user/name/{name}")
	@ApiOperation("Muestra un usuario a través de su nombre")
	public ResponseEntity<User> findByName(@ApiParam("User name") @PathVariable String name) {

		Optional<User> userOpt = this.userService.findByName(name);
		
		if (userOpt.isPresent()) {
			return ResponseEntity.ok(userOpt.get());
		}else {
		return ResponseEntity.notFound().build();
		}
	}
}