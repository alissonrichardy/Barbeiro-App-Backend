package br.com.zubcovsoft.barbeiroapp.agendamento.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.zubcovsoft.barbeiroapp.cliente.model.Cliente;
import br.com.zubcovsoft.barbeiroapp.servico.model.Servico;

@Entity
public class Agendamento {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "data_agendamento")
	private LocalDateTime dataAgendamento;
	@OneToOne
	private Servico servico;
	@OneToOne
	private Cliente cliente;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(LocalDateTime dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	

}
