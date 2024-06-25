<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sakho IMMO | Modidification</title>
    <link type="text/css" rel= "stylesheet" href="../../css/bootstrap.min.css">
    <link type="text/css" rel= "stylesheet" href="../../css/style.css">
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


</body>
</html>
