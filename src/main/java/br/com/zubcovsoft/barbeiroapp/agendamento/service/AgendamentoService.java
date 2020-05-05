package br.com.zubcovsoft.barbeiroapp.agendamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zubcovsoft.barbeiroapp.agendamento.dto.AgendamentoDTO;
import br.com.zubcovsoft.barbeiroapp.agendamento.form.AgendamentoFORM;
import br.com.zubcovsoft.barbeiroapp.agendamento.model.Agendamento;
import br.com.zubcovsoft.barbeiroapp.agendamento.repository.AgendamentoRepository;
import br.com.zubcovsoft.barbeiroapp.cliente.repository.ClienteRepository;
import br.com.zubcovsoft.barbeiroapp.servico.repository.ServicoRepository;

@Service
public class AgendamentoService {
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	
	public List<AgendamentoDTO> buscarAgendamentos(){
		List<Agendamento> agendamentos = agendamentoRepository.findAll();
			return AgendamentoDTO.converter(agendamentos);
	}
	
	public List<AgendamentoDTO> buscarAgendamentosByIdCliente(Long id){
		List<Agendamento> agendamentos = agendamentoRepository.findAllByClienteId(id);
		return AgendamentoDTO.converter(agendamentos);
	}
	
	public Agendamento novoAgendamento(AgendamentoFORM form) {
		Agendamento agendamento =  new Agendamento();
		agendamento.setCliente(clienteRepository.findById(form.getIdCliente()).get());
		agendamento.setServico(servicoRepository.findById(form.getIdServico()).get());
		agendamento.setDataAgendamento(form.getDataAgendamento());
		return agendamentoRepository.save(agendamento);
	}
	
	public void deletarAgendamento(Long id) {
		agendamentoRepository.deleteById(id);
	}

}
