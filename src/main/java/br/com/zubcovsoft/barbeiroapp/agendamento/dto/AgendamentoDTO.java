package br.com.zubcovsoft.barbeiroapp.agendamento.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.zubcovsoft.barbeiroapp.agendamento.model.Agendamento;

public class AgendamentoDTO {
	private Long id;
	private LocalDateTime dataAgendamento;
	private String nomeServico;
	private String nomeCliente;
	
	
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

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public AgendamentoDTO() {}
	
	public AgendamentoDTO(Agendamento agendamento) {
		this.dataAgendamento = agendamento.getDataAgendamento();
		this.nomeCliente = agendamento.getCliente().getNome();
		this.nomeServico = agendamento.getServico().getNome();
		this.id = agendamento.getId();
	}
	
	public static AgendamentoDTO converterUmAgendamento(Agendamento agendamento) {
		return new AgendamentoDTO(agendamento);
	}
	
	public static List<AgendamentoDTO> converter(List<Agendamento> agendamentos) {
		return agendamentos.stream().map(AgendamentoDTO::new).collect(Collectors.toList());
	}

	
}
