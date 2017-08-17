<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="io.github.oliviercailloux.y2017._biblio1.modele.Person1"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>List of Works</h1>
            <table>
                <tr>
                    <th>
                        ID
                    </th>
                    <th>
                        TITLE
                    </th>
                    <th>
                        DATE
                    </th>
                    <th>
                        AUTHORS
                    </th>
                    <th>
                        ACTIONS
                    </th>
                </tr>
                <c:forEach items="${works}" var="work">
                    <tr>
                        <td>${work.id}</td>
                        <td>${work.title}</td>
                        <td>${work.date}</td>
                        <td>
                           <ul>
                                <c:forEach items="${work.pers}" var="p">
                                    <li>${p.firstName} ${p.lastName}</li>
                                </c:forEach>
                            </ul>
                        </td>
                        <td>
                            <a href="editWork?id_work=${work.id}">edit</a>&nbsp;
                            <a href="deleteWork?id_work=${work.id}">delete</a>
                        </td>
                    <tr>
                </c:forEach>
            </table>    
    </body>
</html>
