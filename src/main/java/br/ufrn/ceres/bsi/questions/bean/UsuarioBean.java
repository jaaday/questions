package br.ufrn.ceres.bsi.questions.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ufrn.ceres.bsi.questions.dao.UserService;
import br.ufrn.ceres.bsi.questions.dao.exceptions.NonexistentEntityException;
import br.ufrn.ceres.bsi.questions.dao.util.JPAUtil;
import br.ufrn.ceres.bsi.questions.model.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioBean {
	private UserService dao;
	private Usuario usuario;

	public UsuarioBean(){
		dao = new UserService(JPAUtil.EMF);
		usuario = new Usuario();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public UserService getDao() {
		return dao;
	}
	
	public void inserirUsuario(){
		dao.create(usuario);
	}
	
	public void removerUsuario(Usuario u){
		try {
			dao.destroy(u.getId());
		} catch (NonexistentEntityException e) {
			e.printStackTrace();
		}
	}
	
	public List<Usuario> getUsuarios(){
		return dao.findUserEntities();
	}
}
