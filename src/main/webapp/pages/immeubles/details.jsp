<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sakho IMMO | Liste</title>
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
            <div class="card-body">
                <div>
                    <label>ID</label>
                    <code>${immeuble.id}</code>
                </div>
                <div>
                    <label>ID</label>
                    <code>${immeuble.nom}</code>
                </div>
                <div>
                    <label>ID</label>
                    <code>${immeuble.adresse}</code>
                </div>
                <div>
                    <label>ID</label>
                    <code>${immeuble.description}</code>
                </div>
                <div>
                    <label>ID</label>
                    <code>${immeuble.equipements}</code>
                </div>
                <div class="center">
                    <a class="btn btn-outline-dark" href="immeuble?action=list">Retour à la liste</a>
                    <a class="btn btn-outline-dark" href="immeuble?action=add">Retour au formulaire d'ajout</a>

                </div>


            </div>
        </div>


    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    </body>
</html>
