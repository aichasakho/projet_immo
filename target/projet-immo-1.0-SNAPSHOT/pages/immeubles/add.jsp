<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Page d'Ajout</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link type="text/css" rel= "stylesheet" href="css/bootstrap.min.css">
    <link type="text/css" rel= "stylesheet" href="css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">

</head>
    <body>
    <%@include file="../../navbar.jsp"%>
    <div class="spacer  mt-5 container col-md-6 col-md-offset-1">
        <div class="card">
            <div class=" center card-header bg-green">Ajout d'un immeubles</div>
            <div class="card-body">
                <form action="immeuble?action=add" method="post">
                    <div class="form-group">
                        <label>Nom</label>
                        <input type="text" id="nom" class="form-control" name="nom" required>
                    </div>
                    <div class="form-group">
                        <label>Adresse</label>
                        <input type="text" id="adresse" class="form-control" name="adresse" required>
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <textarea id="description" class="form-control" name="description" required></textarea>
                    </div>
                    <div class="form-group">
                        <label>Equipements</label>
                        <textarea id="equipements" name="equipements" class="form-control" required></textarea>
                    </div>
                    <div class="center form-group">
                        <input class="btn btn-success"  type="submit" name="valider" value="Enregistrer">
                        <input class="btn btn-danger" type="reset"  name="annuler" value="Annuler">

                    </div>

                </form>

                </div>
            </div>


        </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    </body>
</html>
