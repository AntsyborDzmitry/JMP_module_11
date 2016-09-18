<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Spring MVC</title>
    </head>
    <body>
       <div class="withdraw">
            <form method="post" modelAttribute="person" action="/spring_MVC/accountInfo/withdraw">
                Name:  <form:input path="name" type="text" />
                Amount:  <form:input path="age" type="text" />
                <input type="submit" value="put" />
                <form:errors path="name" />
            </form>
       </div>
    </body>
</html>




