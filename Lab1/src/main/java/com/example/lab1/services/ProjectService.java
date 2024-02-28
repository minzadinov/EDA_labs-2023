package com.example.lab1.services;

import com.example.lab1.entities.Project;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@Stateless
@Transactional
public class ProjectService {
    @PersistenceContext
    private EntityManager em;

    public void persist(Project entity) {
        em.persist(entity);
    }

    public List<Project> findAll() {
        return em.createQuery("select i from Project i",
                Project.class).getResultList();
    }

    public void delete(Long projectId) throws Exception {
        em.remove(em.find(Project.class, projectId));
    }

    public Project findById(Long id) {
        return em.find(Project.class, id);
    }
}
