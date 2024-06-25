package sn.dev.projetimmo.dao.immeubles;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.dev.projetimmo.entities.Immeuble;

import java.util.List;

public class TestDao {
    public static void main(String[] args) {
        /*// Création de la factory d'EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

        // Création de l'EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Création d'un immeuble et sauvegarde
        Immeuble immeuble = new Immeuble();
        immeuble.setNom("sakho");
        immeuble.setAdresse("Fass");
        immeuble.setDescription("Bien-equipe");
        immeuble.setEquipements("3Etages");

        entityManager.getTransaction().begin();
        entityManager.persist(immeuble);
        entityManager.getTransaction().commit();

        System.out.println(immeuble);

        // Fermeture de l'EntityManager et de la factory
        entityManager.close();
        entityManagerFactory.close();*/
//------------------------------------------------------------
        // Création de la factory d'EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

// Création de l'EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

// Test de la méthode findAll()
        List<Immeuble> immeubles = entityManager.createQuery("SELECT i FROM Immeuble i", Immeuble.class).getResultList();

// Vérification que la liste n'est pas vide
        assert !immeubles.isEmpty();

// Affichage des immeubles
        for (Immeuble immeuble : immeubles) {
            System.out.println(immeuble);
        }

// Fermeture de l'EntityManager et de la factory
        entityManager.close();
        entityManagerFactory.close();
//------------------------------------------------------------


    /*    // Création de la factory d'EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

// Création de l'EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

// Création d'un nouvel immeuble et sauvegarde
        Immeuble immeuble = new Immeuble();
        immeuble.setNom("Immeuble de test");
        immeuble.setAdresse("Adresse de test");
        immeuble.setDescription("Description de test");
        immeuble.setEquipements("Equipements de test");

        entityManager.getTransaction().begin();
        entityManager.persist(immeuble);
        entityManager.getTransaction().commit();

// Test de la méthode findById(Long id)
        Immeuble recherchedImmeuble = entityManager.find(Immeuble.class, immeuble.getId());

// Vérification que l'immeuble récupéré est le même que celui créé
        assert recherchedImmeuble.equals(immeuble);

// Affichage de l'immeuble
        System.out.println(recherchedImmeuble);

// Fermeture de l'EntityManager et de la factory
        entityManager.close();
        entityManagerFactory.close();*/
//------------------------------------------------------------


       /* // Création de la factory d'EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

// Création de l'EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

// Création d'un nouvel immeuble et sauvegarde
        Immeuble immeuble = new Immeuble();
        immeuble.setNom("Immeuble de test");
        immeuble.setAdresse("Adresse de test");
        immeuble.setDescription("Description de test");
        immeuble.setEquipements("Equipements de test");

        entityManager.getTransaction().begin();
        entityManager.persist(immeuble);
        entityManager.getTransaction().commit();

// Modification de l'immeuble
        immeuble.setNom("Nouvel immeuble de test");
        immeuble.setDescription("Nouvelle description de test");

// Test de la méthode update(Immeuble immeuble)
        entityManager.getTransaction().begin();
        entityManager.merge(immeuble);
        entityManager.getTransaction().commit();

// Récupération de l'immeuble modifié
        Immeuble immeubleModifie = entityManager.find(Immeuble.class, immeuble.getId());

// Vérification que les modifications sont bien prises en compte
        assert immeubleModifie.getNom().equals("Nouvel immeuble de test");
        assert immeubleModifie.getDescription().equals("Nouvelle description de test");

// Affichage de l'immeuble modifié
        System.out.println(immeubleModifie);

// Fermeture de l'EntityManager et de la factory
        entityManager.close();
        entityManagerFactory.close();*/

//----------------------------------------------------------------

/*// Création de la factory d'EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

// Création de l'EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

// Création d'un nouvel immeuble et sauvegarde
        Immeuble immeuble = new Immeuble();
        immeuble.setNom("Immeuble de test");
        immeuble.setAdresse("Adresse de test");
        immeuble.setDescription("Description de test");
        immeuble.setEquipements("Equipements de test");

        entityManager.getTransaction().begin();
        entityManager.persist(immeuble);
        entityManager.getTransaction().commit();

// Test de la méthode delete(Immeuble immeuble)
        entityManager.getTransaction().begin();
        entityManager.remove(immeuble);
        entityManager.getTransaction().commit();

// Vérification que l'immeuble a bien été supprimé
        Immeuble immeubleSupprimeRecupere = entityManager.find(Immeuble.class, immeuble.getId());
        assert immeubleSupprimeRecupere == null;

// Affichage d'un message de confirmation
        System.out.println("L'immeuble a été supprimé avec succès.");

// Fermeture de l'EntityManager et de la factory
        entityManager.close();
        entityManagerFactory.close();*/
    }
}