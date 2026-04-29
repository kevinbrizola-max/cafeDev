package com.kevin.br.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "cliente_tb")
public class Cliente {
		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY)  
		private Long id;
		
		private String cliente;
		
		@NotBlank
		@Column(nullable = false)
		private String nome;
		
		@Email
		@NotBlank
		@Column(unique = true)
		private String email;
		
		@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
		private List<Pedido> pedidos = new ArrayList<>();

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCliente() {
			return cliente;
		}

		public void setCliente(String cliente) {
			this.cliente = cliente;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public List<Pedido> getPedidos() {
			return pedidos;
		}

		public void setPedidos(List<Pedido> pedidos) {
			this.pedidos = pedidos;
		}

		
	}