<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Spring MVC</title>
    </head>
    <body>
       <div class="add">
           <form:form method="post" commandName="person"  action="add">
                Name:  <form:input path="name"/>
                Amount:  <form:input path="balance" />
                <input type="submit" value="put" />
           </form:form>
       </div>

    </body>
</html>