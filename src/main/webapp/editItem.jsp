<%-- 
    Document   : editList
    Created on : 21 août 2017, 13:54:35
    Author     : mrubrice
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="io.github.oliviercailloux.y2017._biblio1.modele.Item" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Item</title>
    </head>
    <body>
        <h1>Edit a Item</h1>
        <form action="editItem" method="POST">
            <fieldset>
                <h2> Item </h2>
                <p>
                    <label for="dtI">Exhibition Date :</label>
                    <input name="dtI" id="dtI" type="date" value="${item.exhibitionDate}"/>
                    
                    <label for="prov">Provenance :</label>
                    <input name="prov" id="prov" type="text" value="${item.provenance}"/>
                    
                    <label for="ident">Identifier :</label>
                    <input name="ident" id="ident" type="text" value="${item.identifier}"/>
                    
                    <input name="id_item" type="hidden" value="${param.id_item}"/></br></br>
                    
                    Expression :
                    <ul>
                    <c:forEach items="${item.manifs}" var="man">
                        <li>${man.id} | ${man.title}</li>
                    </c:forEach>
                    </ul>
                </p>
            </fieldset>
            <p>
                <input type="submit" value="Submit" />
                <input type="reset" value="Reset" />
            </p>
        </form>
    </body>
</html>
