<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="io.github.oliviercailloux.y2017._biblio1.modele.*"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <title>List of WorksS</title>
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
                        FORM
                    </th>
                    <th>
                        CONTEXT
                    </th>
                    <th>
                        INTENDED AUDIENCE
                    </th>
                    <th>
                        DISTINCT CHARACTERISTICS
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
                        <td>${work.form}</td>
                        <td>${work.context}</td>
                        <td>${work.intendedAudience}</td>
                        <td>${work.distinctCharacteristic}</td>
                        <td>
                           <ul>
                                <c:forEach items="${work.pers}" var="p">
                                    <li>${p.firstName} ${p.lastName}</li>
                                </c:forEach>
                            </ul>
                        </td>&nbsp;
                        <td>
                            <a href="editWork?id_work=${work.id}">edit</a>&nbsp;
                            <a href="deleteWork?id_work=${work.id}">delete</a>
                        </td>
                    <tr>
                </c:forEach>
            </table>    
    </body>
</html>
