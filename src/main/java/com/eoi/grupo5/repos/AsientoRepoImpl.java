package com.eoi.grupo5.repos;

import com.eoi.grupo5.models.Asiento;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class AsientoRepoImpl implements Repo<Asiento>{

    private EntityManager em;

    public AsientoRepoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Asiento> listar() {
        return em.createQuery("SELECT a FROM Asiento a", Asiento.class).getResultList();
    }

    @Override
    public Optional<Asiento> porId(Integer id) {
        return Optional.ofNullable(em.find(Asiento.class, id));
    }

    @Override
    public void guardar(Asiento asiento) {
        try {
            em.getTransaction().begin();
            if(asiento.getId() != null && asiento.getId() > 0) {
                em.merge(asiento);
            } else {
                em.persist(asiento);
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
            Optional<Asiento> asi= porId(id);
            if(asi.isPresent()) {
                em.remove(asi.get());
                em.getTransaction().commit();
            }
        } catch(Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
