<%-- 
    Document   : newjsp1
    Created on : 3 thg 3, 2023, 08:22:57
    Author     : 84384
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <!--1-->
        <p>------------1-----------</p>
        <c:set value=".wwwhihehu.www.emeowndha" var="str"></c:set>
        <c:out value="${str}"></c:out>
        <c:if test = "${fn:contains(str, 'hi')}">
            <p>Found 'hi' string<p>
            </c:if>
            <!--2-->
        <p>------------2-----------</p>
        <c:if test = "${fn:endsWith(str, '.net')}">
            <p>found '.net' in end string<p>
            </c:if>
            <!--3-->
        <p>------------3-----------</p>
        <c:if test = "${fn:startsWith(str, '.www')}">
            <p>found '.net' in end string<p>
            </c:if>    
            <!--4-->
        <p>------------4-----------</p>
        <c:out value="this index of: ${fn:indexOf(str,'meow')}"></c:out>
            <!--5-->
            <p>------------5-----------</p>
            <br/>
        <c:set value="" var="s"></c:set>
        <c:set value="One,Two,Three,Four,Five" var="st"></c:set>
        <c:set value="${fn:split(st, ',')}" var="arr"></c:set>

        <c:out value="after join: ${fn:join(arr, s)}"></c:out>
            <!--6-->
            <p>------------6-----------</p>
            <br/>
        <c:out value="length: ${fn:length(st)}"></c:out>
            <!--7-->
            <p>------------7-----------</p>
            <br/>
        <c:set value="One,Two,Three,Four,Five" var="st"></c:set>
        <c:out value="after replace: ${fn:replace(st, ',', ' ')}"></c:out>
            <!--8-->
            <p>------------8-----------</p>
            <br/>
        <c:out value="${fn:substring(str, 2, 7)}"></c:out>
            <!--9-->
            <p>------------9-----------</p>
            <br/>
        <c:out value="before: ${str}"></c:out>
            <br/>
        <c:out value="after after ${fn:substringAfter(str, 'meow')}"></c:out> <br/>
        <c:out value="after before${fn:substringBefore(str, 'meow')}"></c:out>
            <br/>
            <!--10-->
            <p>------------10-----------</p>
            <br/>
        <c:out value="before: ${str}"></c:out>
            <br/>
        <c:out value="after upper ${fn:toUpperCase(str)}"></c:out>
            <br/>
        <c:out value="after lower  ${fn:toLowerCase(str)}"></c:out>
    </body>
</html>
