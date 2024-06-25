
<html>
<head>
    <title>Sakho IMMO | Ajout</title>
    <link type="text/css" rel= "stylesheet" href="../../css/bootstrap.min.css">
    <link type="text/css" rel= "stylesheet" href="../../css/style.css">
</head>
    <body>
    <%@include file="../../navbar.jsp"%>
    <div class="spacer  mt-5 container col-md-6 col-md-offset-1">
        <div class="card">
            <div class=" center card-header bg-green">Ajout d'un immeubles</div>
            <div class="card-body">
                <form action="save.php" method="post">
                    <div class="form-group">
                        <label>Nom</label>
                        <input type="text" class="form-control" name="nom" required>
                    </div>
                    <div class="form-group">
                        <label>Adresse</label>
                        <input type="text" class="form-control" name="adresse" required>
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <input type="text" class="form-control" name="description" required>
                    </div>
                    <div class="form-group">
                        <label>Equipements</label>
                        <input type="text" class="form-control" name="equipements" required>
                    </div>
                    <div class="center form-group">
                        <input class="btn btn-success"  name="valider" value="Enregistrer">
                        <input class="btn btn-danger" type="reset"  name="annuler" value="Annuler">

                    </div>

                </form>

                </div>
            </div>


        </div>


    </body>
</html>
