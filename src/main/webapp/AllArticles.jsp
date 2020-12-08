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
</head>
<body>

    <div class="container">
        <div>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Code</th>
                    <th scope="col">Name</th>
                    <th scope="col">Price</th>
                    <th scope="col">Description</th>
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
                            <a href="deleteArticle?id=${article.id}">
                                <button class="btn"><i class="fa fa-trash"></i></button>
                            </a>
                            <a href="updateArticle?id=${article.id}">
                                <button class="btn"><i class="fa fa-edit"></i></button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div>
            <a href="addArticle?id=${article.id}">
                <button class="btn btn-primary">Add Article <i class="fa fa-plus"></i></button>
            </a>
        </div>
    </div>

</body>
</html>
