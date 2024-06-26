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
            <form action="update.php" method="post">
                <div hidden class="form-group">
                    <label>ID</label>
                    <input type="number" class="form-control" name="id" value="${immeuble.id}" hidden>
                </div>

                <div class="form-group">
                    <label>Nom</label>
                    <input type="text" class="form-control" value="${immeuble.nom}" name="nom" required>
                </div>
                <div class="form-group">
                    <label>Adresse</label>
                    <input type="text" class="form-control" value="${immeuble.adresse}" name="adresse" required>
                </div>
                <div class="form-group">
                    <label>Description</label>
                    <input type="text" class="form-control" value="${immeuble.description}" name="description" required>
                </div>
                <div class="form-group">
                    <label>Equipements</label>
                    <input type="text" class="form-control" value="${immeuble.equipements}" name="equipements" required>
                </div>
                <div class="center form-group">
                    <input class="btn btn-success"  name="modifier" value="Modifier">
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