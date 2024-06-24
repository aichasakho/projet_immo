<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sakho IMMO | Liste</title>
    <link type="text/css" rel= "stylesheet" href="css/bootstrap.min.css">
    <link type="text/css" rel= "stylesheet" href="css/style.css">

</head>
<body>
    <div class="container col-md-10 col-md-offset-1">
       <div class="card">
           <div class="card-header">Liste des immeubles</div>
           <div class="card-body">
               <form action="search.php" method="get">
                   <div class="form-group">
                       <label>Mot Cle</label>
                       <input type="text" name="motCle" placeholder="Entrez votre recherche">
                       <button type="submit" class="btn btn-success">Rechercher</button>
                   </div>
               </form>
               <table class="mt-3 table table-striped table-bordered">
                   <tr>
                       <th>ID</th>
                       <th>Nom</th>
                       <th>Adresse</th>
                       <th>Description</th>
                       <th>Equipements</th>
                       <th colspan="2">Action</th>
                   </tr>
                   
                       <c:forEach items="${ImmoModel.immeubles}" var="m">
                           <tr>
                               <td>${m.id}</td>
                               <td>${m.nom}</td>
                               <td>${m.adresse}</td>
                               <td>${m.description}</td>
                               <td>${m.equipements}</td>
                               <td>

                               </td>
                           </tr>
                           
                       </c:forEach>
                   
               </table>

       </div>
    </div>

</body>
</html>
