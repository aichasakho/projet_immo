package sn.dev.projetimmo.dao.immeubles;

import sn.dev.projetimmo.entities.Immeuble;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import java.util.List;

public class ImmeubleImplDao implements IImmeubleDao {
    private final EntityManagerFactory entityManagerFactory;

    public ImmeubleImplDao(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Immeuble save(Immeuble immeuble) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(immeuble);
            entityManager.getTransaction().commit();
            return immeuble;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Immeuble> getImmeubleByMC(String mc) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            // Créer une requête JPQL pour récupérer les immeubles correspondant au mot-clé
            String queryString = "SELECT i FROM Immeuble i WHERE i.nom LIKE :mc OR i.adresse LIKE :mc OR i.description LIKE :mc";
            TypedQuery<Immeuble> query = entityManager.createQuery(queryString, Immeuble.class);
            query.setParameter("mc", "%" + mc + "%");

            // Exécuter la requête et récupérer la liste des immeubles
            List<Immeuble> immeubles = query.getResultList();
            return immeubles;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Immeuble getImmeubleById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Immeuble immeuble = entityManager.find(Immeuble.class, id);
            entityManager.getTransaction().commit();
            if (immeuble == null) {
                throw new EntityNotFoundException("Immeuble with ID " + id + " not found.");
            }
            return immeuble;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public int update(Immeuble immeuble) {
        int ok = 1;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Immeuble managedImmeuble = entityManager.merge(immeuble);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
        return ok;
    }

    @Override
    public int delete(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Immeuble immeuble = getImmeubleById(id);
            entityManager.remove(immeuble);
            entityManager.getTransaction().commit();
            return 1;
        } catch (EntityNotFoundException e) {
            entityManager.getTransaction().rollback();
            return 0;
        } finally {
            entityManager.close();
        }
    }


}