<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <title>Sakho IMMO | Liste</title>
    <link type="text/css" rel= "stylesheet" href="css/bootstrap.min.css">
    <link type="text/css" rel= "stylesheet" href="css/style.css">

</head>
    <body>
        <%@include file="navbar.jsp"%>
        <div class="spacer center mt-5 container col-md-10 col-md-offset-1">
           <div class="card">
               <div class="card-header">Liste des immeubles</div>
                   <div class="card-body">
                       <form class="center" action="search.php" method="get">
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
                           <c:forEach items="${immeubles }" var="immeuble">
                               <tr>
                                   <td>${immeuble.id}</td>
                                   <td>${immeuble.nom}</td>
                                   <td>${immeuble.adresse}</td>
                                   <td>${immeuble.description}</td>
                                   <td>${immeuble.equipements}</td>
                                   <td>
                                       <a class="btn btn-outline-success btn-sm" href="edit.php?id=${m.id}">Modifier</a>
                                       <a type="button" onclick="return confirm('Voulez-vous vraiment supprimer cet immeuble ?')" class="btn btn-outline-danger btn-sm" href="delete.php?id=${m.id}">Supprimer</a>
                                   </td>
                               </tr>
                           </c:forEach>
                       </table>
                       <a class="btn btn-success" href="pages/immeubles/add.jsp">Ajouter </a>



                   </div>
           </div>
        </div>

    </body>
</html>
