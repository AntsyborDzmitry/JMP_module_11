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
        <c:forEach var="person" items="${persons}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${person.name}</td>
                <td>${person.age}</td>
            </tr>
        </c:forEach>
    </table>
    <select id="name" name="name">
       <option value="1">John</option>
       <option value="2">Bill</option>
       <option value="3">Peter</option>
    </select>
       <div class="add">
           <form method="post" modelAttribute="person"  action="/spring_MVC/accountInfo/add">
                Name:  <form:input path="name" type="text" />
                Amount:  <form:input path="age" type="text" />
                <input type="submit" value="put" />
                <form:errors path="name" />
           <form>
       <div>
       <div class="add">
           <form method="post" modelAttribute="person" action="/spring_MVC/accountInfo/withdraw">
                 Name:  <form:input path="name" type="text" />
                 Amount:  <form:input path="age" type="text" />
                 <input type="submit" value="put" />
                 <form:errors path="name" />
           </form>
       <div>
       <div class="add">
           <form method="GET"  action="/spring_MVC/accountInfo">
              <form:input path="name" type="text" />
                  Name:  <form:input path="age" type="text" />
                  <input type="submit" value="check" />
                  <form:errors path="name" />
           <form>
       <div>
    </body>
</html>