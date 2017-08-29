<%-- 
    Document   : listItem
    Created on : 20 août 2017, 18:28:47
    Author     : mrubrice
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="io.github.oliviercailloux.y2017._biblio1.modele.*" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ITEM</title>
    </head>
    <body>
        <h1>List of Items</h1>
            <table>
                <tr>
                    <th>
                        ID
                    </th>
                    <th>
                        IDENTIFIER
                    </th>
                    <th>
                        PROVENANCE
                    </th>
                    <th>
                        EXIBITION DATE
                    </th>
                    <th>
                        MANIFESTATION ID & Title
                    </th>
                    <th>
                        ACTIONS
                    </th>
                </tr>
                <c:forEach items="${items}" var="item">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.identifier}</td>
                        <td>${item.provenance}</td>
                        <td>${item.exhibitionDate}</td>
                        <td>
                            <a href="editItem?id_item=${item.id}">edit</a>&nbsp;
                            <a href="deleteItem?id_item=${item.id}">delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
    </body>
</html>
