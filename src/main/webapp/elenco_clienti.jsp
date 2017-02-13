<%-- 
    Document   : elenco_clienti
    Created on : 13-feb-2017, 13.56.26
    Author     : tss
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Elenco clienti </title>
    </head>
    <body>
        <table style="margin: 0px auto; border: solid 1px black">            
            <th>ID</th>
            <th>Ragione Sociale</th>
            <th>Indirizzo</th>
            <c:forEach items="${clienteSrv.findAll()}" var="cli">
                <tr>
                    <td><c:out value="${cli.id_cliente}"/></td>
                    <td><c:out value="${cli.ragioneSociale}"/></td>
                    <td><c:out value="${cli.indirizzo}"/></td>               
                </tr>
            </c:forEach>
        </table>
         <a href="index.html">Torna ad index</a>
    </body>
</html>
