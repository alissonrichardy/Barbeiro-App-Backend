package br.com.zubcovsoft.barbeiroapp.servico.form;

import br.com.zubcovsoft.barbeiroapp.servico.model.Servico;
import br.com.zubcovsoft.barbeiroapp.servico.repository.ServicoRepository;

public class ServicoFORM {
	private Integer pontos;
	private Integer duracao;
	private String descricao;
	private Double valor;
	public Integer getPontos() {
		return pontos;
	}
	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}
	public Integer getDuracao() {
		return duracao;
	}
	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	public Servico atualizar(Long id, ServicoRepository servicoRepository) {
		Servico servico = servicoRepository.findById(id).get();
		servico.setDescricao(this.descricao);
		servico.setValor(this.valor);
		servico.setPontos(this.pontos);
		servico.setDuracao(this.duracao);
		return servico;
	}
	
	

	
	
}
