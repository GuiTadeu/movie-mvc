package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import br.com.caelum.ingresso.model.desconto.Desconto;

public class Ingresso {
	
	private Integer id;
	private Sessao sessao;
	private BigDecimal preco;
	private Lugar lugar;
	
	public Ingresso(Integer id, Sessao sessao, Lugar lugar, Desconto desconto) {
		this.sessao = sessao;
		this.preco = desconto.calculaDesconto(sessao.getPreco());
		this.lugar = lugar;
	}
	
	public Sessao getSessao() {
		return sessao;
	}
	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public Lugar getLugar() {
		return lugar;
	}
	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
