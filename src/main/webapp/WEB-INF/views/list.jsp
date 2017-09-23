<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--
  Created by IntelliJ IDEA.
  User: rogiel
  Date: 13/09/17
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
    <link rel='stylesheet' href='webjars/bootstrap/3.3.7/css/bootstrap.min.css'>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }


    </style>

</head>
<body style="margin-left: 40%;">
<h3 style="">List of User</h3>


<a href="<c:url value='/'/>" ><img style="width: 10%; height: 5%; margin-left: -400px;" src="../../resources/img/seta.png"></a>


<table class="tg">
    <tr>
        <th width="80">Person ID</th>
        <th width="120">Person Name</th>
        <th width="120">Person Country</th>
        <th width="50"></th>
        <th width="80"></th>

    </tr>

    <c:forEach items="${listOfPersons}" var="list">

        <tr>
            <td>${list.id}</td>
            <td>${list.name}</td>
            <td>${list.country}</td>
            <td>
                <form method="get" action="/edit/${list.id}">
                    <input class="btn-primary" type="submit" value="Edit"> </input>
                </form>
            </td>

            <td>
                <form method="post" if-none-match="*" action="/${list.id}">
                    <input class="btn-primary" type="submit"   value="Delete"> </input>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
