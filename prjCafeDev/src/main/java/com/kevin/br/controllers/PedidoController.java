package com.kevin.br.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.br.dto.PedidoRequestDTO;
import com.kevin.br.entities.Pedido;
import com.kevin.br.services.PedidoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin("*")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	public ResponseEntity<Pedido> realizarPedido(@RequestBody @Valid PedidoRequestDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.salvar(dto));
	}
	
	@GetMapping
	public ResponseEntity<List<Pedido>> listarTodos() {
		return ResponseEntity.ok(pedidoService.listarTodos());
	}
	
	public ResponseEntity<List<Pedido>> buscarPorNomeCliente(@RequestParam String nome) {
		return ResponseEntity.ok(pedidoService.buscarPorNomeCliente(nome));
	}
	
}
