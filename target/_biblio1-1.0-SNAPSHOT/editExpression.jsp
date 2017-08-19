<%-- 
    Document   : addExpression
    Created on : 17 août 2017, 14:05:16
    Author     : mrubrice
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="io.github.oliviercailloux.y2017._biblio1.modele.Work" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Expression</title>
    </head>
    <body>
        <h1>Edit an Expression</h1>
        <form action="editExpression" method="POST">
            <fieldset>
                <h2> Expression </h2>
                <p>
                    <label for="titleE">Title :</label>
                    <input name="titleE" id="titleE" type="text" value="${expr.title}"/>&nbsp;&nbsp;
                    
                    <label for="formE">Type of expression :</label>
                    <input name="formE" id="formE" type="text" value="${expr.form}"/></br></br>&nbsp;&nbsp;
                    
                    <label for="dateE">Date :</label>
                    <input name="dateE" id="dateE" type="date" value="${expr.date}"/>&nbsp;&nbsp;
                    
                    <label for="contextE">Context :</label>
                    <input name="contextE" id="contextE" type="text" value="${expr.context}"/></br></br>&nbsp;&nbsp;
                    
                    <label for="distChaE">Distinct Characteristic :</label>
                    <input name="distChaE" id="distChaE" type="text" value="${expr.distinctCharacteristic}"/>&nbsp;&nbsp;
                    
                    <label for="lang">Language :</label>
                    <input name="lang" id="lang" type="text" value="${expr.language}"/>&nbsp;&nbsp;
                    
                    <label for="rep">Critical response :</label>
                    <input name="rep" id="rep" type="text" value="${expr.criticalResponse}"/></br></br>&nbsp;&nbsp;
                    
                    <input name="id_expr" type="hidden" value="${param.id_expr}"/></br></br>
                    Work:
                    <ul>
                        <li>${expr.work.id} | ${expr.work.title}</li>
                    </ul>
                </p>              
            </fieldset>
            <p>
                <input type="submit" value="Submit" />
                <input type="reset" value="Reset" />
                <input type="button" value="Add a Manifestation" onclick="document.location.href='addManifestation.jsp'"/>
            </p>
        </form>
    </body>
</html>
