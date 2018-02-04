<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<html>
<head>
    <!-- stylesheet Css -->
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7/css/bootstrap-theme.min.css" rel="stylesheet">
    <style>
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #eee;
        }

        .form-group{
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
        }

        .form-group .form-signin-heading,
        .form-group .checkbox {
            margin-bottom: 10px;
        }

        .form-group .checkbox {
            font-weight: normal;
        }

        .form-group .form-control {
            position: relative;
            height: auto;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            padding: 10px;
            font-size: 16px;
        }

        .form-group .form-control:focus {
            z-index: 2;
        }

        .form-group input[type="email"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }

        .form-group input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }
    </style>
    <!-- End stylesheet Css -->

    <title>Login Page</title>
    <meta charset="UTF-8">

</head>

<body>
<div class="container">



    <div class="alert alert-danger">
        <strong>Danger!</strong><c:out value="${error}"/> Indicates a dangerous or potentially negative action.
    </div>






    <form class="form-group" name="loginForm" action="j_spring_security_check" method="post">
        <h2 class="form-signin-heading">Connecter Vous</h2>

        <label for="inputName" class="sr-only">Nom D'utilisateur</label>

        <input type="text" id="inputName" name="j_username" class="form-control" placeholder="Nom D'utilisateur" required autofocus>
        <br>
        <label for="inputPassword" class="sr-only">Mots De Passe</label>

        <input type="password" name="j_password" id="inputPassword" class="form-control" placeholder="Password" required>

        <div class="checkbox">

            <label>
                <input type="checkbox" name="_spring_security_remember_me" value="remember-me"> Souviens-toi De Moi
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Se Connecter</button>
    </form>

</div> <!-- /container -->


<!-- JavaScript -->
<script src="webjars/jquery/3.1.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- End JavaScript -->
</body>
</html>