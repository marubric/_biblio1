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
                        </td>
                        <td>
                            <a href="editWork?id_work=${work.id}">edit</a>&nbsp;
                            <a href="deleteWork?id_work=${work.id}">delete</a>
                        </td>
                    </tr>
                    <c:if test="${not empty work.exprs}">
                        <tr>
                            <td colspan="1">
                               &nbsp; 
                            </td>
                            <td colspan="9">
                                <h7>Expressions :</h7><fieldset>
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
                                        </th>
                                    </tr>
                                    <c:forEach items="${work.exprs}" var="exp">
                                        <tr>
                                            <td>${exp.id}</td>
                                            <td>${exp.title}</td>
                                            <td>${exp.form}</td>
                                            <td>${exp.date}</td>
                                            <td>${exp.language}</td>
                                            <td>${exp.context}</td>
                                            <td>${exp.distinctCharacteristic}</td>
                                            <td>${exp.criticalResponse}</td>
                                            <td>
                                                <a href="editExpression?id_expr=${exp.id}">edit</a>&nbsp;
                                                <a href="deleteExpression?id_expr=${exp.id}">delete</a>
                                            </td>
                                        </tr>
                                        <c:if test="${not empty exp.manifs}">
                                            <tr>
                                                <td colspan="2">
                                                   &nbsp; 
                                                </td>
                                                <td colspan="10">
                                                    </br><h7>Manifestations :</h7>
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
                                                        <c:forEach items="${exp.manifs}" var="man">
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
                                                        </c:forEach><hr>
                                                    </table>
                                                </td>
                                            </tr>
                                        </c:if><hr>
                                    </c:forEach>
                                </table>
                            </td></fieldset>
                        </tr>
                    </c:if> 
            </c:forEach>
        </table> 
    </body>
</html>