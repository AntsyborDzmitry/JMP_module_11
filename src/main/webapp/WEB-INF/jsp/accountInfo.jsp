<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Spring MVC</title>
    </head>
    <body>
    <table>
        <tr>
            <th>#</th>
            <th>name</th>
            <th>amount</th>
        </tr>
        <c:forEach var="person" items="${persons}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${person.name}</td>
                <td>${person.age}</td>
            </tr>
        </c:forEach>
    </table>
<button onclick="location.href='/spring_MVC/accountInfo/addPage'">Put</button>
<button onclick="location.href='/spring_MVC/accountInfo/withdrawPage'">Get</button>

    </body>
</html>