package br.com.caelum.ingresso.model.form;

import java.time.LocalTime;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class SessaoForm {
	
	@DateTimeFormat(pattern="HH:mm")
	@NotNull
	private LocalTime horario;
	@NotNull
	private Integer filmeId;
	@NotNull
	private Integer salaId;
	
	public Sessao getSessao(SalaDao salaDao, FilmeDao filmeDao) {
		Sala sala = salaDao.findOne(this.getSalaId());
		Filme filme = filmeDao.findOne(this.getFilmeId());
		Sessao sessao = new Sessao(sala, filme, this.getHorario());
		return sessao;
	}
	
	public LocalTime getHorario() {
		return horario;
	}
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	public Integer getFilmeId() {
		return filmeId;
	}
	public void setFilmeId(Integer filmeId) {
		this.filmeId = filmeId;
	}
	public Integer getSalaId() {
		return salaId;
	}
	public void setSalaId(Integer salaId) {
		this.salaId = salaId;
	}
	
	

}
