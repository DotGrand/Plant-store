<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login-page-style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="icon" href="${pageContext.request.contextPath}/resources/img/plant-in-the-ground.svg"
          type="image/icon type">
    <title>Login Page</title>

    <!-- Reference Bootstrap files -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


</head>

<body class="body-back">

<div class="container">
    <section class="vh-100">
        <div class="container-fluid h-custom">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-md-4 col-lg-5 col-xl-3">
                    <img src="${pageContext.request.contextPath}/resources/img/plant-in-the-ground3.svg" alt="img">
                </div>

                <div class="col-md-4 col-lg-6 col-xl-4 offset-xl-1 login-form">
                    <div class="divider d-flex align-items-center ">
                        <h1><p class="text-center fw-bold mx-3 mb-0">Login</p></h1>
                    </div>
                    <br>
                    <form:form action="${pageContext.request.contextPath}/authenticate" method="POST">
                        <c:if test="${param.error != null}">
                            <div class="alert alert-danger m-2" role="alert">
                                <b>Wrong username or password!</b>
                            </div>
                        </c:if>

                        <c:if test="${param.logout != null}">
                            <div class="alert alert-info m-2" role="alert">
                                <b>Logged out!</b>
                            </div>
                        </c:if>


                        <div class="form-group">
                            <input type="text" class="form-control form-control-lg" id="username"
                                   placeholder="Enter username"
                                   name="username"/>
                        </div>

                        <div class="form-group">
                            <input class="form-control form-control-lg" type="password" id="password"
                                   placeholder="Enter password"
                                   name="password"/>
                        </div>

                        <br>

                        <div class="text-center text-lg-start mt-4 pt-2">
                            <button type="submit" class="btn btn-success btn-sm"
                                    style="padding-left: 2.5rem; padding-right: 2.5rem;">Login
                            </button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </section>
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