package sn.dev.projetimmo.dao;

import sn.dev.projetimmo.entities.Immeuble;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class ImmeubleImplDao implements IImmeubleDao {
    @PersistenceContext
    private EntityManager entityManager;

    public ImmeubleImplDao() {
        this.entityManager = entityManager;
    }
    @Override
    public Immeuble save(Immeuble immeuble) {
        entityManager.getTransaction().begin();
        entityManager.persist(immeuble);
        entityManager.getTransaction().commit();
        return immeuble;
    }

    @Override
    public List<Immeuble> getImmeubleByMC(String mc) {
        entityManager.getTransaction().begin();
        String query = "SELECT i FROM Immeuble i WHERE i.nom LIKE :mc OR i.adresse LIKE :mc";
        TypedQuery<Immeuble> q = entityManager.createQuery(query, Immeuble.class);
        q.setParameter("mc", "%" + mc + "%");
        List<Immeuble> resultList = q.getResultList();
        entityManager.getTransaction().commit();
        return resultList;
    }

    @Override
    public Immeuble getImmeubleById(int id) {
        entityManager.getTransaction().begin();
        Immeuble immeuble = entityManager.find(Immeuble.class, id);
        entityManager.getTransaction().commit();
        if (immeuble == null) {
            throw new EntityNotFoundException("Immeuble with ID " + id + " not found.");
        }
        return immeuble;
    }

    @Override
    public int update(Immeuble immeuble) {
        entityManager.getTransaction().begin();
        Immeuble managedImmeuble = entityManager.merge(immeuble);
        entityManager.getTransaction().commit();
        return 1;
    }

    @Override
    public int delete(int id) {
        try {
            entityManager.getTransaction().begin();
            Immeuble immeuble = getImmeubleById(id);
            entityManager.remove(immeuble);
            entityManager.getTransaction().commit();
            return 1;
        } catch (EntityNotFoundException e) {
            entityManager.getTransaction().rollback();
            return 0;
        }
    }
}