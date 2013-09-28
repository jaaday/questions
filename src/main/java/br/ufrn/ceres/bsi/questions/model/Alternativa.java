package br.ufrn.ceres.bsi.questions.model;

public class Alternativa {
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
