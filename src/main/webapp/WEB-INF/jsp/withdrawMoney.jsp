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
           <form:form method="get" commandName="person"  action="withdraw">
                Name:  <form:input path="name"/>
                Amount:  <form:input path="balance" />
                <input type="submit" value="get" />
           </form:form>
       </div>
    </body>
</html>
