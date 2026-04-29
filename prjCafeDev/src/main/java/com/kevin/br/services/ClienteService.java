package com.kevin.br.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.br.entities.Cliente;
import com.kevin.br.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
}
	
	public List<Cliente> listarTodos() {
		return clienteRepository.findAll();
	}
	
	public List<Cliente> buscarPorNome(String nome) {
		return clienteRepository.findByNomeContainingIgnoreCase(nome);
	}
	
	public Cliente buscarPorId(Long id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
	}
	
	public void deletar(Long id) {
		if (!clienteRepository.existsById(id)) {
			throw new RuntimeException("Não é possível deetar: Cliente não existe.");
		}
		clienteRepository.deleteById(id);
	}
}
