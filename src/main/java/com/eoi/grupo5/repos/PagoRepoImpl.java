package com.eoi.grupo5.repos;

import com.eoi.grupo5.models.Pago;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class PagoRepoImpl implements Repo<Pago> {

    private EntityManager em;

    public PagoRepoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Pago> listar() {
        return em.createQuery("SELECT p FROM Pago p", Pago.class).getResultList();
    }

    @Override
    public Optional<Pago> porId(Integer id) {
        return Optional.ofNullable(em.find(Pago.class, id));
    }

    @Override
    public void guardar(Pago pago) {
        try {
            em.getTransaction().begin();
            if(pago.getId() != null && pago.getId() > 0) {
                em.merge(pago);
            } else {
                em.persist(pago);
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
            Optional<Pago> pago= porId(id);
            if(pago.isPresent()) {
                em.remove(pago.get());
                em.getTransaction().commit();
            }
        } catch(Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
