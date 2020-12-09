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
    <form action="updateUser" method="post">
        <div hidden class="form-group row">
            <label for="id" class="col-sm-2 col-form-label">Description</label>
            <div class="col-sm-10">
                <input value="${user.id}" type="text" name="id" class="form-control" id="id" placeholder="Enter Article Description">
            </div>
        </div>
        <div class="form-group row">
            <label for="firstName" class="col-sm-2 col-form-label">First Name</label>
            <div class="col-sm-10">
                <input value="${user.firstName}" type="text" name="firstName" class="form-control" id="firstName" placeholder="Enter First Name">
            </div>
        </div>

        <div class="form-group row">
            <label for="lastName" class="col-sm-2 col-form-label">Last Name</label>
            <div class="col-sm-10">
                <input value="${user.lastName}" type="text" name="lastName" class="form-control" id="lastName" placeholder="Enter Last Name">
            </div>
        </div>

        <div class="form-group row">
            <label for="age" class="col-sm-2 col-form-label">Age</label>
            <div class="col-sm-10">
                <input value="${user.age}" type="number" name="age" class="form-control" id="age" placeholder="Enter Age">
            </div>
        </div>

        <div class="form-group row">
            <label for="email" class="col-sm-2 col-form-label">Email</label>
            <div class="col-sm-10">
                <input value="${user.email}" type="text" name="email" class="form-control" id="email" placeholder="Enter Email">
            </div>
        </div>

        <div class="form-group row">
            <label for="role" class="col-sm-2 col-form-label">Role</label>
            <div class="col-sm-10">
                <input value="${user.role}" type="text" name="role" class="form-control" id="role" placeholder="Enter Role">
            </div>
        </div>

        <div class="form-group row">
            <label for="password" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-10">
                <input value="${user.password}" type="password" name="password" class="form-control" id="password" placeholder="Enter Password">
            </div>
        </div>

        <button type="submit" class="btn btn-success">Save User</button>
    </form>
</div>

</body>
</html>
