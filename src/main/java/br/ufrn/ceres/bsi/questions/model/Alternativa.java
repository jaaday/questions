package br.ufrn.ceres.bsi.questions.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({@NamedQuery(name = "Alternativa.allAlternativa", query = "SELECT a FROM Alternativa a"),
@NamedQuery(name = "Alternativa.countAlternativa", query = "SELECT COUNT(a) FROM Alternativa a")})
public class Alternativa extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(length = 50,name="descricao")
	private String descricao;

	public Alternativa() {
		
	}
	
    public Alternativa(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
