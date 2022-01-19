package br.com.alura.leilao.dao;

import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertNotNull;

public class UsuarioDaoTest {

    private UsuarioDao dao;

    @Test
    void testeBuscaDeUsuarioPeloUserName(){
        EntityManager em = JPAUtil.getEntityManager();
        this.dao = new UsuarioDao(em);

        Usuario usuario = new Usuario("fulano","fulano@email.com","12345678");
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();

        Usuario usuarioEncontrado = this.dao.buscarPorUsername(usuario.getNome());
        assertNotNull(usuario);
    }

}
