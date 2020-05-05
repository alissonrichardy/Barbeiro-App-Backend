package br.com.zubcovsoft.barbeiroapp.agendamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zubcovsoft.barbeiroapp.agendamento.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

	List<Agendamento> findAllByClienteId(Long id);

}
