package br.com.zubcovsoft.barbeiroapp.agendamento.form;

import java.time.LocalDateTime;

public class AgendamentoFORM {
	private Long idServico;
	private LocalDateTime dataAgendamento;
	private Long idCliente;
	
	
	public Long getIdServico() {
		return idServico;
	}
	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}
	public LocalDateTime getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(LocalDateTime dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	
	

}
