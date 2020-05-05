package br.com.zubcovsoft.barbeiroapp.cliente.form;

import br.com.zubcovsoft.barbeiroapp.cliente.model.Cliente;
import br.com.zubcovsoft.barbeiroapp.cliente.repository.ClienteRepository;

public class ClienteFORM {
	private String nome;
	private String senha;
	private Boolean isAdm;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Boolean getIsAdm() {
		return isAdm;
	}
	public void setIsAdm(Boolean isAdm) {
		this.isAdm = isAdm;
	}
	
	
	public Cliente atualizar(Long id, ClienteRepository clienteRepository) {
		Cliente cliente = clienteRepository.findById(id).get();
		cliente.setSenha(this.senha);
		cliente.setNome(this.nome);
		cliente.setIsAdmin(this.isAdm);
		return cliente;
		
	}

}
