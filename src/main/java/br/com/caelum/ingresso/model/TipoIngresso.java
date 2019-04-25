package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import br.com.caelum.ingresso.model.desconto.Desconto;
import br.com.caelum.ingresso.model.desconto.DescontoBanco;
import br.com.caelum.ingresso.model.desconto.DescontoEstudante;
import br.com.caelum.ingresso.model.desconto.DescontoIdoso;
import br.com.caelum.ingresso.model.desconto.SemDesconto;

public enum TipoIngresso {
	
	BANCO(new DescontoBanco()), 
	ESTUDANTE(new DescontoEstudante()), 
	IDOSO(new DescontoIdoso()),
	INTEIRA(new SemDesconto());
	
	private final Desconto desconto;
	
	TipoIngresso(Desconto desconto){
		this.desconto = desconto;
	}
	
	public BigDecimal aplicaDesconto(BigDecimal valor) {
		return desconto.calculaDesconto(valor);
	}
	
	public String getDescricao() {
		return desconto.getDescricao();
	}

}
