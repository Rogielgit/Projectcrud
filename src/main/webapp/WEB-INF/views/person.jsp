<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>


<html>
<head>
    <title>Person Page</title>
    <link rel='stylesheet' href='webjars/bootstrap/3.3.7/css/bootstrap.min.css'>

    <script type="text/javascript">
        function mensagemStatus() {

            var value = document.getElementById("inputText").value;
            if (value.length <= 0)
                alert("User not inserted, please put the name of user");
            else
                alert("user registered success!!");
        }
    </script>


    <style type="text/css">
        input {
            margin: 5px;

        }
    </style>
</head>
<body style="margin-left: 40%;">
<h1>Register</h1>
<c:url var="addAction" value="/"></c:url>

<form:form action="${addAction}" commandName="person">
    <table>

        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input id="inputText" path="name"/>

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
            <td colspan="2">

                <c:if test="${empty person.name}">
                    <input class="btn-primary" type="submit" onclick='mensagemStatus()'
                           value="Add Person"/>
                </c:if>

            </td>
        </tr>
    </table>

</form:form>
<form action="/list" method="get">
    <input class="btn-primary" type="submit"
           value="List user"/>
</form>
<br>
</body>
</html>
