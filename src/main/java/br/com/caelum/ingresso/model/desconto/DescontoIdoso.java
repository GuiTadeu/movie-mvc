package br.com.caelum.ingresso.model.desconto;

import java.math.BigDecimal;

public class DescontoIdoso implements Desconto{

	@Override
	public BigDecimal calculaDesconto(BigDecimal preco) {
		return preco.subtract(preco.multiply(new BigDecimal("0.3")));
	}

	@Override
	public String getDescricao() {
		return "IDOSO";
	}
}
