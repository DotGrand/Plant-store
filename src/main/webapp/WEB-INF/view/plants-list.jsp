<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="icon" href="${pageContext.request.contextPath}/resources/img/plant-in-the-ground.svg"
          type="image/icon type">
    <title>Plants</title>

    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
    />

    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>

<body class="body-back">

<div class="container">

    <!-- Navbar -->
    <nav class="navbar fixed-top navbar-expand-lg navbar navbar-light" style="background-color: #ffbb48;">
        <a class="navbar-brand mb-0 h1 animate__animated animate__pulse"
           href="${pageContext.request.contextPath}/plant/list">
            <img src="${pageContext.request.contextPath}/resources/img/plant-in-the-ground2.svg" width="30" height="30"
                 alt="">
            Plants</a>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/plant/addPlantForm">Add Plant<span
                            class="sr-only">(current)</span></a>
                </li>

                <security:authorize access="hasRole('ADMIN')">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/seller/list">Sellers<span
                                class="sr-only">(current)</span></a>
                    </li>
                </security:authorize>

                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/client/list">Clients</a>
                </li>

                <li class="nav-item dropdown ">
                    <a class="nav-link dropdown-toggle" href="${pageContext.request.contextPath}/order/list"
                       id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false">
                        Order Info
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/order/list">Order Info</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/order/showOrderedPlants">Ordered
                            Plants</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/order/showRejectedOrders">Rejected
                            Orders</a>
                    </div>
                </li>
            </ul>

            <!--  add a search box -->
            <form:form cssClass="form-inline my-2 my-lg-0 m-auto" action="searchPlant" method="GET">
                <div class="input-group">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search Plant" name="searchPlant"
                           aria-label="searchPlant">
                    <button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Search Plant</button>
                </div>
            </form:form>


            <security:authorize access="hasRole('ADMIN')">
                <a style="margin-right: 10px" href="${pageContext.request.contextPath}/register/showRegistrationForm"
                   class="btn btn-outline-dark"
                   role="button" aria-pressed="true">
                    Register New User
                </a>
            </security:authorize>

            <div class="ml-username">
                <security:authentication property="principal.username"/>
                <img src="${pageContext.request.contextPath}/resources/img/user.svg" width="20" height="20"/>
            </div>

            <form:form cssClass="ml-2" action="${pageContext.request.contextPath}/logout" method="post">
                <input class="btn btn-outline-danger ml-2" type="submit" value="Log out"/>
            </form:form>
        </div>
    </nav>
    <br><br><br><br>

    <!--add out html table here -->
    <h2 class="back-color">
        Plants
        <img src="${pageContext.request.contextPath}/resources/img/plant.svg" alt=""></h2>
    <hr>
    <table class="table table-bordered text-center">
        <thead style="background-color: #5cb85c;">
        <tr>
            <th style="width:5%">#</th>
            <th style="width:5%">Name</th>
            <th style="width:15%">Description</th>
            <th style="width: 4%">Price($)</th>
            <th style="width: 4%">Quantity</th>
            <th style="width: 20%">Action</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="tempPlant" items="${plants}">

            <c:url var="descriptionLink" value="/plant/showPlantDescription">
                <c:param name="plantId" value="${tempPlant.id}"/>
            </c:url>

            <c:url var="updateDescriptionLink" value="/plant/updateDescription">
                <c:param name="descriptionId" value="${tempPlant.description.id}"/>
            </c:url>

            <c:url var="updateLink" value="/plant/updatePlant">
                <c:param name="plantId" value="${tempPlant.id}"/>
            </c:url>

            <c:url var="deleteLink" value="/plant/deletePlant">
                <c:param name="plantId" value="${tempPlant.id}"/>
            </c:url>

            <c:url var="orderLink" value="/plant/orderPlant">
                <c:param name="plantId" value="${tempPlant.id}"/>
            </c:url>

            <c:url var="clientsLink" value="/plant/showPlantClients">
                <c:param name="plantId" value="${tempPlant.id}"/>
            </c:url>

            <tr class="table-light">
                <td>${tempPlant.id}</td>
                <td>${tempPlant.name}</td>
                <td>
                    <a class="btn btn-success btn-sm" href="${descriptionLink}">Description</a>
                </td>
                <td>${tempPlant.price}</td>
                <c:choose>
                    <c:when test="${tempPlant.quantity == 0}">
                        <td style="color: red">${tempPlant.quantity}</td>
                    </c:when>
                    <c:otherwise>
                        <td>${tempPlant.quantity}</td>
                    </c:otherwise>
                </c:choose>
                <td>
                    <div class="btn-group" role="group" aria-label="Basic example">
                        <a class="btn btn-outline-warning btn-sm" href="${orderLink}"
                           style="padding-left: 1.6rem; padding-right: 1.8rem;">Order Plant</a>
                        <a class="btn btn-outline-secondary btn-sm" href="${clientsLink}"
                           style="padding-left: 2.5rem; padding-right: 2.4rem;">Clients</a>
                    </div>
                    <div class="btn-group" role="group" aria-label="Basic example">
                        <a class="btn  btn-outline-success btn-sm" href="${updateLink}"
                           style="padding-left: 2.5rem; padding-right: 2.5rem;">Update</a>
                        <a class="btn  btn-outline-danger btn-sm" href="${deleteLink}"
                           style="padding-left: 2.5rem; padding-right: 2.5rem;"
                           onclick="if (!(confirm('Are you sure you want to delete this plant?'))) return false"
                        >Delete</a>
                    </div>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>

