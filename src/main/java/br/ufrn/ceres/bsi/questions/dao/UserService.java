package br.ufrn.ceres.bsi.questions.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;

import br.ufrn.ceres.bsi.questions.model.Questao;
import br.ufrn.ceres.bsi.questions.model.Usuario;

@Stateless
public class UserService extends DataAccessService<Usuario> {

    public UserService(EntityManagerFactory emf) {
        super(Usuario.class, emf);
    }

    /**
     * Retorna uma nova quest�o.
     * @param descricao A descri��o da quest�o.
     * @return {@link Questao}
     */
    public Usuario novoUsuario(){
        return new Usuario();
    }

}