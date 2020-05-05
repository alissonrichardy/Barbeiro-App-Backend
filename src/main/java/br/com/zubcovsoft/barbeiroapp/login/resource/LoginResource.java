package br.com.zubcovsoft.barbeiroapp.login.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zubcovsoft.barbeiroapp.cliente.model.Cliente;
import br.com.zubcovsoft.barbeiroapp.cliente.repository.ClienteRepository;
import br.com.zubcovsoft.barbeiroapp.login.model.Login;

@RestController
@RequestMapping("/login")
public class LoginResource {

	@Autowired
	private ClienteRepository clienteRepository;

	@PutMapping
	public ResponseEntity<Cliente> verificarLogin(@RequestBody Login login) {
		Cliente clienteEncontrado = null;
		List<Cliente> clientes = clienteRepository.findAll();

		for (Cliente cliente : clientes) {
			if (cliente.getEmail().contentEquals(login.getEmail())
					&& cliente.getSenha().contentEquals(login.getSenha())) {
				clienteEncontrado = cliente;
			}
		}

		if (clienteEncontrado != null)
			return ResponseEntity.ok().body(clienteEncontrado);
		else
			return ResponseEntity.notFound().build();
	}

}
