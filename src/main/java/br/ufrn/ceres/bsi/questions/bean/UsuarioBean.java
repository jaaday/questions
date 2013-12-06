package br.ufrn.ceres.bsi.questions.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufrn.ceres.bsi.questions.dao.UserService;
import br.ufrn.ceres.bsi.questions.dao.exceptions.NonexistentEntityException;
import br.ufrn.ceres.bsi.questions.dao.util.JPAUtil;
import br.ufrn.ceres.bsi.questions.model.Usuario;

@ManagedBean(name="usuarioBean")
@RequestScoped
public class UsuarioBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService dao = new UserService(JPAUtil.EMF);
	private Usuario usuario = new Usuario();

	public UsuarioBean(){
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
	
	public void removerUsuario(Usuario u) throws NonexistentEntityException{
		dao.delete(u.getId());
	}
	
	public List<Usuario> getUsuarios(){
		return dao.findEntities();
	}
}
