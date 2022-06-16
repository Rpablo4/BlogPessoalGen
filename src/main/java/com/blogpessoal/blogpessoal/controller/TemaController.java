package com.blogpessoal.blogpessoal.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogpessoal.blogpessoal.model.TemaModel;
import com.blogpessoal.blogpessoal.repository.TemaRepository;

@RestController
@RequestMapping("/tema")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {

	@Autowired
	private TemaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<TemaModel>> getall(){
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/tema/{tema}")
	public ResponseEntity<List<TemaModel>> getByName(@PathVariable String tema){
		return ResponseEntity.ok(repository.findAllByTemaContainingIgnoreCase(tema));
	}
	@PostMapping
	public ResponseEntity<TemaModel> postTema(@RequestBody TemaModel tema){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}
	@PutMapping
	public ResponseEntity<TemaModel> putTema(@RequestBody TemaModel tema){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(tema));
	}
	@DeleteMapping("/{id}")
	public void  deleteTema(@PathVariable Long id) {
		repository.deleteById(id);
	}
}