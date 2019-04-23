package br.com.caelum.ingresso.validacao;

import java.time.LocalTime;
import java.util.List;

import br.com.caelum.ingresso.model.Sessao;

public class ValidadorDeSessao {

	private List<Sessao> sessoesDaSala;

	public ValidadorDeSessao(List<Sessao> sessoesDaSala) {
		this.sessoesDaSala = sessoesDaSala;
	}

	private boolean isConflitante(Sessao sessaoNova, Sessao sessaoExist) {

		LocalTime inicioSessaoNova = sessaoNova.getHorario();
		LocalTime terminoSessaoNova = sessaoNova.getHorario().plus(sessaoNova.getFilme().getDuracao());

		LocalTime inicioSessaoExist = sessaoExist.getHorario();
		LocalTime terminoSessaoExist = sessaoExist.getHorario().plus(sessaoExist.getFilme().getDuracao());

		boolean inicioNovaDentroExist = inicioSessaoNova.isAfter(inicioSessaoExist)
				&& inicioSessaoNova.isBefore(terminoSessaoExist);
		boolean fimNovaDentroExist = terminoSessaoNova.isAfter(inicioSessaoExist)
				&& terminoSessaoNova.isBefore(terminoSessaoExist);

		boolean inicioExistDentroNova = inicioSessaoExist.isAfter(inicioSessaoNova)
				&& inicioSessaoExist.isBefore(terminoSessaoNova);
		boolean terminoExistDentroNova = terminoSessaoExist.isAfter(inicioSessaoNova)
				&& terminoSessaoExist.isBefore(terminoSessaoNova);
		
		boolean comecaNoMesmoHorario = inicioSessaoNova.equals(inicioSessaoExist);
		
		if (inicioNovaDentroExist || fimNovaDentroExist || inicioExistDentroNova || terminoExistDentroNova || comecaNoMesmoHorario) {
			return true;
		}

		return false;
	}

	public boolean cabe(Sessao sessaoNova) {
		return sessoesDaSala.stream()
				.noneMatch(sessaoExist -> isConflitante(sessaoExist, sessaoNova));
	}

}
