package br.com.caelum.ingresso.validacao;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class ValidadorDeSessaoTest {
	
	private Filme filme;
	private Sala sala;
	private Sessao sessaoDasDez;
	private Sessao sessaoDasTreze;
	private Sessao sessaoDasDezoito;

	@Before
	public void preparaCenario() {
		this.filme = new Filme("Batman", Duration.ofMinutes(120), "Ação");
		this.sala = new Sala("Sala 3D");
		this.sessaoDasDez = new Sessao(sala, filme, LocalTime.parse("10:00:00"));
		this.sessaoDasTreze = new Sessao(sala, filme, LocalTime.parse("13:00:00"));
		this.sessaoDasDezoito = new Sessao(sala, filme, LocalTime.parse("18:00:00"));
	}
	
	@Test
	public void garanteQueNaoDevePermitirSessaoNoMesmoHorario() {
		List<Sessao> sessoes = Arrays.asList(sessaoDasDez);
		ValidadorDeSessao validador = new ValidadorDeSessao(sessoes);
		Assert.assertFalse(validador.cabe(sessaoDasDez));
	}
	
	@Test
	public void garanteQueNaoDevePermitirSessoesTerminandoDentroDoHorarioDeUmaSessaoJaExistente() {
		List<Sessao> sessoes = Arrays.asList(sessaoDasDez);
		Sessao sessao = new Sessao(sala, filme, sessaoDasDez.getHorario().minusHours(1));
		ValidadorDeSessao validador = new ValidadorDeSessao(sessoes);
		Assert.assertFalse(validador.cabe(sessao));
	}
	
	@Test
	public void garanteQueNaoDevePermitirSessoesIniciandoDentroDoHorarioDeUmaSessaoJaExistente() {
		List<Sessao> sessoesDaSala = Arrays.asList(sessaoDasDez);
		ValidadorDeSessao validador = new ValidadorDeSessao(sessoesDaSala);
		Sessao sessao = new Sessao(sala, filme, sessaoDasDez.getHorario().plusHours(1));
		Assert.assertFalse(validador.cabe(sessao));
	}
	
	@Test
	public void garanteQueDevePermitirUmaInsercaoEntreDoisFilmes() {
		List<Sessao> sessoes = Arrays.asList(sessaoDasDez, sessaoDasDezoito);
		ValidadorDeSessao validador = new ValidadorDeSessao(sessoes);
		Assert.assertTrue(validador.cabe(sessaoDasTreze));
	}

}
