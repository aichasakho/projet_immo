package sn.dev.projetimmo.web.immeubles;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.dev.projetimmo.dao.immeubles.IImmeubleDao;
import sn.dev.projetimmo.dao.immeubles.ImmeubleImplDao;
import sn.dev.projetimmo.entities.Immeuble;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "ImmeubleServlet", urlPatterns = {"/"})
public class ImmeubleServlet extends HttpServlet {
    private IImmeubleDao immeubleDao;

    @Override
    public void init() throws ServletException {
        // Initialisation de l'EntityManagerFactory et du ImmeubleDao
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        immeubleDao = new ImmeubleImplDao(entityManagerFactory);
    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* String path = request.getServletPath();

        if (path.equalsIgnoreCase("/list.jsp")){
            System.out.println("IMMO");

            request.getRequestDispatcher("/list.jsp").forward(request, response);

        }*/
       /* switch (action) {
            case "/":
                // Afficher la liste des immeubles
                System.out.println("immo");
                showImmeubleList(request, response);
                break;
            case "/search":
                // Rechercher des immeubles par mot-clé
                searchImmeubles(request, response);
                break;
            case "/add":
                // Afficher le formulaire d'ajout d'un immeuble
                showAddImmeuble(request, response);
                break;
            case "/edit":
                // Afficher le formulaire de modification d'un immeuble
                showEditImmeuble(request, response);
                break;
            default:
                // Si l'action n'est pas reconnue, renvoyer une erreur 404
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                break;*/
        }


    private void showImmeubleList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer la liste des immeubles depuis le DAO
        List<Immeuble> immeubles = immeubleDao.getImmeubleByMC("");
        System.out.println("IMMEUBLES" + immeubles) ;
        request.setAttribute("immeubles",immeubles);
        request.getRequestDispatcher("list.jsp").forward(request, response);

        /*// Créer un objet ImmeubleModel et le stocker dans la requête
        ImmeubleModel immeubleModel = new ImmeubleModel();
        immeubleModel.setImmeubles(immeubles);
        request.setAttribute("immeubles", immeubles);

        // Transférer le contrôle à la JSP list.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
        dispatcher.forward(request, response);*/
    }

    private void searchImmeubles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String motCle = request.getParameter("motCle");

        // Récupérer la liste des immeubles correspondant au mot-clé depuis le DAO
        List<Immeuble> immeubles = immeubleDao.getImmeubleByMC(motCle);

        // Créer un objet ImmeubleModel et le stocker dans la requête
        ImmeubleModel immeubleModel = new ImmeubleModel();
        immeubleModel.setImmeubles(immeubles);
        immeubleModel.setMotCle(motCle);
        request.setAttribute("ImmoModel", immeubleModel);

        // Transférer le contrôle à la JSP list.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
        dispatcher.forward(request, response);
    }
    private void showAddImmeuble(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Créer un objet Immeuble vide pour le formulaire d'ajout
        Immeuble immeuble = new Immeuble();

        // Créer un objet ImmeubleModel et le stocker dans la requête
        ImmeubleModel immeubleModel = new ImmeubleModel();
        immeubleModel.setImmeubles((List<Immeuble>) immeuble);
        request.setAttribute("ImmoModel", immeubleModel);

        // Transférer le contrôle à la JSP add.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditImmeuble(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer l'ID de l'immeuble à modifier depuis la requête
        int id = Integer.parseInt(request.getParameter("id"));

        // Récupérer l'immeuble correspondant depuis le DAO
        Immeuble immeuble = immeubleDao.getImmeubleById(id);

        // Créer un objet ImmeubleModel et le stocker dans la requête
        ImmeubleModel immeubleModel = new ImmeubleModel();
        immeubleModel.setImmeubles((List<Immeuble>) immeuble);
        request.setAttribute("ImmoModel", immeubleModel);

        // Transférer le contrôle à la JSP edit.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String action = request.getParameter("action");
        switch (action) {
            case "add":
                // Ajouter un nouvel immeuble
                addImmeuble(request, response);
                break;
            case "update":
                // Mettre à jour un immeuble existant
                updateImmeuble(request, response);
                break;
            case "delete":
                // Supprimer un immeuble
                deleteImmeuble(request, response);
                break;
        }*/

        doGet(request, response);
    }

    private void addImmeuble(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les données du formulaire d'ajout
        String nom = request.getParameter("nom");
        String adresse = request.getParameter("adresse");
        String description = request.getParameter("description");
        String  equipements = request.getParameter("equipements");

        // Créer un nouvel objet Immeuble et le persister dans la base de données via le DAO
        Immeuble immeuble = new Immeuble();
        immeuble.setNom(nom);
        immeuble.setAdresse(adresse);
        immeuble.setDescription(description);
        immeuble.setEquipements(equipements);

        immeubleDao.save(immeuble);

        // Rediriger vers la page de la liste des immeubles
        response.sendRedirect(request.getContextPath() + "/");
    }

    private void updateImmeuble(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les données du formulaire de modification
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String adresse = request.getParameter("adresse");
        String description = request.getParameter("description");
        String  equipements = request.getParameter("equipements");


        // Mettre à jour l'immeuble dans la base de données via le DAO
        Immeuble immeubleAModifier = immeubleDao.getImmeubleById(id);
        immeubleAModifier.setNom(nom);
        immeubleAModifier.setAdresse(adresse);
        immeubleAModifier.setDescription(description);
        immeubleAModifier.setEquipements(equipements);
        immeubleDao.update(immeubleAModifier);

        // Rediriger vers la page de la liste des immeubles
        response.sendRedirect(request.getContextPath() + "/");    }

    private void deleteImmeuble(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer l'ID de l'immeuble à supprimer
        int id = Integer.parseInt(request.getParameter("id"));

        // Supprimer l'immeuble de la base de données via le DAO
        Immeuble immeuble = immeubleDao.getImmeubleById(id);
        immeubleDao.delete(immeuble.getId());

        // Rediriger vers la page de la liste des immeubles
        response.sendRedirect(request.getContextPath() + "/");
    }


}