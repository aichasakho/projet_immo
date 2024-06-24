package sn.dev.projetimmo.dao;

import sn.dev.projetimmo.entities.Immeuble;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class ImmeubleImplDao implements IImmeubleDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Immeuble save(Immeuble immeuble) {
        entityManager.persist(immeuble);
        return immeuble;
    }

    @Override
    public List<Immeuble> getImmeubleByMC(String mc) {
        String query = "SELECT i FROM Immeuble i WHERE i.nom LIKE :mc OR i.adresse LIKE :mc";
        TypedQuery<Immeuble> q = entityManager.createQuery(query, Immeuble.class);
        q.setParameter("mc", "%" + mc + "%");
        return q.getResultList();
    }

    @Override
    public Immeuble getImmeubleById(int id) {
        return entityManager.find(Immeuble.class, id);
    }

    @Override
    public int update(Immeuble immeuble) {
        Immeuble immeubleToUpdate = entityManager.merge(immeuble);
        entityManager.persist(immeubleToUpdate);
        return 1;
    }

    @Override
    public int delete(int id) {
        Immeuble immeuble = entityManager.find(Immeuble.class, id);
        entityManager.remove(immeuble);
        return 1;
    }
}