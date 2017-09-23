<%--
  Created by IntelliJ IDEA.
  User: rogiel
  Date: 15/09/17
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Person Page</title>
    <link rel='stylesheet' href='../webjars/bootstrap/3.3.7/css/bootstrap.min.css'>

    <script>
        function Sucess(string) {
            alert(string);
        }

        function erro(string) {
            alert(string);
        }
    </script>
<style>
    input {
        margin: 5px;
    }
</style>
</head>
<body style="margin-left: 40%;">
<h1>Update Person</h1>


<form:form action="${addAction}" commandName="person">
    <table>
        <c:if test="${!empty person.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>

                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="country">
                    <spring:message text="Country"/>
                </form:label>
            </td>
            <td>
                <form:input path="country"/>
            </td>
        </tr>
        <tr>
            <td colspan="3">
                <c:if test="${!empty person.name}">
                    <form action="/edit/${person.id}" method="post">
                        <input class="btn-primary" onclick='Sucess("Sucess in uptade user")' type="submit"
                               value="<spring:message text="Edit Person"/>"/>
                    </form>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
</body>
</html>
