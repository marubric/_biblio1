<%-- 
    Document   : listManifestation
    Created on : 20 août 2017, 18:48:57
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
        <title>MANIFESTATION</title>
    </head>
    <body>
        <h1>List of Manifestations</h1>
            <table>
                <tr>
                    <th>
                        ID
                    </th>
                    <th>
                        TITLE
                    </th>
                    <th>
                        EDITION
                    </th>
                    <th>
                        STATEMENT RESPONSIBILITY
                    </th>
                    <th>
                        PUBLICATION PLACE
                    </th>
                    <th>
                        PUBLISHER
                    </th>
                    <th>
                        DATE
                    </th>
                    <th>
                        MANIFESTATION ID
                    </th>
                    <th>
                        SOURCE ACQUISITION
                    </th>
                    <th>
                        TYPE FACE
                    </th>
                    <th>
                        MANIFESTATION ID & TITLE
                    </th>
                    <th>
                        ITEM ID & IDENTIFIER
                    </th>
                    <th>
                    </th>
                </tr>
                <c:forEach items="${manifs}" var="man">
                    <tr>
                            <td>${man.id}</td>
                            <td>${man.title}</td>
                            <td>${man.edition}</td>
                            <td>${man.date}</td>
                            <td>${man.publisher}</td>
                            <td>${man.publicationPlace}</td>
                            <td>${man.statementResponsibility}</td>
                            <td>${man.manifestationID}</td>
                            <td>${man.sourceAcquisition}</td>
                            <td>${man.typeFace}</td>
                            <td>${man.expr.id} ${man.expr.title}</td>
                            <td>${man.itm.id} ${man.itm.identifier}</td>
                        <td>
                            <a href="editManifestation?id_manif=${man.id}">edit</a>&nbsp;
                            <a href="deleteManifestation?id_manif=${man.id}">delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
    </body>
</html>
