package br.com.zubcovsoft.barbeiroapp.cliente.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zubcovsoft.barbeiroapp.cliente.form.ClienteFORM;
import br.com.zubcovsoft.barbeiroapp.cliente.model.Cliente;
import br.com.zubcovsoft.barbeiroapp.cliente.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<List<Cliente>> buscarClientes() {
		return clienteService.buscarClientes();
	}

	@PostMapping
	public ResponseEntity<Cliente> novoCliente(@RequestBody Cliente cliente, UriComponentsBuilder uriBuilder) {
		Cliente clienteSalvo = clienteService.novoCliente(cliente);
		URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(clienteSalvo.getId()).toUri();
		return ResponseEntity.created(uri).body(clienteSalvo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarCliente(@PathVariable Long id){
		return ResponseEntity.ok().body(clienteService.DeletarCliente(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizarCliente( @PathVariable Long id, @RequestBody ClienteFORM form){
		Cliente clienteEditado = clienteService.atualizarCliente(id, form);
		return ResponseEntity.ok().body(clienteEditado);
	}
	

}
