package br.ufrn.ceres.bsi.questions.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufrn.ceres.bsi.questions.dao.util.JPAUtil;
import br.ufrn.ceres.bsi.questions.model.Alternativa;
import br.ufrn.ceres.bsi.questions.model.Questao;

public class QuestaoServiceTest {

    QuestaoService service = new QuestaoService(JPAUtil.EMF);
    Questao questao1;
    Questao questao2;
    Alternativa alt1;
    Alternativa alt2;
    Alternativa alt3;
    Alternativa alt4;


    @Before
    public void setUp() throws Exception {
        
        questao1 = new Questao("Voce gosta de Caico?");
        questao1.addAlternativa("Sim");
        questao1.addAlternativa("Nao");
        questao1.addAlternativa("Talvez");
        questao1.addAlternativa("Nao sei");

        questao2 = new Questao("Qual seu nivel de programador?");
        questao2.addAlternativa("Amador");
        questao2.addAlternativa("Intermediario");
        questao2.addAlternativa("Avancado");
        questao2.addAlternativa("Meu Deus");
    }

    @After
    public void tearDown() {
        try {
            if (service != null && questao1.getId() != null && questao2.getId() != null) {
                service.delete(questao1.getId());
                service.delete(questao2.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        questao1 = null;
        questao2 = null;
    }

    @Test
    public void testInserir() {
        Questao questao;
        try {
            assertEquals("1", null, questao1.getId());
            questao = service.create(questao1);
            assertNotNull("2", questao);
            assertNotNull("3", questao.getId());
            assertEquals("4", "Voce gosta de Caico?", questao.getDescricao());
        } catch (Exception e) {
            fail();
            e.printStackTrace();
        }
    }

}