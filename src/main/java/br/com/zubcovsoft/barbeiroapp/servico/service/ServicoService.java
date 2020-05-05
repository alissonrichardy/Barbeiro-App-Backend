package br.com.zubcovsoft.barbeiroapp.servico.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.zubcovsoft.barbeiroapp.servico.form.ServicoFORM;
import br.com.zubcovsoft.barbeiroapp.servico.model.Servico;
import br.com.zubcovsoft.barbeiroapp.servico.repository.ServicoRepository;

@Service
public class ServicoService {
	
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	
	public ResponseEntity<List<Servico>> getServicos(){
		return ResponseEntity.ok().body(servicoRepository.findAll());
	}
	
	public Servico novoServico(Servico servico){
		Servico servicoSalvo = servicoRepository.save(servico);
		return servicoSalvo;

	}
	
	public ResponseEntity<?> deletarServico(Long id){
		servicoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@Transactional
	public ResponseEntity<Servico> atualizarServico(Long id, ServicoFORM form){
		Servico servicoAt = form.atualizar(id, servicoRepository);
		return ResponseEntity.ok().body(servicoAt);
	}

}
