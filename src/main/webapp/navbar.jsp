<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a href="#" class="navbar-brand">SAKHO IMMO</a>
    <div class="navbar-nav">
        <a class="nav-item nav-link" href="immeuble/add">Ajouter un immeuble</a>
        <a class="nav-item nav-link" href="immeuble">Liste des immeubles</a>

    </div>
</nav>

-------------
<%--
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/home">Locations Immeubles</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/immeuble">Immeubles</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/unites">Unités</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/contact">Contact</a>
                </li>
                <c:if test="${empty locataire}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/login">Se Connecter <i class="fas fa-sign-in-alt"></i></a> <!-- Icone Font Awesome pour Se Connecter -->
                    </li>
                </c:if>
                <c:if test="${not empty locataire}">
                    <li class="nav-item">
                        <form action="${pageContext.request.contextPath}/logout" method="post">
                            <button type="submit" class="btn btn-link nav-link">Se Déconnecter <i class="fas fa-sign-out-alt"></i></button> <!-- Icone Font Awesome pour Se Déconnecter -->
                        </form>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
--%>
