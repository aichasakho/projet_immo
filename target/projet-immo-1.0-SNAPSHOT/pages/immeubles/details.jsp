<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sakho IMMO | Détails</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link type="text/css" rel= "stylesheet" href="css/bootstrap.min.css">
    <link type="text/css" rel= "stylesheet" href="css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">

</head>
    <body>
    <%@include file="../../navbar.jsp"%>
    <div class="spacer  mt-5 container col-md-6 col-md-offset-1">
        <div class="card">
            <div class=" center card-header bg-green">Détail d'un immeuble</div>
            <table class="table">
                <tr>
                    <th scope="row">Nom:</th>
                    <td>${immeuble.nom}</td>
                </tr>
                <tr>
                    <th scope="row">Adresse:</th>
                    <td>${immeuble.adresse}</td>
                </tr>
                <tr>
                    <th scope="row">Description:</th>
                    <td>${immeuble.description}</td>
                </tr>
                <tr>
                    <th scope="row">Equipements:</th>
                    <td>${immeuble.equipements}</td>
                </tr>
            </table>
            <a href="immeuble?action=list" class="btn btn-secondary">Retour à la liste</a>

            </div>
        </div>


    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    </body>
</html>
