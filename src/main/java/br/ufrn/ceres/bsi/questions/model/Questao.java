package br.ufrn.ceres.bsi.questions.model;

import java.util.List;
import java.util.ArrayList;
import br.ufrn.ceres.bsi.questions.model.Alternativa;

public class Questao {
	private String descricao;
	private List<Alternativa> alternativas = new ArrayList<Alternativa>();
	private List<Alternativa>  corretas = new ArrayList<Alternativa>();
	
	public Questao() {
	}
	
	public Questao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public List<Alternativa> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}

	public List<Alternativa> getCorretas() {
		return corretas;
	}

	public void setCorretas(List<Alternativa> corretas) {
		this.corretas = corretas;
	}
	
	public void addAlternativa(Alternativa a) {
		alternativas.add(a);
	}
	
	public void addAlternativaCorreta(Alternativa a) {
		corretas.add(a);
	}

}
