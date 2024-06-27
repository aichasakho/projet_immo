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
<%@include file="navbar.jsp"%>
<div class="spacer center mt-5 container col-md-10 col-md-offset-1">
    <div class="card">
        <div class="card-header">Liste des immeubles</div>
        <div class="card-body">
            <form class="center" action="immeuble?action=search" method="get">
                <div class="form-group">
                    <label>Mot Cle</label>
                    <input type="text" name="motCle" placeholder="Entrez votre recherche">
                    <button type="submit" class="btn btn-secondary">Rechercher</button>
                </div>
            </form>
            <table class="center mt-3 table table-striped table-bordered">
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Adresse</th>
                    <th>Description</th>
                    <th>Equipements</th>
                    <th colspan="2">Action</th>
                </tr>
                <c:forEach items="${immeubles}" var="immeuble">
                    <tr>
                        <td>${immeuble.id}</td>
                        <td>${immeuble.nom}</td>
                        <td>${immeuble.adresse}</td>
                        <td>${immeuble.description}</td>
                        <td>${immeuble.equipements}</td>
                        <td class="btn align-items-center">
                                <a href="immeuble?action=details&id=${immeuble.id}" class="btn btn-info btn-sm btn-margin align-items-center"><i class="bi bi-info-circle"></i></a>
                                <a href="immeuble?action=edit&id=${immeuble.id}" class="btn btn-warning btn-sm btn-margin align-items-center"><i class="bi bi-pencil-square"></i></a>
                                <a href="immeuble?action=delete&id=${immeuble.id}" class="btn btn-danger btn-sm align-items-center" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet immeuble?');"><i class="bi bi-trash"></i></a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <a class="btn btn-success" href="immeuble?action=add">Ajouter </a>



        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>