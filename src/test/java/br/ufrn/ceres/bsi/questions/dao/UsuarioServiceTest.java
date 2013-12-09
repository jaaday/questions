package br.ufrn.ceres.bsi.questions.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufrn.ceres.bsi.questions.dao.util.JPAUtil;
import br.ufrn.ceres.bsi.questions.model.Endereco;
import br.ufrn.ceres.bsi.questions.model.Usuario;

public class UsuarioServiceTest {
	UserService service = new UserService(JPAUtil.EMF);
	Usuario usuario1;
	Endereco endereco;
	
    @Before
    public void setUp() throws Exception {
    	usuario1 = new Usuario();
    	endereco = new Endereco();
    	usuario1.setFirstname("Jaaday");
    	usuario1.setEmail("email");
    	usuario1.setLastname("Silva");
    	usuario1.setPassword("123");
    	usuario1.setUsername("nome");
    	endereco.setCity("Caico");
    	endereco.setCountry("Brasil");
    	endereco.setStreet("Rua tal");
    	endereco.setSuburb("Castelo");
    	usuario1.setAddress(endereco);
    }

    @After
    public void tearDown() throws Exception {
    	try {
            if (service != null && usuario1.getId() != null) {
                service.delete(usuario1.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    	usuario1 = null;
    }

    @Test
    public void testNewUser() {
//                fail("Not yet implemented");
    }

    @Test
    public void testCreate() {
    	Usuario usuario;
        try {
            assertEquals("1", null, usuario1.getId());
            usuario = service.create(usuario1);
            assertNotNull("2", usuario);
            assertNotNull("3", usuario.getId());
            assertEquals("4", "Jaaday", usuario.getFirstname());
        } catch (Exception e) {
            fail();
            e.printStackTrace();
        }
    }

    @Test
    public void testFind() {
        //fail("Not yet implemented");
    }

    @Test
    public void testDelete() {
        //fail("Not yet implemented");
    }

    @Test
    public void testUpdate() {
        //fail("Not yet implemented");
    }

}