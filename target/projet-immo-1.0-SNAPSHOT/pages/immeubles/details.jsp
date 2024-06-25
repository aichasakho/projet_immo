
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Sakho IMMO | Liste</title>
    <link type="text/css" rel= "stylesheet" href="../../css/bootstrap.min.css">
    <link type="text/css" rel= "stylesheet" href="../../css/style.css">

</head>
    <body>
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
                    <a class="btn btn-outline-dark" href="index.php">Retour à la liste</a>
                    <a class="btn btn-outline-dark" href="add.php">Retour au formulaire d'ajout</a>

                </div>


            </div>
        </div>


    </div>


    </body>
</html>
