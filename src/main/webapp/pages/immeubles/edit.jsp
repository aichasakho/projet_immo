<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Page de modification</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link type="text/css" rel= "stylesheet" href="css/bootstrap.min.css">
    <link type="text/css" rel= "stylesheet" href="css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">

</head>
<body>
<%@include file="../../navbar.jsp"%>
<div class="spacer  mt-5 container col-md-6 col-md-offset-1">
    <div class="card">
        <div class=" center card-header bg-green">Modification d'un immeubles</div>
        <div class="card-body">
            <br>
            <a href="immeuble?action=list" class="btn btn-secondary">Retour à la liste</a>
            <br><br>
            <form action="immeuble?action=edit" method="post">
                    <input type="hidden"  name="id" value="${immeuble.id}">

                <div class="form-group">
                    <label for="nom">Nom:</label>
                    <input type="text" id="nom" name="nom" class="form-control" value="${immeuble.nom}" required>
                </div>
                <div class="form-group">
                    <label for="adresse">Adresse:</label>
                    <input type="text" id="adresse" name="adresse" class="form-control" value="${immeuble.adresse}" required>
                </div>
                <div class="form-group">
                    <label for="description">Description:</label>
                    <textarea id="description" name="description" class="form-control" required>${immeuble.description}</textarea>
                </div>
                <div class="form-group">
                    <label for="equipements">Équipements:</label>
                    <textarea id="equipements" name="equipements" class="form-control" required>${immeuble.equipements}</textarea>
                </div>
                <div class="center form-group">
                    <button type="submit" class="btn btn-success">Modifier</button>
                    <button type="reset" class="btn btn-danger">Annuler</button>

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