<%--
  Created by IntelliJ IDEA.
  User: Ahmed
  Date: 12/8/2020
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Article</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        body,html{
            background-color: #1d2124;
            color: #ffffff;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-dark bg-primary navbar-expand-lg">
    <a class="navbar-brand" href="#">Admin Management</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="allUsers">Users <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="allArticle">Articles</a>
            </li>
        </ul>
    </div>
</nav>
<div class="container">

    <form action="updateArticle" method="post">
        <div hidden class="form-group row">
            <label for="id" class="col-sm-2 col-form-label">Description</label>
            <div class="col-sm-10">
                <input value="${article.id}" type="text" name="id" class="form-control" id="id" placeholder="Enter Article Description">
            </div>
        </div>
        <div class="form-group row">
            <label for="code" class="col-sm-2 col-form-label">Code</label>
            <div class="col-sm-10">
                <input value="${article.code}" type="text" name="code" class="form-control" id="code" placeholder="Enter Article Code">
            </div>
        </div>

        <div class="form-group row">
            <label for="name" class="col-sm-2 col-form-label">Name</label>
            <div class="col-sm-10">
                <input value="${article.name}" type="text" name="name" class="form-control" id="name" placeholder="Enter Article Name">
            </div>
        </div>

        <div class="form-group row">
            <label for="price" class="col-sm-2 col-form-label">Price</label>
            <div class="col-sm-10">
                <input value="${article.price}" type="number" name="price" class="form-control" id="price" placeholder="Enter Article Price">
            </div>
        </div>

        <div class="form-group row">
            <label for="description" class="col-sm-2 col-form-label">Description</label>
            <div class="col-sm-10">
                <input value="${article.description}" type="text" name="description" class="form-control" id="description" placeholder="Enter Article Description">
            </div>
        </div>

        <button type="submit" class="btn btn-success">Update Article</button>
    </form>
</div>

</body>
</html>
