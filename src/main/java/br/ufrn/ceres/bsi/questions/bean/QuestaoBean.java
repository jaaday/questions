package br.ufrn.ceres.bsi.questions.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufrn.ceres.bsi.questions.dao.QuestaoService;
import br.ufrn.ceres.bsi.questions.dao.exceptions.NonexistentEntityException;
import br.ufrn.ceres.bsi.questions.dao.util.JPAUtil;
import br.ufrn.ceres.bsi.questions.model.Questao;

@ManagedBean(name="questaoBean")
@RequestScoped
public class QuestaoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Questao questao = new Questao();
    private String a, b, c, d;
	private QuestaoService dao = new QuestaoService(JPAUtil.EMF);
    
    public QuestaoBean(){
    }
    
    public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public QuestaoService getDao() {
		return dao;
	}

	public void setDao(QuestaoService dao) {
		this.dao = dao;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}
	
	public void inserirQuestao(){
		try {
			questao.addAlternativa(a);
			questao.addAlternativa(b);
			questao.addAlternativa(c);
			questao.addAlternativa(d);
			
			dao.create(questao);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removerUsuario(Questao q) throws NonexistentEntityException{
		dao.delete(q.getId());
	}
	
	public List<Questao> getQuestoes(){
		try {
			return dao.findEntities();
		} catch (Exception e) {
			return null;
		}	
	}

}
