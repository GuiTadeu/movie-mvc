package br.com.caelum.ingresso.model.desconto;

import java.math.BigDecimal;

public class DescontoIdoso implements Desconto{

	@Override
	public BigDecimal calculaDesconto(BigDecimal preco) {
		return preco.divide(new BigDecimal("5"));
	}
}
