package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DescontoTest {
	
	private Sessao sessao;
	private Sala sala;
	private Filme filme;
	private Lugar lugar;

	@Before
	public void preparaCenario() {
		
		this.sala = new Sala("Eldorado - IMAX", new BigDecimal("20.5"));
		this.filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("12"));
		this.sessao = new Sessao(sala, filme, LocalTime.parse("10:00:00"));
		this.lugar = new Lugar("A", 1);
	}

	@Test
	public void naoDeveConcederDescontoParaIngressoNormal() {
		Ingresso ingresso = new Ingresso(sessao, TipoIngresso.INTEIRA, lugar);
		BigDecimal precoEsperado = new BigDecimal("32.50");
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}

	@Test
	public void deveConcederDescontoDe50PorcentoParaIngressoDeEstudante() {
		Ingresso ingresso = new Ingresso(sessao, TipoIngresso.ESTUDANTE, lugar);
		BigDecimal precoEsperado = new BigDecimal("16.25");
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}
	
	@Test
	public void deveConcederDescontoDe30PorcentoParaIngressoDeIdoso() {
		Ingresso ingresso = new Ingresso(sessao, TipoIngresso.IDOSO, lugar);
		BigDecimal precoEsperado = new BigDecimal("22.75");
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}
	
	@Test
	public void deveConcederDescontoDe5ReaisParaIngressoDeBanco() {
		Ingresso ingresso = new Ingresso(sessao, TipoIngresso.BANCO, lugar);
		BigDecimal precoEsperado = new BigDecimal("27.50");
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}
}
