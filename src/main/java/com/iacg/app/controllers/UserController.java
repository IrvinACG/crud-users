package com.iacg.app.controllers;

import java.net.URI;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iacg.app.services.IUserService;
import com.iacg.app.services.dto.UserDTO;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private IUserService service;
	
	@GetMapping()
	public ResponseEntity<?> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable(name = "id", required = true) Long id){
		UserDTO dto = service.findById(id);
		HttpStatus status = null;
		if(Objects.isNull(dto)) {
			status = HttpStatus.NOT_FOUND;
		}else {
			status = HttpStatus.OK;
		}
		return ResponseEntity.status(status).body(dto);
	}
	
	@PostMapping()
	public ResponseEntity<?> save(@RequestBody UserDTO userDto){
		UserDTO userDtoRes = service.save(userDto);
		return ResponseEntity.created(URI.create("/api/users/" + userDtoRes.getId())).body(userDtoRes);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable(name = "id", required = true) Long id, @RequestBody UserDTO userDto){
		UserDTO userDtoRes = service.update(id, userDto);
		if(Objects.isNull(userDtoRes)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.created(URI.create("/api/users/" + userDtoRes.getId())).body(userDtoRes);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(name = "id", required = true) Long id){
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
