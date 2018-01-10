<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: viacheslav
  Date: 10.01.18
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Users check</title>
</head>
<spring:form modelAttribute="userFromServer" method="post" action="/users/check">
    <spring:input path="username"/>
    <spring:input path="password"/>
    <spring:button>check user</spring:button>
</spring:form>
</html>
