package com.kevin.br.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevin.br.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	List<Cliente> findByNomeContainingIgnoreCase(String nome); 	

}
