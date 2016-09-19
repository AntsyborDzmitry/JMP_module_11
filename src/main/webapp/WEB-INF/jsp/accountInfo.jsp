<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Spring MVC</title>
        <link type="text/css" href="/spring_MVC/webResources/css/accountPage.css" rel="stylesheet" />
    </head>
    <body>
        <table>
            <tr>
                <th>#</th>
                <th>name</th>
                <th>balance</th>
            </tr>
            <c:forEach var="person" items="${persons}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${person.name}</td>
                    <td>${person.balance}</td>
                </tr>
            </c:forEach>
        </table>
        <div class= "buttons">
            <button onclick="location.href='/spring_MVC/accountInfo/addPage'">Put</button>
            <button onclick="location.href='/spring_MVC/accountInfo/withdrawPage'">Get</button>
            <button onclick="location.href='/spring_MVC/accountInfo/createPage'">Create</button>
        </div>
    </body>
</html>