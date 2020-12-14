<%--
  Created by IntelliJ IDEA.
  User: Ahmed
  Date: 12/8/2020
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"
          prefix="c" %>
<html>
<head>
    <title>All Articles Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body,html{
            background-color: #1d2124;
            color: #ffffff;
        }
    </style>
</head>
<body>
<!--Navbar-->
<nav class="navbar navbar-dark bg-primary navbar-expand-lg">
    <a class="navbar-brand" href="#">Around The World</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="fetchPanier">Articles <span class="sr-only">(current)</span></a>
            </li>
        </ul>
    </div>
</nav>
<div class="container mt-2">
    <form action="fetchPanier" method="get">
        <div class="row">
            <div class="col-9 active-purple-4 mb-4">
                <input class="form-control" type="text" name="code" placeholder="Search" aria-label="Search">
            </div>
            <div class="col-3 row">
                <a href="allArticle?code=">
                    <button type="submit" class="btn btn-primary">Search By Code </button>
                </a>
            </div>
        </div>

    </form>

    <form action="fetchPanier" method="get">
        <div class="row">
            <div class="col-9 active-purple-4 mb-4">
                <input class="form-control" type="text" name="name" placeholder="Search" aria-label="Search">
            </div>
            <div class="col-3 row">
                <a>
                    <button type="submit" class="btn btn-primary">Search By Name </button>
                </a>
            </div>
        </div>

    </form>

    <div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Code</th>
                <th scope="col">Name</th>
                <th scope="col">Price</th>
                <th scope="col">Description</th>
                <th scope="col">Actions</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${allArticles}" var="article">
                <tr>
                    <td>${article.code}</td>
                    <td>${article.name}</td>
                    <td>${article.price}</td>
                    <td>${article.description}</td>
                    <td>
                        <a href="addToPanier?articleId=${article.id}">
                            <button class="btn btn-primary">Add To Basket <i class="fa fa-plus"></i></button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="row">
        <a href="fetchPanier?tri=true">
            <button class="btn btn-primary ml-1">Sort Articles</button>
        </a>
    </div>

    <div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Code</th>
                <th scope="col">Name</th>
                <th scope="col">Price</th>
                <th scope="col">Description</th>
                <th scope="col">Actions</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${panier}" var="article">
                <tr>
                    <td>${article.code}</td>
                    <td>${article.name}</td>
                    <td>${article.price}</td>
                    <td>${article.description}</td>
                    <td>
                        <a href="deleteFromPanier?articleId=${article.id}">
                            <button class="btn btn-danger"><i class="fa fa-trash"></i></button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="row">
        <a href="disconnect">
            <button class="btn btn-danger mt-2">Disconnect <i class="fa fa-sign-out"></i></button>
        </a>
    </div>
</div>

</body>
</html>
