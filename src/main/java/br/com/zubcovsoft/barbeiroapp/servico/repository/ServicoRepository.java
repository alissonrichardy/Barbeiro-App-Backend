package br.com.zubcovsoft.barbeiroapp.servico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zubcovsoft.barbeiroapp.servico.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
	

}
