package br.com.caelum.ingresso.model.desconto;

import java.math.BigDecimal;

public class DescontoEstudante implements Desconto {

	@Override
	public BigDecimal calculaDesconto(BigDecimal preco) {
		return preco.divide(new BigDecimal("2.0"));
	}

	@Override
	public String getDescricao() {
		return "ESTUDANTE";
	}
}
