package com.kevin.br.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevin.br.entities.Pedido;

public interface PedidoRepository extends JpaRepository <Pedido, Long>{
	// Busca pedidos pelo nome do cliente (query method)
	List<Pedido> findByClienteNomeContainingIgnoreCase(String nome);
}
