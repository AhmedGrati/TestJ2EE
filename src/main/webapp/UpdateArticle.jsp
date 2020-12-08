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
</head>
<body>
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
