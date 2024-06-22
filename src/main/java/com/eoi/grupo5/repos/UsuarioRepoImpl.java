package com.eoi.grupo5.repos;

import com.eoi.grupo5.models.Usuario;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class UsuarioRepoImpl implements Repo<Usuario>{

    private EntityManager em;

    public UsuarioRepoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Usuario> listar() {
        return em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
    }

    @Override
    public Optional<Usuario> porId(Integer id) {
        return Optional.ofNullable(em.find(Usuario.class, id));
    }

    @Override
    public void guardar(Usuario usuario) {
        try {
            em.getTransaction().begin();
            if(usuario.getId() != null && usuario.getId() > 0) {
                em.merge(usuario);
            } else {
                em.persist(usuario);
            }
            em.getTransaction().commit();
        } catch(Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Integer id) {
        try {
            em.getTransaction().begin();
            Optional<Usuario> usu= porId(id);
            if(usu.isPresent()) {
                em.remove(usu.get());
                em.getTransaction().commit();
            }
        } catch(Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
