<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="io.github.oliviercailloux.y2017._biblio1.modele.*"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <title>List of ExpressionS</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>List of Expressions</h1>
            <table>
                <tr>
                    <th>
                        ID
                    </th>
                    <th>
                        TITLE
                    </th>
                    <th>
                        FORM
                    </th>
                    <th>
                        DATE
                    </th>
                    <th>
                        LANGUAGE
                    </th>
                    <th>
                        CONTEXT
                    </th>
                    <th>
                        DISTINCT CHARACTERISTIC
                    </th>
                    <th>
                        CRITICAL RESPONSE
                    </th>
                    <th>
                        WORK ID & Title
                    </th>
                    <th>
                        ACTIONS
                    </th>
                </tr><fieldset>
                <c:forEach items="${exprs}" var="expr">
                    <tr>
                        <td>${expr.id}</td>
                        <td>${expr.title}</td>
                        <td>${expr.form}</td>
                        <td>${expr.date}</td>
                        <td>${expr.language}</td>
                        <td>${expr.context}</td>
                        <td>${expr.distinctCharacteristic}</td>
                        <td>${expr.criticalResponse}</td>
                        <td>${expr.work.id}</td>
                        <td>${expr.work.id} | ${expr.work.title}</td>
                        <td>
                            <a href="editExpression?id_expr=${expr.id}">edit</a>&nbsp;
                            <a href="deleteExpression?id_expr=${expr.id}">delete</a>
                        </td>
                    </tr>
                    <c:if test="${not empty expr.manifs}">
                        <tr>
                            <td colspan="3">
                               &nbsp; 
                            </td>
                            <td colspan="6">
                                Manifestations :<br />
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
                                        </th>
                                    </tr>
                                    <c:forEach items="${expr.manifs}" var="man">
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
                                            <td>
                                                <a href="editManifestation?id_manif=${man.id}">edit</a>&nbsp;
                                                <a href="deleteManifestation?id_manif=${man.id}">delete</a>
                                            </td>
                                        </tr></fieldset>
                                    </c:forEach>
                                </table>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>    
    </body>
</html>