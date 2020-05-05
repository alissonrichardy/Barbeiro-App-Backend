package br.com.zubcovsoft.barbeiroapp.cliente.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.zubcovsoft.barbeiroapp.cliente.form.ClienteFORM;
import br.com.zubcovsoft.barbeiroapp.cliente.model.Cliente;
import br.com.zubcovsoft.barbeiroapp.cliente.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public ResponseEntity<List<Cliente>> buscarClientes() {
		return ResponseEntity.ok().body(clienteRepository.findAll());
	}

	public Cliente novoCliente(Cliente cliente) {
		Cliente clienteSalvo = clienteRepository.save(cliente);
		return clienteSalvo;
	}
	
	public ResponseEntity<?> DeletarCliente(Long id) {
		clienteRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@Transactional
	public Cliente atualizarCliente(Long id, ClienteFORM form) {
		Cliente clienteEditado = form.atualizar(id, clienteRepository);
		return clienteEditado;
		
	}

}
