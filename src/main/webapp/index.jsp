<%@ page import="metier.User" %>
<html>
<head>
    <title>Our Project Welcome Page</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/fonts/iconic/css/material-design-iconic-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/util.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
    <!--===============================================================================================-->
</head>
<body>
<div class="limiter">
    <div class="container-login100" style="background-image: url('images/1.png');">
        <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
            <form method="post" action="login" class="login100-form validate-form">
					<span class="login100-form-title p-b-49">
						Sign In
					</span>
                <h6 class="text-center text-white pt-5 text-danger">
                    <%
                        if(request.getAttribute("error") != null) {
                            out.print(request.getAttribute("error"));
                        }
                        User user = (User) session.getAttribute("user");
                        if(user != null) {
                            if(user.getRole().equals("admin")) {
                                response.sendRedirect("allUsers");
                            }else{
                                response.sendRedirect("allArticle");
                            }
                        }
                    %>
                </h6>

                <div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reauired">
                    <span class="label-input100">Username</span>
                    <input class="input100" type="text" name="email" placeholder="Type your username">
                    <span class="focus-input100" data-symbol="&#xf206;"></span>
                </div>

                <div class="wrap-input100 validate-input" data-validate="Password is required">
                    <span class="label-input100">Password</span>
                    <input class="input100" type="password" name="password" placeholder="Type your password">
                    <span class="focus-input100" data-symbol="&#xf190;"></span>
                </div>

                <div class="container-login100-form-btn">
                    <div class="wrap-login100-form-btn">
                        <div class="login100-form-bgbtn"></div>
                        <button class="login100-form-btn">
                            Login
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>


<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
<script src="./vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="./vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="./vendor/bootstrap/js/popper.js"></script>
<script src="./vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="./vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="./vendor/daterangepicker/moment.min.js"></script>
<script src="./vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="./vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="./js/main.js"></script>

</body>

</html>
