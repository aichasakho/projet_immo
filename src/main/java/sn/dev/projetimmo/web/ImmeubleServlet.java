package sn.dev.projetimmo.web;


import sn.dev.projetimmo.dao.immeubles.IImmeubleDao;
import sn.dev.projetimmo.dao.immeubles.ImmeubleImplDao;
import sn.dev.projetimmo.entities.Immeuble;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "ImmeubleServlet", urlPatterns = "/immeuble")
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
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        try {
            switch (action) {
                case "add":
                    showAddImmeuble(request, response);
                    break;
                case "edit":
                    showEditImmeuble(request, response);
                    break;
                case "delete":
                    deleteImmeuble(request, response);
                    break;
                case "details":
                    showDetails(request, response);
                    break;
                case "search":
                    searchImmeubles(request, response);
                    break;
                default:
                    showImmeubleList(request, response);
                    break;
            }
        } catch (Exception e) {
            // Si l'action n'est pas reconnue, renvoyer une erreur 404
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }


    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        try {
            switch (action) {
                case "add":
                    addImmeuble(request, response);
                    break;
                case "edit":
                    updateImmeuble(request, response);
                    break;
                case "delete":
                    deleteImmeuble(request, response);
                    break;
                default:
                    showImmeubleList(request, response);
                    break;
            }
        } catch (Exception e) {
            // Si l'action n'est pas reconnue, renvoyer une erreur 404
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        doGet(request, response);
    }

    private void showImmeubleList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer la liste des immeubles depuis le DAO
        List<Immeuble> immeubles = immeubleDao.getImmeubleByMC("");
        request.setAttribute("immeubles", immeubles);

        // Transférer le contrôle à la JSP list.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
        dispatcher.forward(request, response);
    }

    private void searchImmeubles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String motCle = request.getParameter("motCle");
        // Récupérer la liste des immeubles correspondant au mot-clé depuis le DAO
        List<Immeuble> immeubles = immeubleDao.getImmeubleByMC(motCle);
        // Créer un objet Immeuble et le stocker dans la requête
        Immeuble Immeuble = new Immeuble();
        request.setAttribute("immeubles", immeubles);
        // Transférer le contrôle à la JSP list.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
        dispatcher.forward(request, response);
    }


    private void showAddImmeuble(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pages/immeubles/add.jsp").forward(request, response);

    }

    private void showEditImmeuble(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Récupérer l'ID de l'immeuble à modifier depuis la requête
            int id = Integer.parseInt(request.getParameter("id"));

            // Récupérer l'immeuble correspondant depuis le DAO
            Immeuble immeuble = immeubleDao.getImmeubleById(id);
            request.setAttribute("immeubles", immeuble);
            request.getRequestDispatcher("/pages/immeubles/edit.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Immeuble ID");
        }

    }

    private void showDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            Immeuble immeuble = immeubleDao.getImmeubleById(id);
            request.setAttribute("immeubles", immeuble);
            request.getRequestDispatcher("/pages/immeubles/details.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Immeuble ID");
        }
    }

    private void addImmeuble(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Récupérer les données du formulaire d'ajout
            String nom = request.getParameter("nom");
            String adresse = request.getParameter("adresse");
            String description = request.getParameter("description");
            String equipements = request.getParameter("equipements");

            // Créer un nouvel objet Immeuble et le persister dans la base de données via le DAO
            Immeuble immeuble = new Immeuble();
            immeuble.setNom(nom);
            immeuble.setAdresse(adresse);
            immeuble.setDescription(description);
            immeuble.setEquipements(equipements);

            immeubleDao.save(immeuble);
            // Rediriger vers la page de la liste des immeubles
            response.sendRedirect("immeuble?action=list");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        }
    }


    private void updateImmeuble(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // Récupérer les données du formulaire de modification

            int id = Integer.parseInt(request.getParameter("id"));
            String nom = request.getParameter("nom");
            String adresse = request.getParameter("adresse");
            String description = request.getParameter("description");
            String equipements = request.getParameter("equipements");

            // Mettre à jour l'immeuble dans la base de données via le DAO
            Immeuble immeubleAModifier = immeubleDao.getImmeubleById(id);
            immeubleAModifier.setNom(nom);
            immeubleAModifier.setAdresse(adresse);
            immeubleAModifier.setDescription(description);
            immeubleAModifier.setEquipements(equipements);
            immeubleDao.update(immeubleAModifier);
            response.sendRedirect("immeuble?action=list");
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Immeuble ID");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        }
    }

    private void deleteImmeuble(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Récupérer l'ID de l'immeuble à supprimer
            int id = Integer.parseInt(request.getParameter("id"));

            // Supprimer l'immeuble de la base de données via le DAO
            Immeuble immeuble = immeubleDao.getImmeubleById(id);
            immeubleDao.delete(immeuble.getId());
            response.sendRedirect("immeuble?action=list");
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Immeuble ID");
        }


    }
}