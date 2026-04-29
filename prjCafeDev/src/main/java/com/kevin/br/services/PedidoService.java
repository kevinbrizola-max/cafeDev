package com.kevin.br.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.br.dto.PedidoRequestDTO;
import com.kevin.br.entities.Cliente;
import com.kevin.br.entities.Pedido;
import com.kevin.br.repositories.ClienteRepository;
import com.kevin.br.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Pedido salvar(PedidoRequestDTO dto) {
		Cliente cliente = clienteRepository.findById(dto.getClienteId())
				.orElseThrow(() -> new RuntimeException("Erro: Cliente não encontrado com o ID: " + dto.getClienteId()));
		
		Pedido pedido = new Pedido();
		pedido.setDescricao(dto.getDescricao());
		pedido.setValorTotal(dto.getValorTotal());
		pedido.setDataPedido(LocalDateTime.now());
		pedido.setCliente(cliente);
		
		return pedidoRepository.save(pedido);
	}
	
	public List<Pedido> listarTodos() {
		return pedidoRepository.findAll();	
	}
	
	public List<Pedido> buscarPorNomeCliente(String nome) {
		return pedidoRepository.findByClienteNomeContainingIgnoreCase(nome);
	}
  
}