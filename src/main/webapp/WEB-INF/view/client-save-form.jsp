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
    <title>Client Save Form</title>

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
        <a class="navbar-brand mb-0 h1"
           href="${pageContext.request.contextPath}/plant/list">
            <img src="${pageContext.request.contextPath}/resources/img/plant-in-the-ground2.svg" width="30" height="30"
                 alt="">
            Plants</a>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ">
                <li class="nav-item animate__animated animate__pulse">
                    <a class="nav-link" href="${pageContext.request.contextPath}/client/addClientForm">Add Client<span
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
            <form:form cssClass="form-inline my-2 my-lg-0 m-auto" action="searchClient" method="GET">
                <div class="input-group">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search Client" name="searchClient"
                           aria-label="searchClient">
                    <button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Search Client</button>
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

    <div class="add-form">

        <form:form cssClass="save-form" action="${pageContext.request.contextPath}/client/saveClient"
                   modelAttribute="client" method="post">
            <form:hidden path="id"/>

            <h2>Save New Client</h2>
            <hr>

            <label>First Name</label>
            <div class="form-inline">
                <form:input cssClass="form-control mb-4 col-4 mr-2" placeholder="First Name" path="firstName"/>
                <form:errors cssClass="error" path="firstName"/>
            </div>

            <label>Last Name</label>
            <div class="form-inline">
                <form:input cssClass="form-control mb-4 col-4 mr-2" placeholder="Last Name" path="lastName"/>
                <form:errors cssClass="error" path="lastName"/>
            </div>

            <label>Phone</label>
            <div class="form-inline">
                <form:input cssClass="form-control mb-4 col-4 mr-2" placeholder="000-000-0000" path="phone"/>
                <form:errors cssClass="error" path="phone"/>
            </div>

            <label>Email</label>
            <div class="form-inline">
                <form:input cssClass="form-control mb-4 col-4 mr-2" placeholder="Email" path="email"/>
                <form:errors cssClass="error" path="email"/>
            </div>

            <div class="form-group">
                <label>City</label>
                <form:select cssClass="form-control mb-4 col-4" path="city">
                    <form:option value="New York">New York</form:option>
                    <form:option value="Los Santos">Los Santos</form:option>
                    <form:option value="Washington">Washington</form:option>
                </form:select>
            </div>
            <div class="form-group">
                <label>Gender</label>
                <form:select cssClass="form-control mb-4 col-4" path="gender">
                    <form:option value="Male">Male</form:option>
                    <form:option value="Female">Female</form:option>
                    <form:option value="Other">Other</form:option>
                </form:select>
            </div>

            <label>Registration Date</label>
            <div class="form-inline">
                <form:input cssClass="form-control mb-4 col-4 mr-2" placeholder="yyyy-mm-dd" path="registrationDate"/>
                <form:errors cssClass="error" path="registrationDate"/>
            </div>

            <div>
                <a class="btn btn-success" href="${pageContext.request.contextPath}/client/list">Back</a>
                <input class="btn btn-warning col-2" type="submit" value="Save"/>
            </div>

        </form:form>
    </div>
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