package com.eoi.grupo5.repos;

import com.eoi.grupo5.models.Reserva;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class ReservaRepoImpl implements Repo<Reserva> {

    private EntityManager em;

    public ReservaRepoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Reserva> listar() {
        return em.createQuery("SELECT r FROM Reserva r", Reserva.class).getResultList();
    }

    @Override
    public Optional<Reserva> porId(Integer id) {
        return Optional.ofNullable(em.find(Reserva.class, id));
    }

    @Override
    public void guardar(Reserva reserva) {
        try {
            em.getTransaction().begin();
            if(reserva.getId() != null && reserva.getId() > 0) {
                em.merge(reserva);
            } else {
                em.persist(reserva);
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
            Optional<Reserva> reserva= porId(id);
            if(reserva.isPresent()) {
                em.remove(reserva.get());
                em.getTransaction().commit();
            }
        } catch(Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
