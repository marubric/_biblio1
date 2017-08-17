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
        <h1>Add a Work</h1>
        <form action="addWork" method="POST">
            <fieldset>
                <h2> WORK </h2>
                <p>
                    <label for="title">Title :</label>
                    <input name="title" id="title" type="text" />
                    
                    <label for="form">Type of work :</label>
                    <input name="form" id="form" type="text"/></br>
                    
                    <label for="dateW">Date :</label>
                    <input name="dateW" id="dateW" type="date"/>
                    
                    <label for="context">Context :</label>
                    <input name="context" id="context" type="text"/></br>
                    
                    <label for="distCha">Distinct Characteristic :</label>
                    <input name="distCha" id="distCha" type="text"/>
                    
                    <label for="intendA">Intended Audience :</label>
                    <input name="intendA" id="intendA" type="text"/>
                    
                    Auteur :
                    <select name="id_author">
                        <c:forEach items="${authors}" var="author">
                            <option value="${author.id}">${author.firstName} ${author.lastName}</option>
                        </c:forEach>
                    </select>
                </p>              
            </fieldset>
            <p>
                <input type="submit" value="Submit" />
                <input type="reset" value="Reset" />
                <input type="button" value="Add an Expression" onclick="document.location.href='addExpression.jsp'"/>
            </p>
        </form>
    </body>
</html>
