<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="io.github.oliviercailloux.y2017._biblio1.modele.Work"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Edit a Work</h1>
        <form action="editWork" method="POST">
            <fieldset>
                <h2> WORK </h2>
                <p>
                    <label for="title">Title :</label>
                    <input name="title" id="title" type="text" value="${work.title}"/>&nbsp;
                    
                    <label for="form">Type of work :</label>
                    <input name="form" id="form" type="text" value="${work.form}"/></br></br> 
                    
                    <label for="dateW">Date :</label>
                    <input name="dateW" id="dateW" type="date" value="${work.date}"/>&nbsp;
                    
                    <label for="context">Context :</label>
                    <input name="context" id="context" type="text" value="${work.context}"/></br></br>
                    
                    <label for="distCha">Distinct Characteristic :</label>
                    <input name="distCha" id="distCha" type="text" value="${work.distinctCharacteristic}"/>&nbsp;
                    
                    <label for="intendA">Intended Audience :</label>
                    <input name="intendA" id="intendA" type="text" value="${work.intendedAudience}"/>
                    
                    <input name="id_work" type="hidden" value="${param.id_work}"/></br></br>
                    
                    Auteurs :
                    <ul>
                    <c:forEach items="${work.pers}" var="author">
                        <li>${author.firstName} ${author.lastName}</li>
                    </c:forEach>
                    </ul>
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
