<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- for conditionals --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> <%-- for <form:form> usage --%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<%--
  Created by IntelliJ IDEA.
  User: ladam
  Date: 11/27/2018
  Time: 6:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title of the page</title>
</head>
<body>


<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <c:if test="${param.logout != null}">
        <i>You have been logged out!</i>
    </c:if>
    <input type="submit" value="Logout"/>
</form:form>


<h2>Home Page</h2>
<hr>
<p>Welcome to the home page!</p>


<%-- display user name and role --%>
<p>
    User: <security:authentication property="principal.username"/>
    <br><br>
    Role(s): <security:authentication property="principal.authorities"/>
</p>

<security:authorize access="hasRole('MANAGER')">
    <%-- Add a link to point to /leaders .. this is for the managers --%>
    <hr>
    <p>
        <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a> (Only for Managers)
    </p>
    <hr>
</security:authorize>

<security:authorize access="hasRole('ADMIN')">
    <%-- Add a link to point to /leaders .. this is for the managers --%>
    <hr>
    <p>
        <a href="${pageContext.request.contextPath}/systems">Systems</a> (Only for Admins)
    </p>
    <hr>
</security:authorize>
</body>
</html>
