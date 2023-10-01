<%-- 
    Document   : newjsp
    Created on : 3 thg 3, 2023, 07:45:30
    Author     : 84384
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--1-->
        <c:out value="Welcome to jstl lesson"/>
        <br/>
        <!--2-->
        <c:set value="8000" var="i"/>
        <c:out value="${i}"/>
        <!--3-->
        <c:remove var="i"/>
        <c:out value="${i}"/>
        <!--`4-->
        <c:catch var="exception">
            <% int x = 5 / 0;%>
        </c:catch>
        <c:if test = "${exception != null}">
            <p>The exception is : ${catchException} <br />
                There is an exception: ${catchException.message}</p>
            </c:if>
        <!--5-->
        <c:set value="${900}" var="i"/>
        <c:out value="${i}"/>
        <c:when test="${i<10000}">
            <p>good</p>
        </c:when>
        <c:when test="${i>10000}">
            <p>good</p>
        </c:when>
        <c:otherwise>
            ....
        </c:otherwise>
    </body>
</html>
