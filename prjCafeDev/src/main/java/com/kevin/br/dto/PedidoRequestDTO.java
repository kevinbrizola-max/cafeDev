package com.kevin.br.dto;

public class PedidoRequestDTO {
	private String descricao;
	private Double valorTotal;
	private Long clienteId;
	
	public PedidoRequestDTO() {}
		
	public PedidoRequestDTO(String descricao, Double valorTotal, Long clienteId) {
		this.descricao = descricao;
		this.valorTotal = valorTotal;
		this.clienteId = clienteId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	
	
	
}
