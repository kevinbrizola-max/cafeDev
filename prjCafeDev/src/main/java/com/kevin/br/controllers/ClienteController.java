package com.kevin.br.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.br.entities.Cliente;
import com.kevin.br.services.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin("*")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<Cliente> cadastrar(@RequestBody @Valid Cliente cliente) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.salvar(cliente));
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listarTodos() {
		return ResponseEntity.ok(clienteService.listarTodos());
	}

	public ResponseEntity<List<Cliente>> buscarPorNome(@RequestParam String nome) {
		return ResponseEntity.ok(clienteService.buscarPorNome(nome));
	}
	
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		clienteService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
