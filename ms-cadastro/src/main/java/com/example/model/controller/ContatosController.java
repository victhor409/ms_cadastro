package com.example.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.dto.ContatoDTO;
import com.example.model.service.ContatosService;

@RestController
@RequestMapping("/contatos")
public class ContatosController {
	
	@Autowired
	private ContatosService service;
	
	@GetMapping
	public ResponseEntity findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@PostMapping(value = "/salvar")
	public ResponseEntity saveContato(@RequestBody ContatoDTO dto) {
		ContatoDTO newDTO = service.salvarContato(dto);
		return ResponseEntity.ok().body(newDTO);
	}
	
	@PutMapping
	public ResponseEntity updateContato(@RequestBody ContatoDTO dto) {
		return ResponseEntity.ok().body(service.updateContato(dto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteContato(Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
