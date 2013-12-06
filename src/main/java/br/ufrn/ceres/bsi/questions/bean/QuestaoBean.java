package br.ufrn.ceres.bsi.questions.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ufrn.ceres.bsi.questions.dao.QuestaoService;
import br.ufrn.ceres.bsi.questions.dao.exceptions.NonexistentEntityException;
import br.ufrn.ceres.bsi.questions.dao.util.JPAUtil;
import br.ufrn.ceres.bsi.questions.model.Alternativa;
import br.ufrn.ceres.bsi.questions.model.Questao;

@ManagedBean(name="questaoBean")
@SessionScoped
public class QuestaoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Questao questao;
    private Alternativa a;
    private Alternativa b;
    private Alternativa c;
    private Alternativa d;
    private QuestaoService dao;
    
    public QuestaoBean(){
    	questao = new Questao();
        a = new Alternativa();
        b = new Alternativa();
        c = new Alternativa();
        d = new Alternativa();
        dao = new QuestaoService(JPAUtil.EMF);
    }

	public Alternativa getA() {
		return a;
	}

	public void setA(Alternativa a) {
		this.a = a;
	}

	public Alternativa getB() {
		return b;
	}

	public void setB(Alternativa b) {
		this.b = b;
	}

	public Alternativa getC() {
		return c;
	}

	public void setC(Alternativa c) {
		this.c = c;
	}

	public Alternativa getD() {
		return d;
	}

	public void setD(Alternativa d) {
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
