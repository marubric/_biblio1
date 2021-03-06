<%-- 
    Document   : addManifestation
    Created on : 17 août 2017, 14:17:43
    Author     : mrubrice
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="io.github.oliviercailloux.y2017._biblio1.modele.*" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manifestation</title>
    </head>
    <body>
        <h1>Add an Manifestation to an Expression </h1>
        <form action="editManifestation" method="POST">
            <fieldset>
                <h2> Manifestation </h2>
                <p>
                    <label for="manID">Manifestation ID :</label>
                    <input name="manID" id="manID" type="text" value="${manif.manifestationID}"/></br></br>
                    
                    <label for="titleM">Title :</label>
                    <input name="titleM" id="titleM" type="text" value="${manif.title}" />&nbsp;&nbsp;
                    
                    <label for="edition">Edition :</label>
                    <input name="edition" id="edition" type="text" value="${manif.edition}"/></br></br>
                    
                    <label for="dateM">Date :</label>
                    <input name="dateM" id="dateM" type="date" value="${manif.date}"/>&nbsp;&nbsp;
                    
                    <label for="state">Statement responsibility :</label>
                    <input name="state" id="state" type="text" value="${manif.statementResponsibility}"/></br></br>
                    
                    <label for="publication">Publication place :</label>
                    <input name="publication" id="publication" type="text" value="${manif.publicationPlace}"/>&nbsp;&nbsp;
                    
                    <label for="publisher">Publisher :</label>
                    <input name="publisher" id="publisher" type="text" value="${manif.publisher}"/></br></br>
                    
                    <label for="src">Source acquisition :</label>
                    <input name="src" id="src" type="text" value="${manif.sourceAcquisition}"/>&nbsp;&nbsp;
                    
                    <label for="typeF">Type face :</label>
                    <input name="typeF" id="typeF" type="text" value="${manif.typeFace}"/></br></br>
                    
                    <input name="id_manif" type="hidden" value="${param.id_manif}"/></br></br>
                </p>              
                Expression:
                <select name="id_Expr">
                    <c:forEach items="${exprs}" var="expr">
                        <option value="${expr.id}">${expr.id} | ${expr.title}</option>
                    </c:forEach>
                </select>
                Item:
                <select name="id_Item">
                    <c:forEach items="${items}" var="itm">
                        <option value="${itm.id}">${itm.id} | ${itm.identifier}</option>
                    </c:forEach>
                </select>
                </p>              
            </fieldset>
            <p>
                <input type="submit" value="Submit" />
                <input type="reset" value="Reset" />
                <input type="button" value="Add an Item" onclick="document.location.href='addItem.jsp'"/>
            </p>
        </form>
    </body>
</html>
