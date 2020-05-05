package br.com.zubcovsoft.barbeiroapp.agendamento.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zubcovsoft.barbeiroapp.agendamento.dto.AgendamentoDTO;
import br.com.zubcovsoft.barbeiroapp.agendamento.form.AgendamentoFORM;
import br.com.zubcovsoft.barbeiroapp.agendamento.model.Agendamento;
import br.com.zubcovsoft.barbeiroapp.agendamento.service.AgendamentoService;

@RestController
@RequestMapping("agendamento")
@CrossOrigin(maxAge = 10, origins = { "*" })
public class AgendamentoResource {

	@Autowired
	private AgendamentoService agendamentoService;

	@GetMapping
	public ResponseEntity<List<AgendamentoDTO>> buscarAgendamentos() {
		List<AgendamentoDTO> agendamentosDTO = agendamentoService.buscarAgendamentos();
		if (!agendamentosDTO.isEmpty())
			return ResponseEntity.ok().body(agendamentosDTO);
		else
			return ResponseEntity.notFound().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<AgendamentoDTO>> buscarAgendamentosByIdCliente(@PathVariable Long id) {
		List<AgendamentoDTO> agendamentos = agendamentoService.buscarAgendamentosByIdCliente(id);
		if (!agendamentos.isEmpty())
			return ResponseEntity.ok(agendamentos);
		else
			return ResponseEntity.notFound().build();

	}

	@PostMapping
	public ResponseEntity<AgendamentoDTO> novoAgendamento(@RequestBody AgendamentoFORM form) {
		Agendamento agendamentoSalvo = agendamentoService.novoAgendamento(form);
		return ResponseEntity.ok().body(new AgendamentoDTO(agendamentoSalvo));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarAgendamento(@PathVariable Long id) {
		agendamentoService.deletarAgendamento(id);
		return ResponseEntity.ok().build();
	}
}
