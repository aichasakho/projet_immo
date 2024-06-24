package sn.dev.projetimmo.web;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.dev.projetimmo.dao.IImmeubleDao;
import sn.dev.projetimmo.dao.ImmeubleImplDao;
import sn.dev.projetimmo.entities.Immeuble;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ps", urlPatterns = {"*.php"})
public class ImmeubleServlet extends HttpServlet {

   private IImmeubleDao metier;
    @Override
    public void init(ServletConfig config) throws ServletException {
     metier = new ImmeubleImplDao();

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equalsIgnoreCase("/index.php")) {
            String motCle = "";
            List<Immeuble> immeubles = metier.getImmeubleByMC("%"+motCle+"%");
            ImmeubleModel model = new ImmeubleModel();
            model.setMotCle("");
            model.setImmeubles(immeubles);
            request.setAttribute("ImmoModel",model);
            request.getRequestDispatcher("list.jsp").forward(request, response);

        }else if(path.equalsIgnoreCase("/search.php")){
            String motCle = request.getParameter("motCle");
            List<Immeuble> immeubles = metier.getImmeubleByMC("%"+motCle+"%");
            ImmeubleModel model = new ImmeubleModel();
            model.setMotCle(motCle);
            model.setImmeubles(immeubles);
            request.setAttribute("ImmoModel",model);
            request.getRequestDispatcher("list.jsp").forward(request, response);

        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


}
