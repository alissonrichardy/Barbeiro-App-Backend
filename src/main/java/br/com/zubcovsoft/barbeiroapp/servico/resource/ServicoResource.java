package br.com.zubcovsoft.barbeiroapp.servico.resource;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zubcovsoft.barbeiroapp.servico.form.ServicoFORM;
import br.com.zubcovsoft.barbeiroapp.servico.model.Servico;
import br.com.zubcovsoft.barbeiroapp.servico.service.ServicoService;

@RestController
@RequestMapping("/servico")
@CrossOrigin(maxAge = 10, origins = {"*"})
public class ServicoResource {
	
	@Autowired
	private ServicoService servicoService;
	
	@GetMapping()
	public ResponseEntity<List<Servico>> getServicos(){
		return servicoService.getServicos();
	}
	
	@PostMapping
	public ResponseEntity<Servico> novoServico(@RequestBody Servico servico, UriComponentsBuilder uriBuilder){
		Servico servicoSalvo = servicoService.novoServico(servico);
		URI uri = uriBuilder.path("/servico/{id}").buildAndExpand(servicoSalvo.getId()).toUri();
		return ResponseEntity.created(uri).body(servicoSalvo);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirServico(@PathVariable Long id){
		return servicoService.deletarServico(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Servico> atualizarServico(@PathVariable Long id, @RequestBody ServicoFORM form ){
		return servicoService.atualizarServico(id, form);
	}
	 

}
