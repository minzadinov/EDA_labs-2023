package com.example.lab1.services;

import com.example.lab1.entities.Command;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@Stateless
@Transactional
public class CommandService {
    @PersistenceContext
    private EntityManager em;

    public void persist(Command entity) {
        em.persist(entity);
    }

    public List<Command> findAll() {
        return em.createQuery("select i from Command i",
                Command.class).getResultList();
    }

    public void delete(Long commandId) throws Exception {
//        em.remove(em.find(Command.class, commandId));
        var command = em.find(Command.class, commandId);
        em.remove(em.contains(command) ? command : em.merge(command));
    }

    public Command findById(Long id) {
        return em.find(Command.class, id);
    }
}
