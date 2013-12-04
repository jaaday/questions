package br.ufrn.ceres.bsi.questions.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({@NamedQuery(name = "Questao.allQuestao", query = "SELECT q FROM Questao q"),
@NamedQuery(name = "Questao.countQuestao", query = "SELECT COUNT(q) FROM Questao q")})
public class Questao extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(length = 50)
	private String descricao;
	
	@OneToMany
	private List<Alternativa> alternativas = new ArrayList<Alternativa>();
	
	@OneToOne
	private Alternativa correta = new Alternativa();
	
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

	public Alternativa getCorreta() {
		return correta;
	}

	public void setCorretas(Alternativa correta) {
		this.correta = correta;
	}
	
	public void addAlternativa(Alternativa a) {
		alternativas.add(a);
	}
	
	public void addAlternativaCorreta(Alternativa a) {
		this.correta = a;
	}

}
